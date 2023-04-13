package com.stackroute.authenticationservice.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String  ROUTING_A= "routing_A";
    public static final String  ROUTING_B= "routing_B";
    public static final String  ROUTING_C= "routing_C";

    @Bean
    Queue queueA(){

        return new Queue("designer",false);
    }
    @Bean
    Queue queueB(){

        return new Queue("customer",false);
    }

    @Bean
    Queue queueC(){

        return new Queue("mail",false);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("data_exchange");
    }

    @Bean
    Binding bindingA(Queue queueA , DirectExchange data_exchange){
        return BindingBuilder.bind(queueA)
                .to(data_exchange)
                .with(ROUTING_A);
    }

    @Bean
    Binding bindingB(Queue queueB , DirectExchange data_exchange){
        return BindingBuilder.bind(queueB)
                .to(data_exchange)
                .with(ROUTING_B);
    }

    @Bean
    Binding bindingC(Queue queueC , DirectExchange data_exchange){
        return BindingBuilder.bind(queueC)
                .to(data_exchange)
                .with(ROUTING_C);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}