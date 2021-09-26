package com.bu.met662;

import java.text.SimpleDateFormat;
import java.util.*;

/** This class holds the info of keyword's history and occurrence. */
class SearchKeywordRecord {
  /**
   * This map holds the keyword as a key and timestamp as an arraylist(to store multiple timestamp
   * for a single keyword which is asked multiple times0.)
   */
  Map<String, ArrayList<String>> timeStampMap = new HashMap<>();
  /** This map holds the keyword as the key and its frequency as the value. */
  Map<String, Integer> searchRecordFrequencyMap = new HashMap<>();

  String timeStamp;

  /**
   * This method inserts/updates the frequency of the asked keyword. It insets the timestamp of the
   * asked keyword.
   */
  void insertRecord(String keyWord) {
    timeStamp =
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    if (timeStampMap.containsKey(keyWord)) {
      timeStampMap.get(keyWord).add(timeStamp);
    } else {
      timeStampMap.put(keyWord, new ArrayList<>(Arrays.asList(timeStamp)));
    }
    if (searchRecordFrequencyMap.containsKey(keyWord)) {
      searchRecordFrequencyMap.replace(keyWord, searchRecordFrequencyMap.get(keyWord) + 1);
    } else {
      searchRecordFrequencyMap.put(keyWord, 1);
    }
  }
  /**
   * This method displays the frequency of the asked keyword. If the asked keyword doesn't exist
   * appropriate message is printed.
   */
  void getSearchRecordsFrequency(String keyword) {
    if (searchRecordFrequencyMap.containsKey(keyword)) {
      System.out.println("\"" + keyword + ", " + searchRecordFrequencyMap.get(keyword) + "\"");
    } else {
      System.out.println("The keyword " + keyword + " was never searched!!! ");
    }
  }
  /**
   * This method displays all the keywords searched by the users. If no keywords are there then an
   * appropriate message is displayed.
   */
  void getSearchTimeStamp() {
    if (!timeStampMap.isEmpty())
      for (String key : timeStampMap.keySet())
        System.out.println(key + " " + timeStampMap.get(key));
    else System.out.println("No keywords are available!!!");
  }
}
