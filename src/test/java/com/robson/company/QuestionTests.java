package com.robson.company;

import com.robson.company.builder.QuestionMapper;
import com.robson.company.dto.AlternativeDTO;
import com.robson.company.dto.QuestionDTO;
import com.robson.company.repository.AlternativeRepository;
import com.robson.company.repository.QuestionRepository;
import com.robson.company.service.AlternativeService;
import com.robson.company.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QuestionTests {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AlternativeService alternativeService;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AlternativeRepository alternativeRepository;

	@Autowired
	private QuestionMapper questionMapper;

	@Test
	void chamaSequenciaCrud() throws Exception {
		montarAlternativaDaQuestao();
	}
	private void montarAlternativaDaQuestao() throws Exception {
		//Criando uma alternativa para colocar na questão
		System.out.println("Criando alternativa...");
		AlternativeDTO alternativeDTO = new AlternativeDTO(1L,"Valdomiro", true);

		//Criando uma questão e passando a alternativa criada anteriormente nela
		System.out.println("Criando questão usando a alternativa...");
		QuestionDTO questionDTO = new QuestionDTO(1L, "Turma", "Quem é o Kratos da turma?", List.of(alternativeDTO));

		//Aqui estamos salvando a questão, como usamos o CascadeType.ALL o esperado é que mesmo sem salvar a alternativa diretamente,
		//no momento que você salva uma questão que contém aquela alternativa ela será salva por cascata no banco.
		System.out.println("Salvando questão...");
		questionService.saveQuestion(questionDTO);

		//Verificando se a nossa alternativa foi salva no banco
		System.out.println("Todas as alternativas existentes: " + alternativeService.getAllAlternatives());

		//Criando uma nova versão da nossa alternativa para testar a atualização
		System.out.println("Criando nova alternativa para atualizar...");
		AlternativeDTO alternativeDTO2 = new AlternativeDTO(null, "Samuca", false);

		//Atualizando nossa alternativa
		System.out.println("Atualizando alternativa...");
		alternativeService.updateAlternative(alternativeDTO2, 1L);

		//Novamente a operação foi realizada em cascata,
		//ao atualizar a alternativa, automaticamente é atualizada a referência dela dentro da questão
		System.out.println("Alternativas atualizadas: " + questionService.findById(1L).getAlternativeList());

		//Agora vamos apagar a questão para testar o orphanRemoval,
		//que tem como objetivo remover um filho(alternativa) se o pai(questão) for removido
		System.out.println("Todas as questões antes de deletar a questão: " + questionRepository.findAll());
		System.out.println("Todas as Alternativas antes de deletar a questão: " + alternativeRepository.findAll());

		System.out.println("Apagando questão...");
		questionService.deleteQuestion(1L);

		System.out.println("Todas as questões depois de deletar a questão: " + questionRepository.findAll());
		System.out.println("Todas as Alternativas depois de deletar a questão: " + alternativeRepository.findAll());
	}

	/*private void crudQuestao(){
		Question questaoQueEuQueroSalvar = new Question("tema", "pergunta", "resposta");
		questionService.salvarQuestao(questaoQueEuQueroSalvar);
		System.out.println("Retorno salvado: " + questaoQueEuQueroSalvar);

		questaoQueEuQueroSalvar.setPergunta("Sera que funciona?");
		questionService.salvarQuestao(questaoQueEuQueroSalvar);
		System.out.println("Mudou o nome do tema? " + questaoQueEuQueroSalvar);

		questionService.apagarQuestao(questaoQueEuQueroSalvar);
		System.out.println("Apagou!");
	}*/



}
