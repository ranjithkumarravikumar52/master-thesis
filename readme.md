### A study of social factors in activity-based active learning classroom correlated to students' performance

#### What is this paper about?

In our observational study of students, we formulated and evaluated Group Cohesion score along with its (Goal Settings, Communication, Trust, Accountability and Recognition), social (from open-ended answers) and sentiment analysis (from LIWC tool).

By taking into consideration of our ABAL (activity-based active learning) classroom approach, we provided results correlating these points with academic performance. In addition, we found that Trust trait and three social factors (C1, A1 and R3) collectively, had a high and positive correlation academic performance, while the remaining factors had a less significant correlation, from the observations we have conducted in our ABAL class. However, when we analyzed data sample with a weekly comparison of student’s performance with the independent variables from our study, we found that there exists no strong correlation between them.

Please check out the [Github Link](https://github.com/ranjithkumarravikumar52/Master-thesis/blob/master/Thesis%20Published.pdf) and [ProQuest link](https://search.proquest.com/openview/845ddd436ec9148ca974121de5b949a9/1.pdf?pq-origsite=gscholar&cbl=18750&diss=y) for my submitted paper to find detailed information. Or for a [quick read](doc/final defense.pdf), please check out my slides. **Cheers!**

## Contents

## Installation
* Java jdk
* ElasticSearch server
* Kibana
* Excel sheet (which contains the raw data

#### JAVA Documentation
* Project contains two packages - ParseUtil and main
* ParseUtil contains two classes - ElasticSearchServer.java and ExcelFile.Java
* Change the static variables in the "ElasticSearchServer.java" to adjust your port number, index name and document name for the ElasticSearch
* Main package contains App.java where you can adjust the name of your excel file to be parsed  

#### Setting up ELK (ElasticSearch Logstash Kibana) environment
* [Download](https://www.elastic.co/downloads/elasticsearch) and install elastic search
* Run elastic search
  * Go to [elasticsearch-5.6.2\bin](elasticsearch-6.2.4\bin) and
  * run elasticsearch in cmd
  * ![Sample screenshot](doc/elasticsearch.png?raw=true "elasticsearch.png")
* [Download](https://www.elastic.co/downloads/kibana) and install kibana
* Run kibana
  * Go to [kibana-5.6.2-windows-x86\bin](kibana-6.2.4-windows-x86_64\bin) and
  * run kibana in cmd
* Open kibana
  * Go to localhost:5601 (or any preferred port number you set up during installation) to open kibana in the browser
  * ![Sample screenshot](doc/kibana.png?raw=true "Kibana.png")

#### Some basic commands to check status of elasticsearch server
* Install curl or shell scripting and execute the following commands
  * List all indices in elasticsearch
    * `GET /_cat/indices?v`
  * Delete an index from elasticsearch
    * `DELETE /index-name?pretty`
  * To know the documents in an index
    * `GET ranjith-thesis/?pretty`
  * To check for all the documents in an index (each document starts as a new JSON object in the JSON Array)
    * `GET ranjith-thesis`


## Usage
* From the data gathered from the observational studies and online surveys, download them as excel format into working location of your java application
* Manually enter the name of the excel file into Java application in App.java
* Before running the application, make sure elastic search and kibana are running in the background
* Run App.java and wait for the data from the excel sheet to be pushed into the elastic search server
* Once application completed pushing the data, open your local browser and open kibana
* Now if the data has pushed successfully, you can start creating visualizations based on the data that has been pushed


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

#### Thanks and credits
* University of North Carolina at Charlotte
