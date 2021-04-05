package com.cg.online_plant_nursery.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OnlinePlantNurseryExceptionHandler {
	
	@ExceptionHandler(value = CustomreNotFoundException.class)
	public ResponseEntity<Object> exception(CustomreNotFoundException cnfex){
		return new ResponseEntity<Object>("Customer not found...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DuplicateOrderException.class)
	public ResponseEntity<Object> exception(DuplicateOrderException doidex){
		return new ResponseEntity<Object>("Duplication of order not allowed...",HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = OrderDetailsNotFoundException.class)
	public ResponseEntity<Object> exeption(OrderDetailsNotFoundException odnfex){
		return new ResponseEntity<Object>("Order not found...", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ListIsEmptyException.class)
	public ResponseEntity<Object> exception(ListIsEmptyException lempex){
		return new ResponseEntity<Object>("Table is empty...", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity<Object> exception(IDNotFoundException idnfex){
		return new ResponseEntity<Object>("Id not found...", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = DuplicateException.class)
	public ResponseEntity<Object> exception(DuplicateException dupex){
		return new ResponseEntity<Object>("Order has been repeated...",HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(value = OutOfStockException.class)
	public ResponseEntity<Object> exception(OutOfStockException outex){
		return new ResponseEntity<Object>("Product out of stock...",HttpStatus.NOT_FOUND);
	}
	
}
