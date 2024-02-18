package com.robson.company.service;

import com.robson.company.model.Theme;
import com.robson.company.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public Theme onSave(Theme theme){
        return themeRepository.save(theme);
    }

    public void onDelete(Theme theme){
        themeRepository.delete(theme);
    }

    public List<Theme> onListTheme(){
        return themeRepository.findAll();
    }

    public Optional<Theme> findTheme(Long id){
        return themeRepository.findById(id);
    }


}
