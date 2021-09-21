package com.equihealth.core.util.parser;

import com.equihealth.core.model.FileReferenceData;
import com.equihealth.core.util.http.HttpResponseHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser implements FileParser {

  public static final String CLASSPATH = "classpath:";
  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  Logger logger = LoggerFactory.getLogger(JsonParser.class);



  @Override
  public List<FileReferenceData> readFile(String filename) throws IOException {
    List<FileReferenceData> fileReferenceDataList = new ArrayList<>();


      File file = ResourceUtils.getFile(CLASSPATH + filename);
      fileReferenceDataList = JSON_MAPPER
          .readValue(file, new TypeReference<List<FileReferenceData>>() {
          });



    return fileReferenceDataList;
  }


}
