package ai;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.deeplearning4j.datasets.iterator.impl.IrisDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.api.IterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class HousePricePredictor {

    /**
     * What This Code Does:
     *
     * Reads the CSV file.
     * Converts data into feature matrix (inputFeatures) and price values (outputLabels).
     */
    public static void main(String[] args) {
        // Load CSV Data
        List<double[]> features = new ArrayList<>();
        List<Double> labels = new ArrayList<>();
        File file = getFileFromResources("house_prices.csv");
        try (Reader reader = new FileReader(file);
             CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT.builder()
                     .setHeader()
                     .setSkipHeaderRecord(true)
                     .build())) {
            for (CSVRecord record : parser) {
                double squareFeet = Double.parseDouble(record.get("square_feet"));
                double bedrooms = Double.parseDouble(record.get("bedrooms"));
                double bathrooms = Double.parseDouble(record.get("bathrooms"));
                double price = Double.parseDouble(record.get("price"));

                features.add(new double[]{squareFeet, bedrooms, bathrooms});
                labels.add(price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert Lists to ND4J Arrays
        try(INDArray inputFeatures = Nd4j.create(features.toArray(new double[0][]));
            INDArray outputLabels = Nd4j.create(labels.stream().mapToDouble(d -> d).toArray())) {

            System.out.println("Features:\n" + inputFeatures);
            System.out.println("Labels:\n" + outputLabels);

            DataSet dataSet = new DataSet(inputFeatures, outputLabels);

            DataSetIterator dataSetIterator = dataSet.iterateWithMiniBatches();
            // Normalize Data
            NormalizerStandardize normalizer = new NormalizerStandardize();
            normalizer.fit(dataSetIterator);
            normalizer.transform(inputFeatures);

            // Define Neural Network
            MultiLayerNetwork model = new MultiLayerNetwork(new NeuralNetConfiguration.Builder()
                    .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                    .updater(new Adam(0.01))
                    .list()
                    .layer(new DenseLayer.Builder().nIn(3).nOut(10).activation(Activation.RELU).build())
                    .layer(new OutputLayer.Builder(LossFunctions.LossFunction.MSE)
                            .nIn(10).nOut(1).activation(Activation.IDENTITY).build())
                    .build());
            model.init();

            // Train Model
            DataSet trainingData = new DataSet(inputFeatures, outputLabels);
            model.fit(trainingData, 1000);

            // Test Model
            INDArray testInput = Nd4j.create(new double[][]{{2000, 3, 2}});
            normalizer.transform(testInput);
            INDArray prediction = model.output(testInput);

            System.out.println("Predicted Price: " + prediction);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    // Utility method to load file from resources as File object
    public static File getFileFromResources(String fileName) {
        ClassLoader classLoader = HousePricePredictor.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        return new File(resource.getFile());
    }
}
