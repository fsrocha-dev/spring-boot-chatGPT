package br.com.chatgpt.springbootchatgpt.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.chatgpt.springbootchatgpt.dtos.ChatGPTRequest;
import br.com.chatgpt.springbootchatgpt.dtos.ChatGPTResponse;
import reactor.core.publisher.Mono;

@Service
public class StudyNotesServiceChatGPT {

	private WebClient webClient;

	public StudyNotesServiceChatGPT(
			WebClient.Builder builder, @Value("${openai.api.key}") String apiKey) {
		this.webClient = builder
				.baseUrl("https://api.openai.com/v1/completions")
				.defaultHeader("Content-Type", "application/json")
				.defaultHeader("Authorization", String.format("Bearer %s", apiKey))
				.build();
	}

	public Mono<ChatGPTResponse> createStudyNotes(String topic) {
		ChatGPTRequest request = createStudyRequest(topic);
		return webClient.post()
				.bodyValue(request)
				.retrieve()
				.bodyToMono(ChatGPTResponse.class);
	}

	public ChatGPTRequest createStudyRequest(String topic) {
		String question = "Quais pontos chave que preciso estudar sobre o seguinte assunto: " + topic;
		return new ChatGPTRequest("text-davinci-003", question, 0.3, 1800, 1.0, 0.0, 0.0);
	}
}
