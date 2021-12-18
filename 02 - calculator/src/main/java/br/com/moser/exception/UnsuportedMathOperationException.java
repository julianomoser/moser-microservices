package br.com.moser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Juliano Moser
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UnsuportedMathOperationException(String exception) {
		super(exception);
	}

}
