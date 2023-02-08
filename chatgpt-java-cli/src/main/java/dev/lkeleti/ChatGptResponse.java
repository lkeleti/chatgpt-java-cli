package dev.lkeleti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatGptResponse {

    private String id;
    private String object;
    private int created;
    private String model;
    private ChatGptResponseChoice[] choices;
    private ChatGptResponseUsage usage;
}
