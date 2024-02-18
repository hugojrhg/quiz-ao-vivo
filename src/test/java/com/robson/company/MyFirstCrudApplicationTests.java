package com.robson.company;

import com.robson.company.model.User;
import com.robson.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyFirstCrudApplicationTests {

	@Autowired
	private UserRepository userRepository;

	//@Test
	void chamaSequenciaCrud(){
		User userGravadoNoBanco = gravarDadosUsuario();
		System.out.println("Valor do usuário gravado no banco: " + userGravadoNoBanco);

		User userAtualizado = atualizarDadosUsuario(userGravadoNoBanco);
		System.out.println("Valor do usuário atualizado: " + userAtualizado);

		apagaUsuario(userAtualizado);
		System.out.println("Apagou o usuário!");
	}

	private User gravarDadosUsuario() {
		User user = new User();
		user.setAge(38);
		user.setName("Samuel");
		user.setFullName("Samuel Ferreira Duarte");
		System.out.println("A - Meu user antes de gravar: " + user);

		User userGravadoNoBanco = userRepository.save(user);

		System.out.println("B - Meu user depois de gravar." + userGravadoNoBanco);
		return userGravadoNoBanco;
	}

	private User atualizarDadosUsuario(User userGravadoNoBanco) {
		userGravadoNoBanco.setName("Nao é samuca");
		return userRepository.save(userGravadoNoBanco);
	}

	private void apagaUsuario(User userParaDeletar) {
		userRepository.delete(userParaDeletar);
	}

}
