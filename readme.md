### A study of social factors in activity-based active learning classroom correlated to students' performance

#### What is this paper about?
Social behaviors of students play a significant role in classroom atmosphere and
also the way it impacts students’ learning interests. In addition, socially acceptable
behaviors are generally preferred by students in group-based classes. But on the other
hand, students’ socially disruptive behaviors lead to different kinds of problems, such as

1. Interfering in classroom learning and learning environment
2. Weakening students’ respect for the academic environment
3. Impairing students’ academic and intellectual development
4. Decreasing students’ engagement, commitment and retention
5. Finally, worst case scenarios - social isolation, depression and other mental problems

Considering the issues, the study of social behaviors of students in an ABAL (Activity based active learning) class is an important research subject. Unfortunately, not much attention has been given to the study of social factors impacting students’ learning. Therefore, in this work, we are going to study the social factors of students in an ABAL class that could impact students’ performance.

In our study, we formulated and evaluated Group Cohesion score along with its
traits (Goal Settings, Communication, Trust, Accountability and Recognition), social
factors (from open-ended answers) and sentiment analysis (from LIWC tool).

By taking into consideration of our ABAL classroom approach, we provided results correlating these points with academic performance. In addition, we found that Trust trait and three social factors (C1, A1 and R3) collectively, had a high and positive correlation academic performance, while the remaining factors had a less significant correlation, from the observations we have conducted in our ABAL class. However, when we analyzed data sample with a weekly comparison of student’s performance with the
independent variables from our study, we found that there exists no strong correlation
between them.

#### Research Questions I was trying to solve
* **RQ1**: `What social attributes does impact the group member's confidence ?`
* **RQ2**: `How could group member's social attributes affect the group's performance ?`
* **RQ3**: `What are the attributes of socially-isolated members in a group and what factors leads to a group member's isolation (or triggers those attributes) ?`
* **RQ4**: `What kind of social behaviors are generally acceptable/not acceptable by a group?`


#### Constraints for experiment
1.  The requirement for this project was to convert my data gathered from observational studies conducted through online survey and direct observational studies, to some sort of visualization preferably kibana (personal interest, I like their view of dashboard)
2.  All the data was gathered in google sheets over a period of 11-12 weeks from September 2017 - November 2017
3.  But visualizing the data became a problematic as I have to clean and update the data if I have to use google sheets visualizations regularly
4.  To solve that problem, I have used the help of ELK stack to help me visualize the daily data I was collecting
5. ELK stack along with this Java code helps me to regularly push data gathered from the observation studies and push them into elastic search and view them comfortably in kibana
6. Also helped me to show visualizations to people much easier compared to excel sheets/google sheets

#### Setting up ELK (ElasticSearch Logstash Kibana) environment
* Download and install elastic search
* Run elastic search
  * Go to elasticsearch-5.6.2\bin and run elasticsearch in cmd
* Download and install kibana
* Run kibana
  * Go to kibana-5.6.2-windows-x86\bin and run kibana in cmd
* Open kibana
* Go to localhost:5601 (or any preferred port number you set up during installation) to open kibana in the browser

#### Some basic commands to check status of elasticsearch server
* List all indices in elasticsearch
  * `GET /_cat/indices?v`
* Delete an index from elasticsearch
  * `DELETE /index-name?pretty`
* To know the documents in an index
  * `GET ranjith-thesis/?pretty`
* To check for all the documents in an index (each document starts as a new JSON object in the JSON Array)
  * `GET ranjith-thesis`

#### JAVA Documentation
* Project contains one package and three classes inside it.
* Change the variables in the "Ranjith_Thesis_Main" to create JSON object for each row in excel.
* With the successful JSON object creation, the object will be pushed into elastic search.
* Make sure elastic search and kibana is set up and running when the Java program is executed.  

#### Open-Ended Work Flow
* Every time the code is executed for the open-ended workbook,
don't forget to change the name of the document in "Ranjith_Thesis_Main.java"
to make each sheet as a new JSON Object in the JSONObject Array.
*  Don't forget to change the index in "Sheet sheet1 = workbook.getSheetAt(i);" of the Excel_JSON.java
