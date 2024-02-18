package com.robson.company.controller;

import com.robson.company.dto.QuestionDTO;
import com.robson.company.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("{id}")
    public ResponseEntity<QuestionDTO> findQuestionById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<QuestionDTO> saveQuestion(@RequestBody QuestionDTO questionDTO) throws Exception {
        return new ResponseEntity<>(questionService.saveQuestion(questionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteQuestion(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
