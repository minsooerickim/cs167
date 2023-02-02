# Lab 2

## Student information

* Minsoo Kim
* mkim410@ucr.edu
* mkim410
* 862238343

## Answers

* (Q1) Verify the file size and report the running time.
    - Copied 2027097262 bytes from 'AREAWATER.csv' to 'AREAWATER_OUTPUT.csv' in 106.995681 seconds
* (Q2) Report the running time of the copy command.
    - cp AREAWATER.csv AREAWATER_LOCAL_COPY.csv  0.00s user 0.73s system 46% cpu 1.577 total
* (Q3) How do the two numbers compare? (The running times of copying the file through your program and the operating system.) Explain IN YOUR OWN WORDS why you see these results.
  - Using the program to copy the file uses Hadoop's API. This is an extra middleware that we need to go through that we normally wouldn't have to go through when we use the normal cp command. Thus, the program takes longer to copy the file comapred to using the local cp command.
* (Q4) Does the program run after you change the default file system to HDFS? What is the error message, if any, that you get?
    - No, I get an Exception. Specifically, java.lang.ClassNotFoundException: AREAWATER.csv. I think the program can't locate the csv file we are trying to copy over. We might need to use absolute paths or perhaps the file:// protocal when specifying the paths of the different files.
* (Q5) Use your program to test the following cases and record the running time for each case.
    - a) Copy a file from local file system to HDFS
      - Copied 2027097262 bytes from 'file:/Users/minsookim/Documents/UCR/W23/CS167/workspace/mkim410_lab2/AREAWATER.csv' to 'hdfs:/user/mkim410/AREAWATER.csv' in 119.134584 seconds
    - b) Copy a file from HDFS to local file system.
      - Copied 2027097262 bytes from 'hdfs:/user/mkim410/AREAWATER.csv' to 'file:/Users/minsookim/Documents/UCR/W23/CS167/workspace/mkim410_lab2/HDFS_TO_LOCAL.csv' in 400.623216 seconds
    - c) Copy a file from HDFS to HDFS.
      - Copied 2027097262 bytes from 'hdfs:/user/mkim410/AREAWATER.csv' to 'hdfs:/user/mkim410/AREAWATER_HDFS_TO_HDFS.csv' in 393.789502 seconds

        | AREAWATER.csv | AREAWATER_COPY.csv | Time (in seconds)
        | ------------- |:-------------:| -----:|
        | Local | HDFS | 119.134584 | 
        | HDFS | Local | 400.623216 |
        | HDFS | HDFS  | 393.789502 |
* (Q6) (Bonus) Test your program on two files, one file stored on the local file system, and another file stored on HDFS. Compare the running times of both tasks. What do you observe?
    - 10,000 reads on local AREAWATER.csv
        - Did 10,000 reads in 2.777412 seconds
    - 10,000 reads on hdfs AREAWATER.csv
        - Did 10,000 reads in 6.222286 seconds

            | AREAWATER.csv  | Time (in seconds)
            | ------------- |:-------------:|
            | Local  | 2.777412 | 
            | HDFS  | 6.222286 |





