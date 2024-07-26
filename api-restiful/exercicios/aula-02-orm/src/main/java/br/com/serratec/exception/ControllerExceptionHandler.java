package br.com.serratec.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  //torna a classe de erros
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler { //nome padrao para classe de erros
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<String> erros = new ArrayList<>();
		for(FieldError f : ex.getBindingResult() .getFieldErrors() ) {
			erros.add(f.getField()+":"+ f.getDefaultMessage() );
		}
		
		
		ErroResposta er = new ErroResposta (status.value(),"Existm campos invalidos", LocalDate.now(), erros);//instancia a classe erroResposta
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
		ErroResposta er = new ErroResposta(status.value(), "Campos inválidos foram inseridos, favor verificar",
				LocalDate.now(), null);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}
	
}
