package poll;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document("polling")
public class Poll {
    @Id
    private String id;
    private String question;
    private List<String> options;
    private List<Integer> votes;
}
