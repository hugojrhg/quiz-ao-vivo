package com.robson.company.controller;

import com.robson.company.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theme")
public class ThemeController {
    @Autowired
    ThemeService themeService;

    //@GetMapping
    //public


}
