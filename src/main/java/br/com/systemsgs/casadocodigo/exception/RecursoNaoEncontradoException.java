package br.com.systemsgs.casadocodigo.exception;

public class RecursoNaoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException() {
        super("Recurso (ID) não Encontrado!!!");
    }

}
