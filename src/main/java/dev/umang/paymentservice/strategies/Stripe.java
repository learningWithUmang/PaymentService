package dev.umang.paymentservice.strategies;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Stripe implements PaymentGateway{

    @Value("${stripe.apiKey}")
    private String stripeAPIKey;
    @Override
    public String generatePaymentLink(String orderId,
                                      Long amount,
                                      String phoneNumber,
                                      String name,
                                      String email) throws RazorpayException, StripeException {

        com.stripe.Stripe.apiKey = this.stripeAPIKey;
        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("INR")
                        .setUnitAmount(10000L)
                        .setRecurring(
                                PriceCreateParams.Recurring.builder()
                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                        .build()
                        )
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName("Payment for test session on integrating payment gateway Stripe").build()
                        )
                        .build();

        Price price = Price.create(priceCreateParams);



        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://www.google.com")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.toString();
    }


    /*
    Stripe client which will be used
    to call stripe apis
     */
}

/*
In of future classes,
in doubt class, i'll also integrate stripe as well
 */
