/*
package com.daoshu.system;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

*/
/*@Configuration
@EnableWebSocketMessageBroker*//*

public class RabbitMqConfiguration  
//extends AbstractWebSocketMessageBrokerConfigurer
{
	
*/
/*	*//*
*/
/** 消息交换机的名字*//*
*/
/*
    public static final String EXCHANGE = "hello";

	 @Bean
	 public Queue helloQueue() {
	        return new Queue(EXCHANGE);
	 }
	 
	 @Bean
	 public Queue userQueue() {
	        return new Queue("user");
	 }
	 
	 @Bean
	 public FanoutExchange fanoutExchange() {
	    return new FanoutExchange("fanoutExchange");
	 }
	 
	 @Bean
	 public Binding bindingExchangeFanoutA(Queue userQueue, FanoutExchange fanoutExchange) {
	       return BindingBuilder.bind(userQueue).to(fanoutExchange);
	 }
	 
	 
	 @Bean
	 public Binding bindingExchangeFanoutB(Queue helloQueue, FanoutExchange fanoutExchange) {
	     return BindingBuilder.bind(helloQueue).to(fanoutExchange);
	  }
	 
	 @Override
	 public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
	        //加入setAllowedOrigins("*")防止浏览器出现403 Forbidden的问题
	        stompEndpointRegistry.addEndpoint("/pay-result").setAllowedOrigins("*").withSockJS();
	    }

    @Override
	 public void configureMessageBroker(MessageBrokerRegistry registry) {
	        registry.enableStompBrokerRelay("/topic", "/hello");
	        registry.setApplicationDestinationPrefixes("/app");
	   }*//*


}
*/
