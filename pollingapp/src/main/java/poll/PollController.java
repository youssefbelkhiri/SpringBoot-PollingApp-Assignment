package poll;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping
    public ResponseEntity<String> CreatePoll(@RequestBody @Valid PollRequest poll){
        return ResponseEntity.ok(pollService.CreatePoll(poll));
    }

    @PutMapping
    public ResponseEntity<String> UpdatePoll(@RequestBody @Valid PollRequest poll){
        pollService.UpdatePoll(poll);
        return ResponseEntity.accepted().build();
    }
}
