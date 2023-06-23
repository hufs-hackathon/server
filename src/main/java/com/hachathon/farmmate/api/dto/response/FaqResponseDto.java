package com.hachathon.farmmate.api.dto.response;

import com.hachathon.farmmate.api.domain.entity.Faq;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaqResponseDto {

    private String question;

    private String answer;

    public static FaqResponseDto from(Faq faq) {
        return FaqResponseDto
                .builder()
                .question(faq.getQuestion())
                .answer(faq.getAnswer())
                .build();
    }
}
