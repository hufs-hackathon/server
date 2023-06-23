//package com.hachathon.farmmate.api.service;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.messaging.*;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Service
//public class FCMInitializer {
//
//    @PostConstruct
//    public void initialize() throws IOException {
//        // initialize Admin SDK using OAuth 2.0 refresh token
//
//        FileInputStream refreshToken = new FileInputStream("D:\\farmmate\\src\\main\\resources\\firebase\\farmate-android-firebase-adminsdk-itv8d-c1ac5475a8.json");
//
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(refreshToken))
//                .setProjectId("farmate-android")
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
//
//    // 알람 종류별로 title, content 변경해서 메서드 만들어야하는듯 일단 예시로 하나 넣어놓음
//    // send message to android
//    public String sendMessage(int requestId, String registrationToken) throws FirebaseMessagingException {
//        Message message = Message.builder()
//                .setAndroidConfig(AndroidConfig.builder()
//                        .setPriority(AndroidConfig.Priority.HIGH)
//                        .setRestrictedPackageName("com.practice.farmate_android") // 애플리케이션 패키지 이름
//                        .setDirectBootOk(true)
//                        .setNotification(AndroidNotification.builder()
//                                .setTitle("Farmate") // 알림 제목
//                                .setBody("곡물을 재배할 시기예요!") // 알림 본문
//                                .build())
//                        .build())
//                .putData("requestId", Integer.toString(requestId)) // request 식별 정보(requestId) 넣기
//                .setToken(registrationToken) // 요청자의 디바이스에 대한 registration token으로 설정
//                .build();
//
//
//        // Send a message to the device corresponding to the provided registration token.
//        String response = FirebaseMessaging.getInstance().send(message);
//
//        return response;
//    }
//}