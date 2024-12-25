package com.example.pollingapp.poll;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if(poll.options() != null && poll.options().size() > 0){
            pollSelected.setOptions(poll.options());
        }
    }

    public List<PollResponse> FindAll() {
        return pollRepository.findAll().stream().map(pollMapper::fromPoll).collect(Collectors.toList());
    }

    public PollResponse findById(String pollId) {
        return pollRepository.findById(pollId).map(pollMapper::fromPoll).orElseThrow(() -> new PollNotFoundExcepetion(
                String.format("Poll with id %s not found", pollId)
        ));
    }

    public void deletePoll(String pollId) {
        pollRepository.deleteById(pollId);
    }
}
