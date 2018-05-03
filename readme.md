#### Setting up environment to see visualizations in kibana
* Run elastic search
  * Go to elasticsearch-5.6.2\bin and run elasticsearch in cmd
* Run kibana
  * Go to kibana-5.6.2-windows-x86\bin and run kibana in cmd
* Open kibana
* Go to localhost:5601 (or any preferred port number) to open kibana in the browser
* Run curl
* Install I386 folder into the project folder to run curl commands in gitbash. I think curl is not working in cmd.

#### Better than curl
*  run curl commands in kibana console to get a better view of the results (personal preference)

#### List all indices in elasticsearch
* GET /_cat/indices?v

#### Delete an index from elasticsearch
* DELETE /index-name?pretty

#### Research Questions
* RQ1: What social attributes does impact the group member's confidence ?
* RQ2: How could group member's social attributes affect the group's performance ?
* RQ3: What are the attributes of socially-isolated members in a group and what factors leads to a group member's isolation (or triggers those attributes) ?
* RQ4: What kind of social behaviors are generally acceptable/not acceptable by a group?

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

* Q5 Tier-1
* Q10 Tier-1
* Q15 Tier-1
* Q19 Tier-1
* Q23 Tier-1
* Q24 Tier-1

#### To know the documents in an index
* GET ranjith-thesis/?pretty

#### To check for all the documents in an index
* GET ranjith-thesis (each document starts as a new JSON object in the JSON Array
