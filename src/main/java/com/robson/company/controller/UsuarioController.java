package com.robson.company.controller;

import com.robson.company.dto.UsuarioDTO;
import com.robson.company.model.Usuario;
import com.robson.company.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("salvar")
    public UsuarioDTO save(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.salvarUsuario(usuarioDTO);
    }

    @GetMapping("buscar-por-id/{id}")
    public UsuarioDTO save(@PathVariable Long id){
        return usuarioService.buscarPorId(id).get();
    }


}
