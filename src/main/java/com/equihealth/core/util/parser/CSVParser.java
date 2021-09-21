package com.equihealth.core.util.parser;

import com.equihealth.core.model.FileReferenceData;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements FileParser {

  @Override
  public List<FileReferenceData> readFile(String filename) {

    List<FileReferenceData> fileReferenceDataList = new ArrayList<>();

    try {

      FileInputStream fin = new FileInputStream(filename);
      try (Reader reader = new BufferedReader(new InputStreamReader(fin))) {

        CsvToBean<FileReferenceData> csvToBean = new CsvToBeanBuilder(reader)
            .withType(FileReferenceData.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build();

        fileReferenceDataList = csvToBean.parse();

      }
    } catch (IOException ex) {

      ex.printStackTrace();

    }

    return fileReferenceDataList;

  }


}