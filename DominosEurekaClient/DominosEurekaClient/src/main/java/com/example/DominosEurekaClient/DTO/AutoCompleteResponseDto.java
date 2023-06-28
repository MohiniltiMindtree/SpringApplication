package com.example.DominosEurekaClient.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoCompleteResponseDto {

    private int fieldId;
    private String fieldName;


}
