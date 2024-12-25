package com.example.pollingapp.poll;

import lombok.*;

@EqualsAndHashCode(callSuper=true)
@Data
public class PollNotFoundExcepetion extends RuntimeException {
    private final String message;
}
