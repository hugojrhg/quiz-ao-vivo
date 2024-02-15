package com.robson.company.service;

import com.robson.company.builder.AlternativaMapper;
import com.robson.company.dto.AlternativaDTO;
import com.robson.company.model.Alternativa;
import com.robson.company.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativaService {

    @Autowired
    AlternativaRepository alternativaRepository;

    @Autowired
    AlternativaMapper alternativaMapper;

    public AlternativaDTO getAlternativaById(Long id) throws Exception {
        return alternativaMapper.toDTO(alternativaRepository.findById(id).orElseThrow(Exception::new));
    }

    public List<AlternativaDTO> getAllAlternativas() {
        return alternativaMapper.toListDTO(alternativaRepository.findAll());
    }

    public AlternativaDTO salvaAlternativa(AlternativaDTO alternativaDTO){
        //return alternativaDTO <-- Alternativa <-- AlternativaDTO <-- Alternativa <-- AlternativaDTO
        return alternativaMapper.toDTO(alternativaRepository.save(alternativaMapper.toEntity(alternativaDTO)));
    }

    public void deletaAlternativa(Long id) throws Exception {
        alternativaRepository.delete(alternativaMapper.toEntity(getAlternativaById(id)));
    }

    //Com esse método você consegue mudar um método já salvo no banco, passando uma nova alternativa
    public AlternativaDTO atualizaAlternativa(AlternativaDTO novaAlternativa, Long id) throws Exception {
        Alternativa alternativaAtualizada = alternativaRepository.findById(id).orElseThrow(Exception::new);

        alternativaAtualizada.setAlternativa(novaAlternativa.getAlternativa());
        alternativaAtualizada.setEhCorreta(novaAlternativa.isEhCorreta());

        return alternativaMapper.toDTO(alternativaRepository.save(alternativaAtualizada));
    }

}
