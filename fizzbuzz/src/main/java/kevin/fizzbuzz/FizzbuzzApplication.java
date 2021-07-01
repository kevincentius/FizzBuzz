package kevin.fizzbuzz;

import java.io.IOException;

import javax.validation.ConstraintViolationException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

@SpringBootApplication
public class FizzbuzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(FizzbuzzApplication.class, args);
	}
	
	@ControllerAdvice
	public class CustomErrorHandler {
	    @ExceptionHandler(ConstraintViolationException.class)
	    public void handleConstraintViolationException(ConstraintViolationException exception,
	            ServletWebRequest webRequest) throws IOException {
	        webRequest.getResponse().sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
	    }
	}
}
