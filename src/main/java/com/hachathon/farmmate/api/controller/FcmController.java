package com.hachathon.farmmate.api.controller;

import com.hachathon.farmmate.api.dto.request.NotificationMessage;
import com.hachathon.farmmate.api.service.FirebaseMessagingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FcmController {

    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    @PostMapping("/fcm")
    public String sendNotificationByToken(@RequestBody NotificationMessage notificationMessage) {
        return firebaseMessagingService.sendNotificationByToken(notificationMessage);
    }
}
