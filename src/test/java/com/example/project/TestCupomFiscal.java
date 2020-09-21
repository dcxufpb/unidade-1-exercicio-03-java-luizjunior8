package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();

	@Test
	public void lojaCompleta() {
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		rodarTestarOutput("O campo nome da loja é obrigatório");
		CupomFiscal.NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	}
	
	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		rodarTestarOutput("O campo logradouro do endereço é obrigatório");
		CupomFiscal.LOGRADOURO = "Av. Projetada Leste";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK +
				"Av. Projetada Leste, s/n EUC F32/33/34" + BREAK +
				"Br. Sta Genebra - Campinas - SP" + BREAK +
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK +
				"Loja 1317 (PDP)" + BREAK +
				"CNPJ: 42.591.651/0797-34" + BREAK +
				"IE: 244.898.500.113" + BREAK);

		CupomFiscal.NUMERO = 500;
	}
	
	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		rodarTestarOutput("O campo município do endereço é obrigatório");
		CupomFiscal.MUNICIPIO = "Campinas";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		rodarTestarOutput("O campo estado do endereço é obrigatório");
	    CupomFiscal.ESTADO = "SP";
	}
	
	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		rodarTestarOutput("O campo CNPJ da loja é obrigatório");
	    CupomFiscal.CNPJ = "42.591.651/0797-34";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		rodarTestarOutput("O campo inscrição estadual da loja é obrigatório");
		CupomFiscal.INSCRICAO_ESTADUAL = "244.898.500.113";
	}
	
	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Jr Tech";
		CupomFiscal.LOGRADOURO = "Rua Geraldo Correia de Melo";
		CupomFiscal.NUMERO = 100;
		CupomFiscal.COMPLEMENTO = "Casa";
		CupomFiscal.BAIRRO = "Centro";
		CupomFiscal.MUNICIPIO = "Araçagi";
		CupomFiscal.ESTADO = "PB";
		CupomFiscal.CEP = "58270-000";
		CupomFiscal.TELEFONE = "(83) 98111-2697";
		CupomFiscal.OBSERVACAO = "Matriz";
		CupomFiscal.CNPJ = "66.651.293/0001-85";
		CupomFiscal.INSCRICAO_ESTADUAL = "222.333.444.555";
		
		//E atualize o texto esperado abaixo
		rodarTestarOutput("Jr Tech" + BREAK + 
				"Rua Geraldo Correia de Melo, 100 Casa" + BREAK + 
				"Centro - Araçagi - PB" + BREAK + 
				"CEP:58270-000 Tel (83) 98111-2697" + BREAK + 
				"Matriz" + BREAK + 
				"CNPJ: 66.651.293/0001-85" + BREAK + 
				"IE: 222.333.444.555" + BREAK);
	}

	private void rodarTestarOutput(String expected) {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		// action
		CupomFiscal.main(null);

		// assertion
		assertEquals(expected, bos.toString());

		// undo the binding in System
		System.setOut(originalOut);
	}
}
