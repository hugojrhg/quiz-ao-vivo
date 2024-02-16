package com.robson.company.service;

import com.robson.company.builder.ConfiguracaoMapper;
import com.robson.company.dto.ConfiguracaoDTO;
import com.robson.company.repository.ConfiguracaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CofiguracaoService {

    private final ConfiguracaoRepository configuracaoRepository;

    private final ConfiguracaoMapper configuracaoMapper;

    public CofiguracaoService(ConfiguracaoRepository configuracaoRepository, ConfiguracaoMapper configuracaoMapper) {
        this.configuracaoRepository = configuracaoRepository;
        this.configuracaoMapper = configuracaoMapper;
    }

    public ConfiguracaoDTO encontraConfiguracaoPorId(Long id) throws Exception {
        return configuracaoMapper.toDTO(configuracaoRepository.findById(id).orElseThrow(Exception::new));
    }

    public List<ConfiguracaoDTO> encontraTodasConfiguracoes() {
        return configuracaoMapper.toListDTO(configuracaoRepository.findAll());
    }

    public void deletaConfiguracaoPorId(Long id) {
        configuracaoRepository.deleteById(id);
    }

    public ConfiguracaoDTO salvaConfiguracao(ConfiguracaoDTO configuracaoDTO) {
        return configuracaoMapper.toDTO(configuracaoRepository.save(configuracaoMapper.toEntity(configuracaoDTO)));
    }

}
