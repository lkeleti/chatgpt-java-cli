package dev.lkeleti;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Service {


    private final Scanner scanner = new Scanner(System.in);


    public String getSearchString() {
        return scanner.nextLine();
    }

    public void getAiAnswer(String searchString) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        ChatGptRequest chatGptRequest = new ChatGptRequest(searchString);
        String input = mapper.writeValueAsString(chatGptRequest);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(HttpRequest.BodyPublishers.ofString(input))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        showAnswer(response);
    }

    private static void showAnswer(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (response.statusCode() == 200) {
            ChatGptResponse chatGptResponse = mapper.readValue(response.body(), ChatGptResponse.class);
            String answer = chatGptResponse.getChoices()[chatGptResponse.getChoices().length-1].getText();
            if (!answer.isBlank()) {
                System.out.println(answer.replace("\n","").trim());
            }
        }
        else {
            System.out.println(response.statusCode());
            System.out.println(response.body());
        }
    }
}
