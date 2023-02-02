mvn package

hadoop jar target/mkim410_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs226.mkim410.App  file://`pwd`/AREAWATER.csv hdfs:///user/mkim410/AREAWATER.csv
hadoop jar target/mkim410_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs226.mkim410.App hdfs:///user/mkim410/AREAWATER.csv file://`pwd`/HDFS_TO_LOCAL.csv
hadoop jar target/mkim410_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs226.mkim410.App hdfs:///user/mkim410/AREAWATER.csv file://`pwd`/AREAWATER_HDFS_TO_HDFS.csv

hadoop jar target/mkim410_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs226.mkim410.AppB file://`pwd`/AREAWATER.csv
hadoop jar target/mkim410_lab2-1.0-SNAPSHOT.jar edu.ucr.cs.cs226.mkim410.AppB hdfs:///user/minsookim/AREAWATER.csv

echo "Done running all 5 cases"