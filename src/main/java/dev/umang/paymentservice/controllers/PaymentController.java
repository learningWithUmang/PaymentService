package dev.umang.paymentservice.controllers;


import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.umang.paymentservice.dtos.PaymentRequestDto;
import dev.umang.paymentservice.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    /generatePaymentLink
    Type: POST
    Request:{
        "orderId": "12345",
    }
    Response: {
        "paymentLink": "https://paymentgateway.com/pay?orderId=12345&token=abcde"
    }

    Every orderId can itself act as idempotent key. This idempotency will be handled
    by PG assume.
 */

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @PostMapping
    public String generatePaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) throws RazorpayException, StripeException {
        return paymentService.generatePaymentLink(paymentRequestDto.getOrderId(),
                paymentRequestDto.getAmount(),
                paymentRequestDto.getPhoneNumber(),
                paymentRequestDto.getName(),
                paymentRequestDto.getEmail());
    }
}
