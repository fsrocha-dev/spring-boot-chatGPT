package br.com.chatgpt.springbootchatgpt.dtos;

import java.util.List;

public record ChatGPTResponse(List<Choice> choices) {

}
