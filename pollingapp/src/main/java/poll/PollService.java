package poll;

import io.micrometer.common.util.StringUtils;
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

    public void UpdatePoll(@Valid PollRequest poll) {
        var pollSelected = pollRepository.findById(poll.id()).orElseThrow(() -> new PollNotFoundExcepetion(
                String.format("Poll with id %s not found", poll.id())
        ));
        MergePoll(pollSelected , poll);
    }

    private void MergePoll(Poll pollSelected, @Valid PollRequest poll) {
        if(StringUtils.isNotBlank(poll.question())){
            pollSelected.setQuestion(poll.question());
        }
        
        if(StringUtils.isNotBlank(poll.question())){
            pollSelected.setQuestion(poll.question());
        }
    }
}
