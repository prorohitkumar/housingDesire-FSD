package com.stackroute.recommendationservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {

    public static final String QUEUEA = "RabbitMQ queue A";
    public static final String QUEUEB = "RabbitMQ queue B";
    public static final String EXCHANGE = "RabbitMQ Topic Exchange";
    public static final String ROUTING_KEYA = "RabbitMQA";
    public static final String ROUTING_KEYB = "RabbitMQB";

    @Bean
    public Queue queueA()
    {
        return new Queue(QUEUEA);
    }

    @Bean
    public Queue queueB()
    {
        return new Queue(QUEUEB);
    }

    @Bean
    public TopicExchange topicExchange()
    {
        return new TopicExchange(EXCHANGE);
    }


    @Bean
    public Binding bindingA(Queue queueA, TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queueA).to(topicExchange).with(ROUTING_KEYA);
    }

   @Bean
    public Binding bindingB(Queue queueB, TopicExchange topicExchange)
    {
        return BindingBuilder.bind(queueB).to(topicExchange).with(ROUTING_KEYB);
    }

    @Bean
    public MessageConverter messageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
