package br.com.systemsgs.casadocodigo.exception;

public class SenhaInvalidaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SenhaInvalidaException() {
        super("Senha do Usuário Inválida!!!");
    }
}
