package com.equihealth.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PriceService {

     List<String> getPriceList(String requestContext) throws IOException;
}
