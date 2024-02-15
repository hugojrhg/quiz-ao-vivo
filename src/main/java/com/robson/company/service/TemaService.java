package com.robson.company.service;

import com.robson.company.model.Tema;
import com.robson.company.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService {
    @Autowired
    private TemaRepository temaRepository;

    public Tema onSalvar(Tema tema){
        return temaRepository.save(tema);
    }

    public void onDeletar(Tema tema){
        temaRepository.delete(tema);
    }

    public List<Tema> onListTema(){
        return temaRepository.findAll();
    }

    public Optional<Tema> buscarTema(Long id){
        return temaRepository.findById(id);
    }



}
