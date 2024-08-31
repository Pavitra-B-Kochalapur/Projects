package com.springboot.mvc.event.listners;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppEventHandler {

	@EventListener
	public void test(ContextStartedEvent cse) {
		System.out.println("Context started event received...");
	}
	
	
	@EventListener
	public void onApplicationStartEvent1(ContextStartedEvent cse) {
		System.out.println("Context started event received...");
	}
	
	
	@EventListener
	public void onApplicationStartEvent2(ContextStartedEvent cse) {
		System.out.println("Context started event received...");
	}
	
	@EventListener
	public void onApplicationStoppedEvent2(ContextStoppedEvent cse) {
		System.out.println("Context stopped event received...");
	}
}
