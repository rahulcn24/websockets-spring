package com.rahul.websockets;

import com.rahul.websockets.model.RequestModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomSocketScheduler {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedDelay = 3000)
    public void sendScheduledMessage() {
        log.info("Sending message ...");
        RequestModel requestModel1 = new RequestModel("Hi", "server");
        RequestModel requestModel2 = new RequestModel("Hi rahul", "server");
        RequestModel requestModel3 = new RequestModel("Hi online", "server");
        simpMessagingTemplate.convertAndSend("/topic/messages", requestModel1);
        simpMessagingTemplate.convertAndSend("/topic/messages/rahul", requestModel2);
        simpMessagingTemplate.convertAndSend("/topic/messages/online", requestModel3);
    }

    public void alive(){
        log.info("alive");
    }
}
