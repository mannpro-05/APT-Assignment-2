package com.bu.met662;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  /**
   * All the objects for the classes are declared over here. This method gives the choices to the
   * user takes their input and gives output accordingly.
   */
  public static void main(String[] args) throws IOException {
    // write your code here
    MergingFiles mergingFiles = new MergingFiles();
    KeywordSearch keywordSearch = new KeywordSearch();
    SearchKeywordRecord searchRecord = new SearchKeywordRecord();
    /** This to terminate the infinite loop form switch case */
    loop:
    while (true) {
      try {

        loop1:
        while (true) {
          System.out.println(
              "Choose one of the following options:\n1.Merge the files.\n2.Search for a keyword\n3.Look at the frequency of a keyword\n4.Look at the timestamp of the keywords.\n5.Terminate the program.");
          Scanner sc = new Scanner(System.in);
          int choice = sc.nextInt();
          switch (choice) {
              /** This case will merge all the files which are there in the zip files. */
            case 1:
              System.out.println("You chose to merge all the files.");
              mergingFiles.mergeFiles();
              System.out.println("All the files have been merged.");
              break;
              /**
               * In this case the user will enter a keyword in the command line. The keyword will be
               * stored with the timestamp in a hashMap. The frequency of the keyword will
               * entered/updated. The Close Date and the Fund Raised Percentage of the asked keyword
               * will be shown to the user.
               */
            case 2:
              System.out.println("You chose to search a keyword.\nPlease enter a keyword:");
              String keyword = sc.next();
              keywordSearch.setKeyword(keyword);
              keywordSearch.keywordSearch();
              searchRecord.insertRecord(keyword);
              break;
              /**
               * In this case the user will enter a keyword in the command line. The frequency of
               * the asked keyword will be displayed. If the keyword does not exist then it will
               * show an appropriate message.
               */
            case 3:
              System.out.print(
                  "\nYou chose to check the frequency of a particular keyword.\nPlease enter a keyword:");
              keyword = sc.next();
              searchRecord.getSearchRecordsFrequency(keyword);
              break;
              /** This case will give the timestamp of all the keywords entered buy the user. */
            case 4:
              searchRecord.getSearchTimeStamp();
              break;
              /** This case will terminate the program. */
            case 5:
              break loop;
              /** If invalid choice is given then it will show an appropriate message. */
            default:
              System.out.println("Please Enter a valid choice.");
              break;
          }
        }
        /** If invalid input like String is given as an input it will handle it. */
      } catch (InputMismatchException ex) {
        System.out.println("Please Enter a valid input!");
        /** It will catch all the exceptions in the program and print an appropriate message. */
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
