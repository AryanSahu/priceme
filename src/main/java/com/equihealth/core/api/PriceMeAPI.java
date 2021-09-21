package com.equihealth.core.api;

import com.equihealth.core.service.PriceService;
import com.equihealth.core.util.http.HttpResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PriceMeAPI {

  private static Logger logger = LoggerFactory.getLogger(PriceMeAPI.class);

  @Autowired
  private PriceService priceService;


  @PostMapping(
      value = "/price", produces = "application/json", consumes = "application/json")
  public ResponseEntity<Object> price(@RequestBody String requestBody) {

    try {

      logger.info("Request " + requestBody);
      List<String> response = priceService.getPriceList(requestBody);

      return HttpResponseHandler.generateResponse("Success", HttpStatus.OK, response);
    } catch (Exception ex) {

      logger.error("Exception  processing request" + ex);
      return HttpResponseHandler
          .generateResponse("Issue Loading price", HttpStatus.INTERNAL_SERVER_ERROR, "API ERROR");
    }


  }


}
