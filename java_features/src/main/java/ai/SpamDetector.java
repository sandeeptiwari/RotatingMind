package ai;

import opennlp.tools.doccat.*;
import opennlp.tools.util.*;

import java.io.*;
import java.net.URL;

public class SpamDetector {

    private static DoccatModel model;

    public static void trainModel(String trainingFile) throws IOException {
        File modelFile = getFileFromResources(trainingFile);
        InputStreamFactory dataIn = new MarkableFileInputStreamFactory(modelFile);

        try (ObjectStream<String> lineStream = new PlainTextByLineStream(dataIn, "UTF-8")) {
            ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

            TrainingParameters params = new TrainingParameters();
            params.put(TrainingParameters.ITERATIONS_PARAM, 100);
            params.put(TrainingParameters.CUTOFF_PARAM, 1);

            DoccatFactory factory = new DoccatFactory();
            model = DocumentCategorizerME.train("en", sampleStream, params, factory);

            // Save the trained model
            try (OutputStream modelOut = new FileOutputStream("spam-model.bin")) {
                model.serialize(modelOut);
            }
            System.out.println("Model trained and saved!");
        }

    }

    // Load trained model and classify a message
    public static String classifyMessage(String message) throws IOException {
        if (model == null) {
            model = new DoccatModel(new FileInputStream("spam-model.bin"));
        }

        DocumentCategorizerME categorizer = new DocumentCategorizerME(model);
        double[] outcomes = categorizer.categorize(message.split(" "));

        return categorizer.getBestCategory(outcomes); // Returns "spam" or "ham"
    }

    // Train the spam detection model
    public static void main(String[] args) throws IOException {
        // Train model
        trainModel("trainingData.txt");

        // Test messages
        String testMessage1 = "Congratulations! You won a free iPhone.";
        String testMessage2 = "Hey, let's catch up tomorrow.";

        System.out.println("Message: \"" + testMessage1 + "\" -> " + classifyMessage(testMessage1));
        System.out.println("Message: \"" + testMessage2 + "\" -> " + classifyMessage(testMessage2));
    }

    // Utility method to load file from resources as File object
    public static File getFileFromResources(String fileName) {
        ClassLoader classLoader = SpamDetector.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("File not found in resources: " + fileName);
        }

        return new File(resource.getFile());
    }
}
