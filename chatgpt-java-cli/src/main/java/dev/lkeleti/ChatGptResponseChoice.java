package dev.lkeleti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatGptResponseChoice {
    private String text;
    private int index;
    private Object logprobs;
    private String finish_reason;
}
