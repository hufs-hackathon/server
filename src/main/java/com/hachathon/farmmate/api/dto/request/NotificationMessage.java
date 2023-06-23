package com.hachathon.farmmate.api.dto.request;

import lombok.*;

import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationMessage {
    private String registerToken;
    private String title;
    private String body;
    private Map<String, String> data;
}
