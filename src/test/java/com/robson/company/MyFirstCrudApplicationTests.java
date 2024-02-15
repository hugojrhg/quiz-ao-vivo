package com.robson.company;

import com.robson.company.model.Usuario;
import com.robson.company.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyFirstCrudApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	//@Test
	void chamaSequenciaCrud(){
		Usuario usuarioGravadoNoBanco = gravarDadosUsuario();
		System.out.println("Valor do usuário gravado no banco: " + usuarioGravadoNoBanco);

		Usuario usuarioAtualizado = atualizarDadosUsuario(usuarioGravadoNoBanco);
		System.out.println("Valor do usuário atualizado: " + usuarioAtualizado);

		apagaUsuario(usuarioAtualizado);
		System.out.println("Apagou o usuário!");
	}

	private Usuario gravarDadosUsuario() {
		Usuario usuario = new Usuario();
		usuario.setAge(38);
		usuario.setName("Samuel");
		usuario.setFullName("Samuel Ferreira Duarte");
		System.out.println("A - Meu usuario antes de gravar: " + usuario);

		Usuario usuarioGravadoNoBanco = usuarioRepository.save(usuario);

		System.out.println("B - Meu usuario depois de gravar." + usuarioGravadoNoBanco);
		return usuarioGravadoNoBanco;
	}

	private Usuario atualizarDadosUsuario(Usuario usuarioGravadoNoBanco) {
		usuarioGravadoNoBanco.setName("Nao é samuca");
		return usuarioRepository.save(usuarioGravadoNoBanco);
	}

	private void apagaUsuario(Usuario usuarioParaDeletar) {
		usuarioRepository.delete(usuarioParaDeletar);
	}

}
