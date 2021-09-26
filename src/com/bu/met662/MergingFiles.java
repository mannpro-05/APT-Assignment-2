package com.bu.met662;

import constants.Constants;

import java.io.*;
/**
 * This class Merges all the csv files in the zipFIle folder.*/
public class MergingFiles {
  private final File f = new File(Constants.BASEPATH);
  private final String[] pathNames = f.list();
  String line;

  public MergingFiles() throws IOException {}

  /**
   * This method iterates through all the folder and files.
   * Reads every file line by line.
   * Append every line into the merge.csv file. */
  void mergeFiles() throws IOException {
    final FileWriter csvWriter = new FileWriter(Constants.MERGED_CSV_FILE_NAME);
    if (pathNames != null) {
      for (String dirName : pathNames) {
        File dir = new File(Constants.BASEPATH + "\\" + dirName);
        String[] fileNames;
        fileNames = dir.list();
        if (fileNames != null) {
          for (String fName : fileNames) {
            BufferedReader br =
                new BufferedReader(
                    new FileReader(Constants.BASEPATH + "\\" + dirName + "\\" + fName));
            while ((line = br.readLine()) != null) {
              csvWriter.append(line);
              csvWriter.append("\n");
            }
          }
        }
      }
      csvWriter.close();
    }
  }
}
