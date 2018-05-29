package enums;

public enum MensagensDeErro {
	OBJ_NULO(""),
	STR_VAZIA("");	
	
	private String mensagem;
	
	MensagensDeErro(String mensagem){ this.mensagem = mensagem;}
	
	public String getValue() {return this.mensagem;}

}
