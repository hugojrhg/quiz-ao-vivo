package com.robson.company;

import com.robson.company.builder.QuestaoMapper;
import com.robson.company.dto.AlternativaDTO;
import com.robson.company.dto.QuestaoDTO;
import com.robson.company.repository.AlternativaRepository;
import com.robson.company.repository.QuestaoRepository;
import com.robson.company.service.AlternativaService;
import com.robson.company.service.QuestaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QuestaoTests {

	@Autowired
	private QuestaoService questaoService;

	@Autowired
	private AlternativaService alternativaService;

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private AlternativaRepository alternativaRepository;

	@Autowired
	private QuestaoMapper questaoMapper;

	@Test
	void chamaSequenciaCrud() throws Exception {
		montarAlternativaDaQuestao();
	}
	private void montarAlternativaDaQuestao() throws Exception {
		//Criando uma alternativa para colocar na questão
		System.out.println("Criando alternativa...");
		AlternativaDTO alternativaDTO = new AlternativaDTO(1L,"Valdomiro", true);

		//Criando uma questão e passando a alternativa criada anteriormente nela
		System.out.println("Criando questão usando a alternativa...");
		QuestaoDTO questaoDTO = new QuestaoDTO(1L, "Turma", "Quem é o Kratos da turma?", "Valdomiro", List.of(alternativaDTO));

		//Aqui estamos salvando a questão, como usamos o CascadeType.ALL o esperado é que mesmo sem salvar a alternativa diretamente,
		//no momento que você salva uma questão que contém aquela alternativa ela será salva por cascata no banco.
		System.out.println("Salvando questão...");
		questaoService.salvarQuestao(questaoDTO);

		//Verificando se a nossa alternativa foi salva no banco
		System.out.println("Todas as alternativas existentes: " + alternativaService.getAllAlternativas());

		//Criando uma nova versão da nossa alternativa para testar a atualização
		System.out.println("Criando nova alternativa para atualizar...");
		AlternativaDTO alternativaDTO2 = new AlternativaDTO(null, "Samuca", false);

		//Atualizando nossa alternativa
		System.out.println("Atualizando alternativa...");
		alternativaService.atualizaAlternativa(alternativaDTO2, 1L);

		//Novamente a operação foi realizada em cascata,
		//ao atualizar a alternativa, automaticamente é atualizada a referência dela dentro da questão
		System.out.println("Alternativas atualizadas: " + questaoService.buscarPorId(1L).getAlternativas());

		//Agora vamos apagar a questão para testar o orphanRemoval,
		//que tem como objetivo remover um filho(alternativa) se o pai(questão) for removido
		System.out.println("Todas as questões antes de deletar a questão: " + questaoRepository.findAll());
		System.out.println("Todas as Alternativas antes de deletar a questão: " + alternativaRepository.findAll());

		System.out.println("Apagando questão...");
		questaoService.apagarQuestao(1L);

		System.out.println("Todas as questões depois de deletar a questão: " + questaoRepository.findAll());
		System.out.println("Todas as Alternativas depois de deletar a questão: " + alternativaRepository.findAll());
	}

	/*private void crudQuestao(){
		Questao questaoQueEuQueroSalvar = new Questao("tema", "pergunta", "resposta");
		questaoService.salvarQuestao(questaoQueEuQueroSalvar);
		System.out.println("Retorno salvado: " + questaoQueEuQueroSalvar);

		questaoQueEuQueroSalvar.setPergunta("Sera que funciona?");
		questaoService.salvarQuestao(questaoQueEuQueroSalvar);
		System.out.println("Mudou o nome do tema? " + questaoQueEuQueroSalvar);

		questaoService.apagarQuestao(questaoQueEuQueroSalvar);
		System.out.println("Apagou!");
	}*/



}
