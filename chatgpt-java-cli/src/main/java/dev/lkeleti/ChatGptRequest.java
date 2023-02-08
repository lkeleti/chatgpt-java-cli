package dev.lkeleti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ChatGptRequest {
    private String model;
    private String prompt;
    private int temperature;
    private int max_tokens;

    public ChatGptRequest(String prompt) {
        this.model = "text-davinci-001";
        this.prompt = prompt;
        this.temperature = 1;
        this.max_tokens = 100;
    }
}
