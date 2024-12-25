package com.example.pollingapp.poll;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping
    public ResponseEntity<String> createPoll(@RequestBody @Valid PollRequest poll){
        return ResponseEntity.ok(pollService.CreatePoll(poll));
    }

    @PutMapping
    public ResponseEntity<String> updatePoll(@RequestBody @Valid PollRequest poll){
        pollService.UpdatePoll(poll);
        return ResponseEntity.accepted().build();
    }
    @GetMapping
    public ResponseEntity<List<PollResponse>> findAllPolls(){
        return  ResponseEntity.ok(pollService.FindAll());
    }
    @GetMapping("/{poll-id}")
    public ResponseEntity<PollResponse> findPollById(@PathVariable("poll-id") String pollId){
        return  ResponseEntity.ok(pollService.findById(pollId));
    }
    @DeleteMapping("{poll-id}")
    public ResponseEntity<String> deletePoll(@PathVariable("poll-id") String pollId){
        return ResponseEntity.accepted().build();
    }
}
