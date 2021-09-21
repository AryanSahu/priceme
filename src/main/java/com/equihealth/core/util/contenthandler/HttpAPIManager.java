package com.equihealth.core.util.contenthandler;

import com.equihealth.core.model.FileReferenceData;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HttpAPIManager implements PriceContentManager {

  @Autowired
  private RestTemplate restTemplate;

  @Value("${content.external.url}")
  private String BASE_URL;


    /*

    logic to fetch from external api

     */

  public List<FileReferenceData> readContent(String fileName)  throws IOException {

    ResponseEntity<FileReferenceData[]> responseEntity =
        restTemplate.getForEntity(BASE_URL, FileReferenceData[].class);
    FileReferenceData[] fileReferenceData = responseEntity.getBody();

    return Arrays.asList(fileReferenceData);


  }


}
