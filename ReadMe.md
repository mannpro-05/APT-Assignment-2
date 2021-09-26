# Advance Programming Techniques (Homework 2)

### Mann Prajapati | U52609954

-Since the name of the CSV files were similar in every folder so, I chose to keep them in the folder and iterated
through every folder and the files in it.

- The starting point of code is in the Main.java file.

- All Objects are placed in the Main class which will point to their respective classes.
- There is a Package called constants which contains all the constant strings for the path of the directories which are
  used in the program.
- The MergingFiles.java file navigates through all the folders which are there in the ZipFiles directory and also goes
  through the files in those directories and applies the merging logic.
- The merged data is stored in the merge.csv file which is in the root directory.
- The KeywordSearch.java file searches for the keyword which the user asked to search for.
- If the keyword is there in the file then it will display the close date and fund raised percent for that particular
  row in which it occurred.
- If the keyword is not there then it prints an appropriate message.
- The SearchKeywordRecord.java has 2 hashMaps timeStampMap and searchRecordFrequencyMap.
- timeStampMap has keyword as a string and ArrayList of the timestamp as value.
- The reason behind using an ArrayList is that if a keyword is searched multiples times then the previous timestamp will
  be overridden with the new one. So, by using the ArrayList we can simply append the timestamp to the list and display
  all of them.
- searchRecordFrequencyMap has keyword as a key and frequency as its value. If a new keyword is asked a new value is
  added to the map and the frequency is set as 1.
- If the keyword already exists then it finds the keyword and updates its frequency.
