package com.kodlamaio.bootcampProject;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.results.ErrorDataResult;
@RestControllerAdvice
@SpringBootApplication
public class BootcampProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampProjectApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException methodArgumenValidException){
	Map<String, String> validationErrors=new HashMap<String, String>();
	for(FieldError fieldError: methodArgumenValidException.getBindingResult().getFieldErrors()) {
		validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
	}
	ErrorDataResult<Object> errorDataResult=new ErrorDataResult<Object>(validationErrors,"VALIDATION.EXCEPTION");
	return errorDataResult;
	
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object>handleBusinessExceptions(BusinessException businessException){
		ErrorDataResult<Object>errorDataResult=new ErrorDataResult<Object>(businessException.getMessage(),"BUSİNESS EXCEPTİON");
		return errorDataResult;
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<>(exception.getMessage(),
				"DATA INTEGRITY EXCEPTION");
		return errorDataResult;
	}
}


//@ExceptionHandler->Bütün isteklerin controllerdan önce tanımlandığı error metoduna uğramasını sağlıyor



