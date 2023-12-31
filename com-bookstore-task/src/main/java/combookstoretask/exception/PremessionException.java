package combookstoretask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class PremessionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PremessionException(String message) {
		super(message);
	}
}

