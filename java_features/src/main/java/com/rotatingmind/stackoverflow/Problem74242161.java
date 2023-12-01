package com.rotatingmind.stackoverflow;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.IntStream;

public class Problem74242161 {

    public static void main(String []args) {
        int decimalPrecision=0;
        String currencySymbol="إ.د";
        String dfSymbolReplacePattern = "د.إ.\u200F";

        Locale locale = new Locale.Builder().setLanguage("ar").setRegion("AE").build();
        final NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        nf.setGroupingUsed(false);
        final DecimalFormat df = (DecimalFormat) nf;

        df.setMinimumFractionDigits(decimalPrecision);
        df.setMaximumFractionDigits(decimalPrecision);
        df.setRoundingMode(RoundingMode.HALF_UP);

        final String positivePrefix = df.getPositiveSuffix().replace(dfSymbolReplacePattern, currencySymbol);
        final String positiveSuffix = df.getPositivePrefix().replace(dfSymbolReplacePattern, currencySymbol);
        final String negativePrefix = df.getNegativeSuffix().replace(dfSymbolReplacePattern, currencySymbol);
        final String negativeSuffix = df.getNegativePrefix().replace(dfSymbolReplacePattern, currencySymbol);
        df.setPositivePrefix(positivePrefix);
        df.setNegativePrefix(negativePrefix);
        df.setPositiveSuffix(positiveSuffix);
        df.setNegativeSuffix(negativeSuffix);

        //System.out.println("Arabic Amount is: " + df.format(10.0));

        IntStream.range(1, 5)
                .forEach(System.out::println);
    }

}
