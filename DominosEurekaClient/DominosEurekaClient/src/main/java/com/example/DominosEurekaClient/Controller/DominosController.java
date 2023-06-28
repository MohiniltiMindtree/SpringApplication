package com.example.DominosEurekaClient.Controller;

import com.example.DominosEurekaClient.DTO.AutoCompleteRequestDto;
import com.example.DominosEurekaClient.DTO.AutoCompleteResponseDto;
import com.example.DominosEurekaClient.Exception.UserNotFoundException;
import com.example.DominosEurekaClient.Model.Dominoes;
import com.example.DominosEurekaClient.Service.DominosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dominos")
@CrossOrigin
public class DominosController {

    @Autowired
    DominosService dominosService;

    @PostMapping("/saveDominos")
    public String saveDominosData(@RequestBody Dominoes dominos)
    {
        dominosService.saveData(dominos);
        return "data save Successfully";
    }

    @PostMapping("/saveAllDominos")
    public String saveAllDominosData(@RequestBody List<Dominoes > dominos)
    {
        dominosService.saveAll(dominos);
        return "All data save Successfully";
    }

    @GetMapping("/getAllDominos")
    public List<Dominoes> getAllDominosData()
    {
        return dominosService.getAllDominoes();
    }

    @GetMapping("/getDominos/{id}")
    public Dominoes getDominosData(@PathVariable Integer id)
    {

        return dominosService.getDominoes(id);
    }

   // @Operation(summary="", description="" this annotation on swagger)
    @DeleteMapping("/deleteDominos/{id}")
    public ResponseEntity<HttpStatus> deleteDominosData(@PathVariable Integer id)
    {
        boolean isDeleted= dominosService.deleteDominoes(id);
        return ResponseEntity.status(isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/auto-complete/name")
    public ResponseEntity<Page<AutoCompleteResponseDto>> nameAutoComplete(@RequestBody AutoCompleteRequestDto requestDto, Pageable pageable)
    {
        return ResponseEntity.status(HttpStatus.OK).body(dominosService.getNameAutoComplete(requestDto,pageable));
    }

    @PostMapping("/updatedominos")
    public Dominoes updateDonminos(@RequestBody Dominoes dominos)
    {
        return dominosService.updateDominos(dominos);
    }
}
