package com.robson.company.controller;

import com.robson.company.dto.QuestaoDTO;
import com.robson.company.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questao")
public class QuestaoController {

    @Autowired
    QuestaoService questaoService;

    @GetMapping("{id}")
    public ResponseEntity<QuestaoDTO> encontraQuestaoPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(questaoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<QuestaoDTO> salvaQuestao(@RequestBody QuestaoDTO questaoDTO) throws Exception {
        return new ResponseEntity<>(questaoService.salvarQuestao(questaoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity deletaQuestao(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
