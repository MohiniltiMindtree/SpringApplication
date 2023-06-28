package com.example.DominosEurekaClient.Service;

import com.example.DominosEurekaClient.DTO.AutoCompleteRequestDto;
import com.example.DominosEurekaClient.DTO.AutoCompleteResponseDto;
import com.example.DominosEurekaClient.Model.Dominoes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DominosService {

    void saveData(Dominoes doninos);

    void saveAll(List<Dominoes> doninos);

    Dominoes getDominoes(Integer id);

    List<Dominoes >getAllDominoes();

    boolean deleteDominoes(Integer id);

    Page<AutoCompleteResponseDto> getNameAutoComplete(AutoCompleteRequestDto requestDto, Pageable pageable);

    Dominoes updateDominos( Dominoes dominos);
}
