package com.michaelyzh.parcel_path.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    //define the name of the queues
    final static String insertSubParcel = "topic.insertSubParcel";
    final static String SMS = "topic.SMS";

    /**
     * define the queue
     * @return
     */
    @Bean
    public Queue queue1(){
        return new Queue(RabbitConfig.insertSubParcel);
    }
    @Bean
    public Queue queue2(){
        return new Queue(RabbitConfig.SMS);
    }

    /**
     * define the exchange
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * bind topic on the exchange
     * @param queue1
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangQueue1(Queue queue1, TopicExchange exchange) {
        return BindingBuilder.bind(queue1).to(exchange).with("topic.insertSubParcel");
    }
    @Bean
    Binding bindingExchangeQueue2(Queue queue2, TopicExchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with("topic.SMS");
    }

}
