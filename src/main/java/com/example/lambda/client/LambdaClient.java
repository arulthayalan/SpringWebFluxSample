package com.example.lambda.client;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;

public class LambdaClient {

    public static void main(String[] args) {
        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName("helloWorld");

        //BasicAWSCredentials awsCreds = new BasicAWSCredentials("APIADGALD", "PQFNsMOxyrb");
        AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                .withRegion(Regions.AP_SOUTHEAST_2)
                .withCredentials(new ProfileCredentialsProvider()).build();
        InvokeResult invokeResult = null;
        try {
            invokeResult = awsLambda.invoke(invokeRequest);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(new String(invokeResult.getPayload().array()));
        System.out.println(invokeResult.getStatusCode());
    }
}
