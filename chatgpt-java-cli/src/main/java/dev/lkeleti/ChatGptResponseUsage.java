package dev.lkeleti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatGptResponseUsage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
}
