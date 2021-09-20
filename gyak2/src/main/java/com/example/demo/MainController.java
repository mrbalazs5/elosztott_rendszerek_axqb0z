package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
	private final Calculator calculator;
	private final GitHubRepo gitHubRepo;

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}

	@RequestMapping(path = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
	public Double calculate(@Valid CalculatorRequestDTO dto) {
		return calculator.add(dto.getOperand1(), dto.getOperand2());
	}

	@RequestMapping(path = "/repo-search", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> repoSearch(@Valid RepoSearchDTO repoSearchDTO) throws RestException {
		return gitHubRepo.searchByText(repoSearchDTO.getQueryString());
	}
}