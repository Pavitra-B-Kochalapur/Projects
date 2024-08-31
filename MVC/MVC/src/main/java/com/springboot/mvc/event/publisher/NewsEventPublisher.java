package com.springboot.mvc.event.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.springboot.mvc.event.events.NewsEvent;

@Component
public class NewsEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher appEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		
		this.appEventPublisher = applicationEventPublisher;
	}
	
	
	public void publish() {
		NewsEvent ne = new NewsEvent(this);
		this.appEventPublisher.publishEvent(ne);
	}

}
