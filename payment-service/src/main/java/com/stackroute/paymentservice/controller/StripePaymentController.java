package com.stackroute.paymentservice.controller;

import com.stackroute.paymentservice.model.Response;
import com.stackroute.paymentservice.service.StripeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/payment")
public class StripePaymentController {

    //    @Value("${stripe.apikey}")
//    String stripKey;
//    @RequestMapping("/")
//    public String index()
//    {
//        return "hello "+stripKey;
//    }
    @Value("${stripe.key.public}")
    private String API_PUBLIC_KEY;

    private StripeService stripeService;

    public StripePaymentController (StripeService stripeService) {
        this.stripeService = stripeService;
    }

    String price;
    String productName;

//    @PostMapping("/paymentData")
//    public void paymentData(@RequestBody String x)
//    {
//        System.out.println(x);
//    }

    @GetMapping("/{price}/{productName}")
    public String homepage(@PathVariable String price, @PathVariable String productName) {
        this.price = stripeService.sendData(price);
        this.productName =  productName;
        return "homepage";
    }

    @GetMapping("/charge")
    public String chargePage(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        model.addAttribute("price", this.price);
        model.addAttribute("productName", this.productName);
        return "charge";
    }
    @GetMapping("/success")
    public String successPage(Model model) {return "success";}

//    @PostMapping("/create-charge")
//    public @ResponseBody Response createCharge(String email, String token) {
//    }


    @PostMapping("/create-charge")
        public @ResponseBody Response createCharge(String email, String token) {

        if (token == null) {
            return new Response(false, "Stripe payment token is missing. please try again later.");
        }

        String chargeId = stripeService.createCharge(email, token, 999);// 9.99 usd

        if (chargeId == null) {
            return new Response(false, "An error accurred while trying to charge.");
        }
      //charge id and other information can be store
        return new Response(true, "Success your charge id is " + chargeId);
    }
//    @PostMapping("/data")
//        public @ResponseBody int dataReaceive() {
//
//
//
//        //charge id and other information can be store
//        return this.data;
//    }
}