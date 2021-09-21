package com.equihealth.core.util.http;

import com.equihealth.core.constants.PricemeConstant;
import com.equihealth.core.model.FileReferenceData;
import com.equihealth.core.model.RequestData;
import com.equihealth.core.model.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class RequestResponseUtil {

  private RequestResponseUtil()
  {

  }

  public static RequestData getRequestData(String requestContext)
      throws com.fasterxml.jackson.core.JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(requestContext, RequestData.class);
  }

  @NotNull
  public static List < String > prepareResponse(RequestData requestContext,
      List < FileReferenceData > fileReferenceData, List < ResponseData > responseList) {
    for (FileReferenceData data: fileReferenceData) {

      if (data.getCommodity_Name().equals(requestContext.getCommodityName())) {
        double cost = requestContext.getPricePerTon() + data.getVar_overhead();
        ResponseData response = new ResponseData();
        response.setCountryCode(data.getCountry() + PricemeConstant.BLANK);
        double totalCalculation =
            requestContext.getVolumeInTons() * cost + data.getFixed_overhead();
        response.setTotalcost(totalCalculation);
        response.setPriceBreakDown(
            cost + PricemeConstant.STAR +
                requestContext.getVolumeInTons() + PricemeConstant.ADD + data
                .getFixed_overhead());
        responseList.add(response);

      }

    }
    responseList.sort((o1, o2) -> Double.compare(o2.getTotalcost(), o1.getTotalcost()));
    List < String > priceList = new ArrayList < > ();

    for (ResponseData response: responseList) {
      StringBuilder sb = new StringBuilder();
      sb.append(response.getCountryCode() + PricemeConstant.BLANK + response.getTotalcost() +
          PricemeConstant.BAR + response
          .getPriceBreakDown());
      priceList.add(sb.toString());
    }
    return priceList;

  }

  public static String serializeRequest(String request) {
    Map < String, String > elements = new HashMap();
    String param[] = request.split(PricemeConstant.BLANK);
    elements.put(PricemeConstant.COMMODITY_NAME, param[0]);
    elements.put(PricemeConstant.PRICE_PER_TON, param[1]);
    elements.put(PricemeConstant.VOLUME_IN_TONS, param[2]);
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonRequest = PricemeConstant.BLANK;

    try {
      jsonRequest = objectMapper.writeValueAsString(elements);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }

    return jsonRequest;
  }

}