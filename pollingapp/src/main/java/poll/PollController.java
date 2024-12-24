package poll;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping
    public ResponseEntity<String> CreatePoll(@RequestBody @Valid PollRequest poll){
        return ResponseEntity.ok(pollService.CreatePoll(poll));
    }
}
