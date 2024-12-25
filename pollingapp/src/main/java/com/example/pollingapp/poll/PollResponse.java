package com.example.pollingapp.poll;

import java.util.List;

public record PollResponse(
        String id,
        String question,
        List<String>options,
        List<Integer> votes
) {

}
