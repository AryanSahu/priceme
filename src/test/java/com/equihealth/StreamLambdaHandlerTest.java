package com.equihealth;


import com.amazonaws.serverless.proxy.internal.LambdaContainerHandler;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;

import com.equihealth.core.handler.RestAPIHandler;
import org.jetbrains.annotations.NotNull;
import org.junit.BeforeClass;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

import static org.junit.Assert.*;


public class StreamLambdaHandlerTest {

    public static final String IN = "IN";
    private static RestAPIHandler handler;
    private static Context lambdaContext;

    @BeforeClass
    public static void setUp() {
        handler = new RestAPIHandler();
        lambdaContext = new MockLambdaContext();
    }

    @Test
    public void price_LMN() {

        String request = prepareMockRequest("lemon");

        InputStream requestStream = new AwsProxyRequestBuilder("/price", HttpMethod.POST)
                                            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).body(request)
                                            .buildStream();
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

        handle(requestStream, responseStream);

        AwsProxyResponse response = readResponse(responseStream);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusCode());
        assertTrue(response.getBody().contains(IN));

    }



    @Test
    public void price_ORNG() {

        String request = prepareMockRequest("orange");

        InputStream requestStream = new AwsProxyRequestBuilder("/price", HttpMethod.POST)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).body(request)
            .buildStream();
        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();

        handle(requestStream, responseStream);

        AwsProxyResponse response = readResponse(responseStream);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatusCode());
        assertTrue(response.getBody().contains("BZ"));

    }



    private void handle(InputStream is, ByteArrayOutputStream os) {
        try {
            handler.handleRequest(is, os, lambdaContext);
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }



    private AwsProxyResponse readResponse(ByteArrayOutputStream responseStream) {
        try {
            return LambdaContainerHandler.getObjectMapper().readValue(responseStream.toByteArray(), AwsProxyResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error while parsing response: " + e.getMessage());
        }
        return null;
    }

    @NotNull
    private String prepareMockRequest(String commodity) {
        return "{\n"
            + "    \"commodityName\": \""+commodity+"\",\n"
            + "    \"pricePerTon\":\"53\",\n"
            + "    \"volumeInTons\":\"405\"\n"
            + "  \n"
            + "}";
    }
}
