# Lab 1

## Student Information
* Minsoo Kim
* mkim410@ucr.edu
* mkim410
* 862238343

## Answers

* (Q1) What is the name of the created directory? 

  * mkim410_lab1

* (Q2) What do you see at the console output?
  * Hello World!

* (Q3) What do you see at the output?
  * I see an Exception Error in the console. Specifically I see a ArrayIndexOutOfBounds Exception
  * Below is the actual error that I was presented with.
    ```
    log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
    log4j:WARN Please initialize the log4j system properly.
    log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
    Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
    at edu.ucr.cs.cs167.mkim410.App.main(App.java:60)

    Process finished with exit code 1
    ```

* (Q4) What is the output that you see at the console?
  * I get 3 warnings but no errors. In fact, at the bottom it says “Process finished with
  exit code 0”. However, nothing else is created or outputted to the console.

  * below is the actual error that I was presented with.
    ```
    log4j:WARN No appenders could be found for logger (org.apache.hadoop.metrics2.lib.MutableMetricsFactory).
    log4j:WARN Please initialize the log4j system properly.
    log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
    
    Process finished with exit code 0
    ```

* (Q5) Does it run? Why or why not?
  * No, the program doesn’t just use java. It uses hadoop. Also, the program expects
  an input and output file name which isn’t provided in the command

  * below is the actual error that I was presented with.
    ```
    Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/hadoop/conf/Configuration
    at edu.ucr.cs.cs167.mkim410.App.main(App.java:52)
    Caused by: java.lang.ClassNotFoundException: org.apache.hadoop.conf.Configuration
    at java.net.URLClassLoader.findClass(URLClassLoader.java:387)
    at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
    at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:355)
    at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
    ... 1 more
    ```

