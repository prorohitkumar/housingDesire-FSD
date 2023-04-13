package com.stackroute.designerservice.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitmqconfiguration {


   // public static final String ROUTING_R="designer_R";

    public static final String ROUTING_D="design_D";

    public static final String ROUTING_P="design_P";

    public static final String QUEUE = "RabbitMQ queue ";

    public static final String EXCHANGE = "RabbitMQ Topic Exchange";
    private static final String ROUTING_KEY = "Routing KEy";


//    @Bean
//    Queue queueR(){
//        return new Queue("designertoRecomnd.Producer",false);
//    }

    @Bean
    Queue queueD(){
        return new Queue("designtoRecomnd.Producer",false);
    }
//    @Bean
//    Queue queueP(){
//        return new Queue("designtoPayment.Producer",false);
//    }

    @Bean
    DirectExchange exchange(){
        return new DirectExchange("exchange.designer-ser");
    }
//    @Bean
//    public Binding bindingR(Queue queueR, DirectExchange exchange) {
//        return BindingBuilder.bind(queueR)
//                .to(exchange)
//                .with(ROUTING_R);
//    }

    @Bean
    public Binding bindingD(Queue queueD, DirectExchange exchange) {
        return BindingBuilder.bind(queueD)
                .to(exchange)
                .with(ROUTING_D);
    }

//    @Bean
//    public Binding bindingP(Queue queueP, DirectExchange exchange) {
//        return BindingBuilder.bind(queueP)
//                .to(exchange)
//                .with(ROUTING_P);
//    }


    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }



    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemp=new RabbitTemplate(connectionFactory);
        rabbitTemp.setMessageConverter(messageConverter());
        return rabbitTemp;
    }


    @Bean
    public Queue queue()
    {
        return new Queue(QUEUE);
    }



    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange(EXCHANGE);
    }


    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
    }


}
