package com.example.DominosEurekaClient.ServiceImpl;

import com.example.DominosEurekaClient.DTO.AutoCompleteRequestDto;
import com.example.DominosEurekaClient.DTO.AutoCompleteResponseDto;
import com.example.DominosEurekaClient.Exception.UserNotFoundException;
import com.example.DominosEurekaClient.Model.Dominoes;
import com.example.DominosEurekaClient.Repository.DominosRepository;
import com.example.DominosEurekaClient.Service.DominosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DominosServiceImpl implements DominosService {

    @Autowired
    DominosRepository dominosRepository;
    @Override
    public void saveData(Dominoes doninos) {
        dominosRepository.saveAndFlush(doninos);
    }

    @Override
    public void saveAll(List<Dominoes> dominos) {
        dominosRepository.saveAllAndFlush(dominos);
    }

    @Override
    public Dominoes getDominoes(Integer id) {
        return dominosRepository.findById(id).get();
    }

    @Override
    public List<Dominoes> getAllDominoes() {
        return dominosRepository.findAll();
}

    @Override
    public boolean deleteDominoes(Integer id) {
        boolean isDeleted=false;
        if (dominosRepository.existsById(id)) {
            //throw new UserNotFoundException("Invlaid Id was provided");
        }

        dominosRepository.deleteById(id);

        isDeleted=true;
        return isDeleted;
    }

    @Override
    public Page<AutoCompleteResponseDto> getNameAutoComplete(AutoCompleteRequestDto requestDto, Pageable pageable) {
        Page<Dominoes> data = dominosRepository.findByNameContainingIgnoreCaseOrderByNameAsc(requestDto.getSearchText(), pageable);
        return new PageImpl<>(data.getContent().stream().map(p->new AutoCompleteResponseDto(p.getDid(),p.getName())).collect(Collectors.toList()),
                PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),pageable.getSort()),data.getTotalElements());
    }

    @Override
    public Dominoes updateDominos(Dominoes dominos) {
        Dominoes dominoes = dominosRepository.findById(dominos.getDid()).get();
        dominoes.setDid(dominos.getDid());
        dominoes.setName(dominos.getName());
        dominoes.setAddress(dominos.getAddress());
       return dominosRepository.saveAndFlush(dominoes);
    }
}
