package br.com.chatgpt.springbootchatgpt.services;

import org.springframework.stereotype.Service;

import br.com.chatgpt.springbootchatgpt.dtos.ChatGPTRequest;
import br.com.chatgpt.springbootchatgpt.dtos.ChatGPTResponse;
import reactor.core.publisher.Mono;

@Service
public class StudyNotesServiceChatGPT {
	public Mono<ChatGPTResponse> createStudyNotes(String topic) {
		ChatGPTRequest request = createStudyRequest(topic);
	}

	public ChatGPTRequest createStudyRequest(String topic) {
		String question = "Quais pontos chave que preciso estudar sobre o seguinte assunto: " + topic;
		return new ChatGPTRequest("text-davinci-003", question, 0.3, 1800, 1.0, 0.0, 0.0);
	}
}
