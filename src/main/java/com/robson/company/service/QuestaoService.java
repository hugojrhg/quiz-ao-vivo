package com.robson.company.service;

import com.robson.company.builder.QuestaoMapper;
import com.robson.company.dto.QuestaoDTO;
import com.robson.company.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;
    @Autowired
    private QuestaoMapper questaoMapper;

//    public QuestaoDTO salvarQuestao(QuestaoDTO questaoDto) throws Exception {
//        Long novaQuestaoId = null;
//        if (Objects.nonNull(questaoDto.getId())) {
//            novaQuestaoId = questaoDto.getId();
//            if (questaoRepository.existsById(novaQuestaoId)) {
//                throw new Exception();
//            } else {
//                return questaoMapper.toDTO(questaoRepository.save(questaoMapper.toEntity(questaoDto)));
//            }
//
//        } else {
//            return questaoMapper.toDTO(questaoRepository.save(questaoMapper.toEntity(questaoDto)));
//        }
//    }

    public QuestaoDTO salvarQuestao(QuestaoDTO questaoDto) throws Exception {
        Long novaQuestaoId = null;
        if (Objects.nonNull(questaoDto.getId())) {
            novaQuestaoId = questaoDto.getId();
            if (questaoRepository.existsById(novaQuestaoId)) {
                throw new Exception();
            } else {
                return questaoMapper.toDTO(questaoRepository.save(questaoMapper.toEntity(questaoDto)));
            }

        } else {
            return questaoMapper.toDTO(questaoRepository.save(questaoMapper.toEntity(questaoDto)));
        }
    }

    public void apagarQuestao(Long id){
        questaoRepository.deleteById(id);
    }

    public QuestaoDTO buscarPorId(Long id) throws Exception {
        return questaoMapper.toDTO(questaoRepository.findById(id).orElseThrow(Exception::new));
    }

}
