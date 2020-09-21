package com.example.project;

public class CupomFiscal {

	public static String NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	public static String LOGRADOURO = "Av. Projetada Leste";
	public static int NUMERO = 500;
	public static String COMPLEMENTO = "EUC F32/33/34";
	public static String BAIRRO = "Br. Sta Genebra";
	public static String MUNICIPIO = "Campinas";
	public static String ESTADO = "SP";
	public static String CEP = "13080-395";
	public static String TELEFONE = "(19) 3756-7408";
	public static String OBSERVACAO = "Loja 1317 (PDP)";
	public static String CNPJ = "42.591.651/0797-34";
	public static String INSCRICAO_ESTADUAL = "244.898.500.113";

	public static String Spacer = System.lineSeparator();

	public static void typerwriter(){
		
		if (NOME_LOJA.isEmpty()){
			System.out.printf("O campo nome da loja é obrigatório");
			return;
		}

		if (LOGRADOURO.isEmpty()){
			System.out.printf("O campo logradouro do endereço é obrigatório");
			return;
		}

		String _logradouro = LOGRADOURO + ", ";
		String _numero = "0";

		if (NUMERO == 0){
			_numero = "s/n";
		}else{
			_numero = String.format ("%d", NUMERO);
		}
				
		String _complemento = " " + COMPLEMENTO;
		String _bairro = BAIRRO.isEmpty()? "" : BAIRRO + " - ";

		if (MUNICIPIO.isEmpty()){
			System.out.printf("O campo município do endereço é obrigatório");
			return;
		}

		String _municipio = MUNICIPIO + " - ";

		if (ESTADO.isEmpty()){
			System.out.printf("O campo estado do endereço é obrigatório");
			return;
		}

		String _cep = CEP.isEmpty()? "" : "CEP:" + CEP;
		String _telefone = TELEFONE.isEmpty()? "" : " Tel " + TELEFONE;

		if (CNPJ.isEmpty()){
			System.out.printf("O campo CNPJ da loja é obrigatório");
			return;
		}

		String _cnpj = "CNPJ: " + CNPJ;

		if (INSCRICAO_ESTADUAL.isEmpty()){
			System.out.printf("O campo inscrição estadual da loja é obrigatório");
			return;
		}

		String _inscricao_estadual = "IE: " + INSCRICAO_ESTADUAL;

		System.out.println (NOME_LOJA + Spacer +
		_logradouro + _numero + _complemento + Spacer +
		_bairro + _municipio + ESTADO + Spacer +
		_cep + _telefone + Spacer +
		OBSERVACAO + Spacer +
		_cnpj + Spacer +
		_inscricao_estadual + Spacer);	
	}

	public static void main(final String[] args) {
		typerwriter();		
	}

}
 