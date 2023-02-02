package edu.ucr.cs.cs226.mkim410;

import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class AppB {
    public static void main( String[] args ) {
        // check the length of command line args
        if (args.length != 1) {
            System.err.println("Incorrect number of arguments! Expected one argument.");
            System.exit(-1);
        }

        // Store the two arguments in local variables of type org.apache.hadoop.fs.Path
        Path input = new Path(args[0]);

        // Cet the correct file system for the 2 files of type org.apache.hadoop.fs.FileSystem
        Configuration conf = new Configuration();
        try {
            // Declare Hadoop's FileSystem objects
            FileSystem inputFileSystem = input.getFileSystem(conf);

            // Check whether the input file exists or not
            if (!inputFileSystem.exists(input)) {
                System.err.printf("Input file '%s' does not exist!\n", input);
                System.exit(-1);
            }

            FSDataInputStream inputStream = inputFileSystem.open(input);

            java.nio.file.Path path = Paths.get("/Users/minsookim/Documents/UCR/W23/CS167/workspace/mkim410_lab2/AREAWATER.csv");
            long bytes = java.nio.file.Files.size(path);            
            byte[] buffer = new byte[8192];


            long startTime = System.nanoTime();

            // make 10,000 reads
            for (int i = 0; i < 10000; ++i) {
                // get random position
                long position = ThreadLocalRandom.current().nextLong(bytes);
                System.out.println("reading at postion " + position);

                // reading 8192 bytes
                inputStream.read(position, buffer, 0, 8192);
            }

            long endTime = System.nanoTime();
            System.out.printf("Did 10,000 reads in %f seconds\n", (endTime - startTime) * 1E-9);
        } catch(java.io.IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
