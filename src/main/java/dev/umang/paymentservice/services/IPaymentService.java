package dev.umang.paymentservice.services;

import com.razorpay.RazorpayException;

public interface IPaymentService {
       public String generatePaymentLink(String orderId,
                                         Long amount,
                                        String phoneNumber,
                                        String name,
                                        String email) throws RazorpayException;
}


/*
Adapter
bringing a layer between controller and service class


Strategy + Factory

Strategy is for choosing payment gateways.
Can Amazon have multiple gateway integrations?


Integrate with Razorypay?

I'll have to read the API documentation written by Razorpay

From my spring application, if i want to call razorypay, we already have
spring dependency that can be used,
 */