package dev.umang.paymentservice.strategies;

import dev.umang.paymentservice.dtos.PaymentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayChooserStrategy {

    @Autowired
    private Razorpay razorpayGateway;

    @Autowired
    private Stripe stripeGateway;


    public PaymentGateway getBestPaymentGateway(){
        /*
        write an algorithm to choose your gateway
         */
        return stripeGateway;
        // logic to choose the best payment gateway based on the request
    }
}

/*
out of 1000 txn
i will randomly select razorpay for 700 txn
for 300 txn, i will randomly select stripe

based on amount
 */
