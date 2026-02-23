package dev.umang.paymentservice.configurations;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorypayClient {
    @Value("${razorpay.keyId}")
    private String razorpayKeyId;

    @Value("${razorpay.keySecret}")
    private String razorpayKeySecret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        // Initialize Razorpay client with API key and secret
        return new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }
}

/*
This client object is part of depenedency we added
But don't we need to create spring bean and inject it wherevr
required?

using this client object, we are going to call razorypay apis??
REstTemplate.getForObject()


Payment service will call Rz
you need to connect with Rz
 */
