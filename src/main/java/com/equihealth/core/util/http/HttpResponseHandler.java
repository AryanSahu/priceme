package com.equihealth.core.util.http;

import com.equihealth.core.constants.PricemeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


public final class HttpResponseHandler {

  private static Logger logger = LoggerFactory.getLogger(HttpResponseHandler.class);


  public static ResponseEntity<Object> generateResponse(String message, HttpStatus status,
      Object responseObj) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put(PricemeConstant.MESSAGE, message);
    map.put(PricemeConstant.STATUS, status.value());
    map.put(PricemeConstant.DATA, responseObj.toString());
    return new ResponseEntity<Object>(map.toString(), status);
  }
}