package com.example.pollingapp.poll;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


public record PollRequest(
        String id,
        @NotEmpty(message = "question cannot be empty")
        String question,
        @NotEmpty(message = "Options list cannot be empty.")
        @Size(min = 2, message = "There must be at least 2 options.")
        List<String> options
) {

}
