package edu.ucr.cs.cs167.mkim410;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Map;

public class Aggregation {
    public static void main(String[] args) {
        final String inputPath = args[0];
        SparkConf conf = new SparkConf();
        if (!conf.contains("spark.master"))
            conf.setMaster("local[*]");
        System.out.printf("Using Spark master '%s'\n", conf.get("spark.master"));
        conf.setAppName("CS167-Lab5");
        try (JavaSparkContext spark = new JavaSparkContext(conf)) {
            JavaRDD<String> logFile = spark.textFile(inputPath).cache();

            PairFunction<String, String, Integer> pairFunction = new PairFunction<String, String, Integer>() {
                @Override
                public Tuple2<String, Integer> call(String s) {
                    String code = s.split("\t")[5];
                    return new Tuple2<String, Integer>(code, 1);
                }
            };
            JavaPairRDD<String, Integer> codes = logFile.mapToPair(pairFunction);// To do 1: transform via `mapToPair`, return `Tuple2`

            Map<String, Long> counts = codes.countByKey();// To do 2: `countByKey`

            // print aggregate values to std out
            // Map.Entry<String, Long> counts_entry = (Map.Entry<String, Long>) counts.entrySet();
            java.util.Set<Map.Entry<String, Long>> counts_entry = counts.entrySet();
            for (Map.Entry<String, Long> entry: counts_entry) {
                System.out.println("Code '" + entry.getKey() + "' : number of entries " + entry.getValue());
            }

            for (Map.Entry<String, Long> entry : counts.entrySet()) {
                System.out.printf("Code '%s' : number of entries %d\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
