package dev.umang.paymentservice.services;

import com.razorpay.RazorpayException;
import dev.umang.paymentservice.strategies.PaymentGateway;
import dev.umang.paymentservice.strategies.PaymentGatewayChooserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    /*
    This is where I want to choose between different options of Payment gateways
     */

    @Autowired
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

    @Override
    public String generatePaymentLink(String orderId,
                                      Long amount,
                                      String phoneNumber,
                                      String name,
                                      String email) throws RazorpayException {

        PaymentGateway paymentGateway = paymentGatewayChooserStrategy.getBestPaymentGateway();


        return paymentGateway.generatePaymentLink(
                orderId,
                amount,
                phoneNumber,
                name,
                email);
    }
}
