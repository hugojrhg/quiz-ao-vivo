package com.robson.company.service;

import com.robson.company.builder.UsuarioMapper;
import com.robson.company.dto.UsuarioDTO;
import com.robson.company.model.Usuario;
import com.robson.company.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioMapper usuarioMapper;


    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioModel = usuarioMapper.toEntity(usuarioDTO);
        usuarioModel = usuarioRepository.save(usuarioModel);

        return usuarioMapper.toDTO(usuarioModel);
    }

    public List<Usuario> salvarVariosUsuarios(List<Usuario> usuarioLista) {
        return usuarioRepository.saveAll(usuarioLista);
    }

    public Optional<UsuarioDTO> buscarPorId(Long id) {
       return Optional.ofNullable(usuarioMapper.toDTO(usuarioRepository.findById(id).get()));
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioController = usuarioRepository.findById(usuario.getId());
        return usuarioRepository.save(usuarioController.get());
    }

    public void apagarUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

}
