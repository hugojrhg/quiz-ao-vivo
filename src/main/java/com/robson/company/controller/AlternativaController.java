package com.robson.company.controller;

import com.robson.company.dto.AlternativaDTO;
import com.robson.company.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternativa")
public class AlternativaController {

    @Autowired
    AlternativaService alternativaService;

    @GetMapping
    public ResponseEntity<List<AlternativaDTO>> encontraTodasAlternativas(){
        return new ResponseEntity<>(alternativaService.getAllAlternativas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlternativaDTO> encontraAlternativaPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(alternativaService.getAlternativaById(id), HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<AlternativaDTO> salvaAlternativa(@RequestBody AlternativaDTO alternativaDTO) {
        return new ResponseEntity<>(alternativaService.salvaAlternativa(alternativaDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity deletaAlternativa(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualiza/{id}")
    public ResponseEntity<AlternativaDTO> atualizaAlternativa(@RequestBody AlternativaDTO alternativaDTO, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(alternativaService.atualizaAlternativa(alternativaDTO, id), HttpStatus.CREATED);
    }

}
