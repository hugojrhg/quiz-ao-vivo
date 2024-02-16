package com.robson.company.controller;

import com.robson.company.dto.ConfiguracaoDTO;
import com.robson.company.service.CofiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuracao")
public class ConfiguracaoController {

    @Autowired
    CofiguracaoService configuracaoService;

    @GetMapping
    public ResponseEntity<List<ConfiguracaoDTO>> encontraTodasConfiguracoes(){
        return new ResponseEntity<>(configuracaoService.encontraTodasConfiguracoes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracaoDTO> encontraConfiguracaoPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(configuracaoService.encontraConfiguracaoPorId(id), HttpStatus.OK);
    }

    @PostMapping("/salva")
    public ResponseEntity<ConfiguracaoDTO> salvaConfiguracao(@RequestBody ConfiguracaoDTO configuracaoDTO) {
        return new ResponseEntity<>(configuracaoService.salvaConfiguracao(configuracaoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity deletaConfiguracaoPorId(@PathVariable Long id){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
