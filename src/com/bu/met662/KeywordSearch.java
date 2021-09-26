package com.bu.met662;

import constants.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/** This class holds the info for searching the keyword. */
public class KeywordSearch {
  private String keyword;

  /**
   * This method will search for the asked keyword. It will display the close date and the fund
   * raised percent for the asked keyword. If the keyword does not exist then it will show an
   * appropriate message.
   */
  public void keywordSearch() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(Constants.MERGED_CSV_FILE_NAME));
      String line;
      int flag = 0;
      while ((line = br.readLine()) != null) {
        if (line.contains(this.keyword)) {
          flag = 1;
          if (line.split(",")[4].contains("/")) {
            System.out.println(
                "close_date: "
                    + line.split(",")[5]
                    + " fund_raised_percent: "
                    + line.split(",")[8]
                    + "%");
          } else {
            System.out.println(
                "close_date: "
                    + line.split(",")[4]
                    + " fund_raised_percent: "
                    + line.split(",")[7]
                    + "%");
          }
        }
      }
      if (flag == 0) {
        System.out.println("The keyword " + keyword + " doesn't exist!");
      }

    } catch (FileNotFoundException e) {
      System.out.println("Please merge the files first then search for the keywords!!.");
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
  /** This method returns the class variable keyword. */
  public String getKeyword() {
    return keyword;
  }
  /** Will assign a value to the class variable. */
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
}
