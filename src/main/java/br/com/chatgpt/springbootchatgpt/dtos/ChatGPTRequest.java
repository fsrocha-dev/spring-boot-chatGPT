package br.com.chatgpt.springbootchatgpt.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ChatGPTRequest(
		String model, String prompt,
		Double temperature, Integer maxTokens,
		Double topP, Double frequencyPenalty, Double PresencePenalty) {

}
