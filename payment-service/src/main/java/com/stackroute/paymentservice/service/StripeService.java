package com.stackroute.paymentservice.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {
    @Value("${stripe.key.secret}")
    private String API_SECET_KEY;
    String price;
    int number;
    public StripeService() {

    }

//    public String createCustomer(String email, String token) {
//
//        String id = null;
//
//        try {
//            Stripe.apiKey = API_SECET_KEY;
//            Map<String, Object> customerParams = new HashMap<>();
//            customerParams.put("description", "Customer for " + email);
//            customerParams.put("email", email);
//            // obtained with stripe.js
//            customerParams.put("source", token);
//
//            Customer customer = Customer.create(customerParams);
//            id = customer.getId();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }

    public String sendData(String price)
    {
        this.price=price;
        this.number = Integer.parseInt(price);
        return this.price;
    }
    public String createCharge(String email, String token, int amount) {

        try {
            Stripe.apiKey = API_SECET_KEY;


//            Map<String, Object> chargeParams = new HashMap<>();
//            chargeParams.put("description","Charge for "+email);
//            chargeParams.put("currency","inr");
//            chargeParams.put("amount",amount);
//            chargeParams.put("source",token);
//            Charge charge = Charge.create(chargeParams);
//
//            chargeId = charge.getId();
            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount((long) this.number*100)
                            .setCurrency("inr")
                            .setDescription("Example charge")
                            .addPaymentMethodType("card")
                            .putMetadata("order_id", "6735")
                            .setConfirm(true)
                            .setPaymentMethod(token)
                            .setConfirmationMethod(PaymentIntentCreateParams.ConfirmationMethod.MANUAL)
                            .setReceiptEmail(email)
                            .build();




//            PaymentIntent paymentIntent =
//                    PaymentIntent.retrieve(
//                            "pi_3M2f0fSIFB1qrVBL0aZfma0u"
//                    );

            //PAYMENT INTENT CONFIRM
//            Map<String, Object> params1 = new HashMap<>();
//            params1.put("payment_method", "pm_1M2f0eSIFB1qrVBLRc4fg5iY");
//
//            PaymentIntent updatedPaymentIntent =
//                    paymentIntent.confirm(params1);

            PaymentIntent paymentIntent = PaymentIntent.create(params);
//             url = paymentIntent.getCharges().;

//            PaymentIntent paymentIntent1 = PaymentIntent.retrieve(token);

//            Charge charge = Charge.create(paymentIntent);

//            RequestOptions requestOptions = RequestOptions.builder().setStripeAccount("acct_1M1RHzSIFB1qrVBL\n" +
//                    "\n").build();
//            PaymentIntent paymentIntent = PaymentIntent.create(chargeParams, requestOptions);
//            Map<String, Object> params1 = new HashMap<>();
//            params1.put("customer", "cus_9BoKyB2Km2T7TE");
//
//            Invoice invoice = Invoice.create(params1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}
