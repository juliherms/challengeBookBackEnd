package br.com.hivecloud.msbookregister.controller.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hivecloud.msbookregister.exception.ExceptionDetails;
import br.com.hivecloud.msbookregister.exception.NotFoundException;
import br.com.hivecloud.msbookregister.exception.NotFoundExceptionDetails;
import br.com.hivecloud.msbookregister.exception.ValidationExceptionDetails;


/**
 * Class responsible to intercept all Controllers
 * 
 * @author jlv
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Method responsible to configure ParkingNotFound
	 * @param parkingNotFoundException
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<NotFoundExceptionDetails> handlerNotFoundException(
			NotFoundException notFoundException) {

		return new ResponseEntity<>(
				NotFoundExceptionDetails.builder()
					.timestamp(LocalDateTime.now())
					.status(HttpStatus.NOT_FOUND.value())
					.title("No Data Found")
					.details(notFoundException.getMessage())
					.developerMessage("Please check register in the database.")
					.build(),
				HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Method responsible to resolve bean validations in the object DTO
	 * @param methodArgumentNotValidException
	 * @return
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		
		//capture errors
		List<FieldError> fieldErros =  ex.getBindingResult().getFieldErrors();
		String fields = fieldErros.stream().map(FieldError::getField).collect(Collectors.joining(", "));
		String fieldsMessage = fieldErros.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
		
		return new ResponseEntity<>(
				ValidationExceptionDetails.builder()
					.timestamp(LocalDateTime.now())
					.status(HttpStatus.BAD_REQUEST.value())
					.title("Bad Request Exception. Invalid Fields")
					.details("Check the field(s) error(s)")
					.developerMessage(ex.getClass().getName())
					.fields(fields)
					.fieldsMessage(fieldsMessage)
					.build(),
				HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Method responsible to resolve general exception in the API
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,HttpStatus status, WebRequest request){
		
		ExceptionDetails exceptionDetails = ExceptionDetails.builder()
			.timestamp(LocalDateTime.now())
			.status(status.value())
			.title(ex.getCause().getMessage())
			.details(ex.getMessage())
			.developerMessage(ex.getClass().getName())
			.build();
			
		
		return new ResponseEntity<>(exceptionDetails,headers,status);
	}
	

}
