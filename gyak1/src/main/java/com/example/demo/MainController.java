package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {
	private final Calculator calculator;

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}

	@RequestMapping(path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	public Double calculate(@Valid CalculatorRequestDTO dto) {
		return calculator.add(dto.getOperand1(), dto.getOperand2());
	}
}