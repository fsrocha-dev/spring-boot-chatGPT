	public ChatGPTRequest createStudyRequest(String topic) {
		String question = "Quais pontos chave que preciso estudar sobre o seguinte assunto: " + topic;
		return new ChatGPTRequest("text-davinci-003", question, 0.3, 1800, 1.0, 0.0, 0.0);
	}
}
