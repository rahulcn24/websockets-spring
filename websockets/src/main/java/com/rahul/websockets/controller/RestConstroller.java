package com.rahul.websockets.controller;

import com.rahul.websockets.model.RequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RestConstroller {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, RequestModel requestModel) {
        log.info("handling message : {}, to : {}", requestModel, to);
        simpMessagingTemplate.convertAndSend("/topic/messages", requestModel);
    }
}
