package com.robson.company.service;

import com.robson.company.builder.ConfigurationMapper;
import com.robson.company.dto.ConfigurationDTO;
import com.robson.company.repository.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    private final ConfigurationMapper configurationMapper;

    public ConfigurationService(ConfigurationRepository configurationRepository, ConfigurationMapper configurationMapper) {
        this.configurationRepository = configurationRepository;
        this.configurationMapper = configurationMapper;
    }

    public ConfigurationDTO findConfigurationById(Long id) throws Exception {
        return configurationMapper.toDTO(configurationRepository.findById(id).orElseThrow(Exception::new));
    }

    public List<ConfigurationDTO> findAllConfigurations() {
        return configurationMapper.toListDTO(configurationRepository.findAll());
    }

    public void deleteConfigurationById(Long id) {
        configurationRepository.deleteById(id);
    }

    public ConfigurationDTO saveConfiguration(ConfigurationDTO configurationDTO) {
        return configurationMapper.toDTO(configurationRepository.save(configurationMapper.toEntity(configurationDTO)));
    }

}
