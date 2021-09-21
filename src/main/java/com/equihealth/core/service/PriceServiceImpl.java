package com.equihealth.core.service;

import com.equihealth.core.model.FileReferenceData;
import com.equihealth.core.model.RequestData;
import com.equihealth.core.model.ResponseData;
import com.equihealth.core.util.http.RequestResponseUtil;
import com.equihealth.core.util.contenthandler.PriceContentManager;
import com.equihealth.core.util.contenthandler.FileManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Singleton;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Singleton
public class PriceServiceImpl implements PriceService {

  /**
   * FileContent manager used for purpose POC This could be injected with HTTPContentManager to
   * fetch from external api
   **/

  @Autowired
  @Qualifier("fileManager")
  private PriceContentManager contentManager;

  private static Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);


  public List<String> getPriceList(String requestContext) throws IOException {
    List<String> priceList = new ArrayList<>();

      RequestData request = RequestResponseUtil.getRequestData(requestContext);
      //  loading json for POC
      String fileName = request.getCommodityName() + ".json";
      if (contentManager == null) {
        contentManager = new FileManager();
      }
      List<FileReferenceData> fileReferenceData = contentManager.readContent(fileName);
      List<ResponseData> responseList = new ArrayList<>();
      priceList = RequestResponseUtil.prepareResponse(request, fileReferenceData, responseList);


    return priceList;


  }




}
