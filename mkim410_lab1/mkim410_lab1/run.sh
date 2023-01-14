rm -rf output.txt || true
mvn package
hadoop jar target/mkim410_lab1-1.0-SNAPSHOT.jar input.txt output.txt
