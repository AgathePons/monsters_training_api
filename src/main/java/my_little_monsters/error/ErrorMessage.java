package my_little_monsters.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private int status;
    private String error;
}
