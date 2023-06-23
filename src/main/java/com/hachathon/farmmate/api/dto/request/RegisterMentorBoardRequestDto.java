package com.hachathon.farmmate.api.dto.request;


import com.hachathon.farmmate.api.dto.response.FaqDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMentorBoardRequestDto {

    @NotBlank
    @Size(max = 255)
    private String title;

    @NotBlank
    @Size(max = 255)
    private String introduce;

    @NotBlank
    @Size(max = 255)
    private String category;

    private List<FaqDto> faqList = new ArrayList<>();
}
