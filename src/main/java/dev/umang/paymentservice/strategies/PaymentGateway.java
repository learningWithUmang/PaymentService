package dev.umang.paymentservice.strategies;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
        String generatePaymentLink(String orderId,
                                    Long amount,
                                    String phoneNumber,
                                    String name,
                                    String email) throws RazorpayException;
}
