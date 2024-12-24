package poll;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepository pollRepository;
    private final PollMapper pollMapper;
    public String CreatePoll(PollRequest poll) {
        var pollCreated = pollRepository.save(pollMapper.ToPoll(poll));
        return pollCreated.getId();
    }
}
