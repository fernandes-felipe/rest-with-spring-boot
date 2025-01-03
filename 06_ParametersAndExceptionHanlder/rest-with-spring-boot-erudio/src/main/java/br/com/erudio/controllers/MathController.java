package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			
		) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number");
		}
		return math.sum(NumberConverter.convertedToDouble(numberOne) , NumberConverter.convertedToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/subtraction/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number");
		}
		return math.subtraction(NumberConverter.convertedToDouble(numberOne) , NumberConverter.convertedToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/multplication/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double multplication(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number");
		}
		return math.multplication(NumberConverter.convertedToDouble(numberOne) , NumberConverter.convertedToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/division/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double division(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number");
		}else if (NumberConverter.convertedToDouble(numberOne) < NumberConverter.convertedToDouble(numberTwo)) {
			throw new UnsupportedMathOperationException("the first number must be greater than the second number");
		}
		return math.division(NumberConverter.convertedToDouble(numberOne) , NumberConverter.convertedToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/mean/{numberOne}/{numberTwo}", 
			method=RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo")String numberTwo
			) throws Exception{
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a number");
		}
		return math.mean(NumberConverter.convertedToDouble(numberOne) , NumberConverter.convertedToDouble(numberTwo));
	}
	
	@RequestMapping(value= "/square-root/{number}", 
			method=RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "number")String number
			) throws Exception{
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a number");
		}
		return math.squareRoot(NumberConverter.convertedToDouble(number));
	}
		
}
