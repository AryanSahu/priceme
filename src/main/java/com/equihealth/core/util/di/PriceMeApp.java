package com.equihealth.core.util.di;


import com.equihealth.core.service.PriceService;
import com.equihealth.core.util.http.RequestResponseUtil;
import com.google.inject.Inject;

import java.io.IOException;
import java.util.List;

public class PriceMeApp {

  private PriceService service;

  @Inject
  public void setService(PriceService service) {
    this.service = service;
  }

  public List<String> getPriceList(String request) throws IOException {
    return service.getPriceList(RequestResponseUtil.serializeRequest(request));
  }




}