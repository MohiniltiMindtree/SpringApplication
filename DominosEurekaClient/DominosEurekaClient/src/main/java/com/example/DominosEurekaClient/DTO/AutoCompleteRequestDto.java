package com.example.DominosEurekaClient.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor(force = true)
public class AutoCompleteRequestDto {

    @NonNull
    private String searchText;
}
