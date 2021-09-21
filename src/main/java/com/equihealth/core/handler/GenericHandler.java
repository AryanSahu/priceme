package com.equihealth.core.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.equihealth.core.util.di.AppInjector;
import com.equihealth.core.util.di.PriceMeApp;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GenericHandler
    implements com.amazonaws.services.lambda.runtime.RequestHandler<String, String> {

  public String handleRequest(String request, Context context) {
    context.getLogger().log("Generic handler " + request);
    List<String> response =new ArrayList<>();
    try {
      Injector injector = Guice.createInjector(new AppInjector());
      PriceMeApp app = injector.getInstance(PriceMeApp.class);
       response=app.getPriceList(request);
    }
    catch(Exception exception)
    {
      context.getLogger().log("Exception processing request");
    }
    return response.toString();
  }
}

