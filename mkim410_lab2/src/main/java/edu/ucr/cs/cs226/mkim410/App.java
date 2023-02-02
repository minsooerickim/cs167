package edu.ucr.cs.cs226.mkim410;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
//org.apache.hadoop.fs.FileSystem;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {
        // check the length of command line args
        if (args.length != 2) {
            System.err.println("Incorrect number of arguments! Expected two arguments.");
            System.exit(-1);
        }

        // Store the two arguments in local variables of type org.apache.hadoop.fs.Path
        Path input = new Path(args[0]);
        Path output = new Path(args[1]);

        // Cet the correct file system for the 2 files of type org.apache.hadoop.fs.FileSystem
        Configuration conf = new Configuration();
        try {
            // Declare Hadoop's FileSystem objects
            FileSystem inputFileSystem = input.getFileSystem(conf);
            FileSystem outputFileSystem = output.getFileSystem(conf);

            // Check whether the input file exists or not
            if (!inputFileSystem.exists(input)) {
                System.err.printf("Input file '%s' does not exist!\n", input);
                System.exit(-1);
            }
            // Check whether the output file exists or not
            if (outputFileSystem.exists(output)) {
                System.err.printf("Output file '%s' already exists!\n", output);
                System.exit(-1);
            }

            // open the input file and copy all its contents to the output file. (Measure the elapsed time)
            long startTime = System.nanoTime();

            FSDataInputStream inputStream = inputFileSystem.open(input);
            FSDataOutputStream outputStream = outputFileSystem.create(output);

            // copying the file
            int totalBytesCopied = 0;
            int bytesCopied = 0;
            while ((bytesCopied = inputStream.read()) > 0) {
                outputStream.write(bytesCopied);
                totalBytesCopied += bytesCopied;
            }

            long endTime = System.nanoTime();
            System.out.printf("Copied %d bytes from '%s' to '%s' in %f seconds\n", totalBytesCopied, input, output, (endTime - startTime) * 1E-9);

            // closing I/O stream file system after done copying
            inputStream.close();
            outputStream.close();
        } catch(java.io.IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
