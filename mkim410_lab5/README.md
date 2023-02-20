# Lab 5

## Student information

* Full name: Minsoo Kim
* E-mail: mkim410@ucr.edu
* UCR NetID: mkim410
* Student ID: 862238343

## Answers

* (Q1) Do you think it will use your local cluster? Why or why not?
  * No new applications showed up on my web interface for spark master on `localhost:8080` so I think it uses my local cluster.
* (Q2) Does the application use the cluster that you started? How did you find out?
  * Yes, I refreshed my web interface for spark master on `localhost:8080` and a new application with the id, `app-20230207234736-0000`, and name , `CS167-Lab5`, showed up under the `Running Applications` tab.
* (Q3) What is the Spark master printed on the standard output on IntelliJ IDEA?
  * `Using Spark master 'local[*]''`
  * `Number of lines in the log file 30970`
  * `Process finished with exit code 0`
* (Q4) What is the Spark master printed on the standard output on the terminal?
  * `Using Spark master 'spark://127.0.0.1:7077'`
  * `Number of lines in the log file 30970`
* (Q5) For the previous command that prints the number of matching lines, list all the processed input splits.
  * `23/02/08 00:00:29 INFO HadoopRDD: Input split: file:/Users/minsookim/Documents/UCR/W23/CS167/workspace/mkim410_lab5/nasa_19950801.tsv:1169610+1169610`
  * `23/02/08 00:00:29 INFO HadoopRDD: Input split: file:/Users/minsookim/Documents/UCR/W23/CS167/workspace/mkim410_lab5/nasa_19950801.tsv:0+1169610`
* (Q6) For the previous command that counts the lines and prints the output, how many splits were generated?
  * `2023-02-08 00:05:11,148 INFO rdd.HadoopRDD: Input split: hdfs://localhost:9000/user/minsookim/nasa_19950801.tsv:1169610+1169610`
  * `2023-02-08 00:05:11,148 INFO rdd.HadoopRDD: Input split: hdfs://localhost:9000/user/minsookim/nasa_19950801.tsv:0+1169610`
  * `2023-02-08 00:05:11,148 INFO rdd.HadoopRDD: Input split: hdfs://localhost:9000/user/minsookim/nasa_19950801.tsv:1169610+1169610`
  * `2023-02-08 00:05:11,148 INFO rdd.HadoopRDD: Input split: hdfs://localhost:9000/user/minsookim/nasa_19950801.tsv:0+1169610`
  * I found 4 input splits but 2 of them were the same

* (Q7) Compare this number to the one you got earlier.
  * For Q5) I only got 2 splits but I got 4 splits in Q6)
* (Q8) Explain why we get these numbers.
  * Since 2 of the input splits are the same in Q6), that means the file is getting read twice
* (Q9) What can you do to the current code to ensure that the file is read only once?
  * I can use the cache function in Spark. The cache function persist the RDD with the default storage level.
    * JavaRDD<String> logFile = spark.textFile(inputPath).cache();