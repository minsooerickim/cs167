mvn package

echo type in the input file name?
read file_name

echo doing work on $file_name

spark-submit --class edu.ucr.cs.cs167.mkim410.Filter target/mkim410_lab5-1.0-SNAPSHOT.jar $file_name filter_output 302 2>/dev/null
spark-submit --class edu.ucr.cs.cs167.mkim410.Aggregation target/mkim410_lab5-1.0-SNAPSHOT.jar $file_name 2>/dev/null