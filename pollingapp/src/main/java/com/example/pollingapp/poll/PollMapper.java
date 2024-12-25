package com.example.pollingapp.poll;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PollMapper {

    public Poll ToPoll(PollRequest poll) {
        if(poll == null){
            return null;
        }
        return Poll.builder()
                .id(poll.id())
                .question(poll.question())
                .options(poll.options())
                .votes(new ArrayList<>())
                .build();
    }

    public PollResponse fromPoll(Poll poll) {
        if(poll == null){
            return null;
        }
        return new PollResponse(
                poll.getId(),
                poll.getQuestion(),
                poll.getOptions(),
                poll.getVotes()
        );
    }
}
