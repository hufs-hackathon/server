package com.hachathon.farmmate.api.dto.response;

import com.hachathon.farmmate.api.domain.entity.Faq;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaqDto {

    private String question;

    private String answer;

    public static FaqDto from(Faq faq) {
        return FaqDto
                .builder()
                .question(faq.getQuestion())
                .answer(faq.getAnswer())
                .build();
    }
}
