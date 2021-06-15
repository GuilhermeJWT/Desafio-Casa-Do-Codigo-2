package br.com.systemsgs.casadocodigo.exception;

public class GenerationExceptionClass extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public GenerationExceptionClass (String mensagem) {
		super(mensagem);
	}

}
