# hadoop-examples-mapreduce


```bash
scp /home/matthieu/UbuntuData/IntelliJProjects/hadoop-examples-mapreduce.jar matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io:/home/matthieu.freire.eleuterio/
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password: 
hadoop-examples-mapreduce.jar
```


```bash
ssh matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password: 
Permission denied, please try again.
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password: 
Permission denied, please try again.
matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io's password: 
Last failed login: Fri Jul 12 16:46:11 CEST 2024 from 37.65.60.37 on ssh:notty
There were 3 failed login attempts since the last successful login.
Last login: Fri Jul 12 13:23:07 2024 from 37.65.60.37
[matthieu.freire.eleuterio@bigdata01 ~]$ 
```


```bash
[matthieu.freire.eleuterio@bigdata01 ~]$ ls
hadoop-examples-mapreduce.jar  input.txt
[matthieu.freire.eleuterio@bigdata01 ~]$ hdfs dfs -put input.txt /user/matthieu.freire.eleuterio/
ssh matthieu.freire.eleuterio@bigdata01.efrei.hadoop.clemlab.io
[matthieu.freire.eleuterio@bigdata01 ~]$ hdfs dfs -ls
Found 13 items
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:00 .Trash
drwx------   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 .staging
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio     550589 2024-07-12 13:41 HanselGretel.txt
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:16 data
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 14:57 gutenberg
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:07 gutenberg-output
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-12 15:37 gutenberg-output2
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        253 2024-07-12 17:08 input.txt
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio        553 2024-07-12 15:01 mapper.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-11 21:37 raw
-rw-r--r--   3 matthieu.freire.eleuterio matthieu.freire.eleuterio       1027 2024-07-12 15:01 reducer.py
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:52 wordcount
drwxr-xr-x   - matthieu.freire.eleuterio matthieu.freire.eleuterio          0 2024-07-08 15:49 wordcounted.txt
```

```bash
[matthieu.freire.eleuterio@bigdata01 ~]$ yarn jar hadoop-examples-mapreduce.jar wordcount /user/matthieu.freire.eleuterio/input.txt user/matthieu.freire.eleuterio/output-districts
24/07/12 17:10:48 INFO client.AHSProxy: Connecting to Application History server at bigdata02.efrei.hadoop.clemlab.io/62.210.145.80:10200
24/07/12 17:10:48 INFO hdfs.DFSClient: Created token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1720797048686, maxDate=1721401848686, sequenceNumber=1184, masterKeyId=17 on ha-hdfs:efrei
24/07/12 17:10:48 INFO kms.KMSClientProvider: New token created: (Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1720797048742, maxDate=1721401848742, sequenceNumber=1083, masterKeyId=6))
24/07/12 17:10:48 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1720797048686, maxDate=1721401848686, sequenceNumber=1184, masterKeyId=17)
24/07/12 17:10:48 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1720797048742, maxDate=1721401848742, sequenceNumber=1083, masterKeyId=6)
24/07/12 17:10:48 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/matthieu.freire.eleuterio/.staging/job_1720701352744_0541
24/07/12 17:10:49 INFO input.FileInputFormat: Total input files to process : 2
24/07/12 17:10:49 INFO mapreduce.JobSubmitter: number of splits:2
24/07/12 17:10:49 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1720701352744_0541
24/07/12 17:10:49 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: kms-dt, Service: kms://http@bigdata03.efrei.hadoop.clemlab.io:9292/kms, Ident: (kms-dt owner=matthieu.freire.eleuterio, renewer=yarn, realUser=, issueDate=1720797048742, maxDate=1721401848742, sequenceNumber=1083, masterKeyId=6), Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for matthieu.freire.eleuterio: HDFS_DELEGATION_TOKEN owner=matthieu.freire.eleuterio@EFREI.HADOOP.CLEMLAB.IO, renewer=yarn, realUser=, issueDate=1720797048686, maxDate=1721401848686, sequenceNumber=1184, masterKeyId=17)]
24/07/12 17:10:49 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/1.2.4.0-10/0/resource-types.xml
24/07/12 17:10:49 INFO impl.TimelineClientImpl: Timeline service address: bigdata02.efrei.hadoop.clemlab.io:8190
24/07/12 17:10:50 INFO impl.YarnClientImpl: Submitted application application_1720701352744_0541
24/07/12 17:10:50 INFO mapreduce.Job: The url to track the job: https://bigdata01.efrei.hadoop.clemlab.io:8090/proxy/application_1720701352744_0541/
24/07/12 17:10:50 INFO mapreduce.Job: Running job: job_1720701352744_0541
24/07/12 17:10:56 INFO mapreduce.Job: Job job_1720701352744_0541 running in uber mode : false
24/07/12 17:10:56 INFO mapreduce.Job:  map 0% reduce 0%
24/07/12 17:11:02 INFO mapreduce.Job:  map 100% reduce 0%
24/07/12 17:11:06 INFO mapreduce.Job:  map 100% reduce 100%
24/07/12 17:11:06 INFO mapreduce.Job: Job job_1720701352744_0541 completed successfully
24/07/12 17:11:06 INFO mapreduce.Job: Counters: 54
        File System Counters
                FILE: Number of bytes read=154770
                FILE: Number of bytes written=1228799
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=110503
                HDFS: Number of bytes written=110210
                HDFS: Number of read operations=11
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
                HDFS: Number of bytes read erasure-coded=0
        Job Counters 
                Launched map tasks=2
                Launched reduce tasks=1
                Data-local map tasks=2
                Total time spent by all maps in occupied slots (ms)=23160
                Total time spent by all reduces in occupied slots (ms)=5584
                Total time spent by all map tasks (ms)=7720
                Total time spent by all reduce tasks (ms)=1396
                Total vcore-milliseconds taken by all map tasks=7720
                Total vcore-milliseconds taken by all reduce tasks=1396
                Total megabyte-milliseconds taken by all map tasks=11857920
                Total megabyte-milliseconds taken by all reduce tasks=2859008
        Map-Reduce Framework
                Map input records=10917
                Map output records=21873
                Map output bytes=197746
                Map output materialized bytes=154776
                Input split bytes=249
                Combine input records=21873
                Combine output records=11150
                Reduce input groups=11150
                Reduce shuffle bytes=154776
                Reduce input records=11150
                Reduce output records=11150
                Spilled Records=22300
                Shuffled Maps =2
                Failed Shuffles=0
                Merged Map outputs=2
                GC time elapsed (ms)=108
                CPU time spent (ms)=3200
                Physical memory (bytes) snapshot=2790449152
                Virtual memory (bytes) snapshot=9822801920
                Total committed heap usage (bytes)=2797600768
                Peak Map Physical memory (bytes)=1224245248
                Peak Map Virtual memory (bytes)=3115741184
                Peak Reduce Physical memory (bytes)=366358528
                Peak Reduce Virtual memory (bytes)=3595177984
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=110254
        File Output Format Counters 
                Bytes Written=110210
```

```bash
[matthieu.freire.eleuterio@bigdata01 ~]$ hdfs dfs -cat /user/matthieu.freire.eleuterio/output-districts/part-r-00000
‘descend        1
‘do     1
‘don’t  1
‘dost   1
‘early  1
‘even   1
‘for    1
‘get    1
‘give   1
‘go     1
‘good   1
‘hadst  1
‘has    1
‘have   1
‘he     1
‘his    1
‘how    1
‘if     1
‘in     1
‘is     1
‘it     1
‘just   1
‘justice        1
‘keep   1
‘laces  1
‘let    1
‘lie    1
‘may    1
‘mine   1
‘more   1
‘must   1
‘my     1
‘never  1
‘no     1
‘no,    1
‘nobody 1
‘not    1
‘nothing,       1
‘now    1
‘one    1
‘only   1
‘or     1
‘our    1
‘pray   1
‘right  1
‘say    1
‘sew    1
‘she    1
‘sing   1
‘sitting        1
‘so     1
‘stir   1
‘suppose        1
‘take   1
‘tell   1
‘than   1
‘that   1
‘the    1
‘then   1
‘there  1
‘they   1
‘this   1
‘those  1
‘thou   1
‘thy    1
‘tis    1
‘to     1
‘try    1
‘twas   1
‘upon   1
‘was    1
‘we     1
‘what   1
‘what’s 1
‘when   1
‘who    1
‘whose  1
‘why    1
‘with   1
‘would  1
‘yonder 1
‘you    1
‘you’ll 1
“Ah,    1
“Defects,”      1
“Good   1
“Heads  1
“Here   1
“I      1
“Information    1
“Iron   1
“It     1
“Jip!”’ 1
“Merrily        1
“Plain  1
“Project        1
“Right  1
“Under  1
“what   1
•       1