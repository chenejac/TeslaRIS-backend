package rs.teslaris.core.dto.person;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonSearchRequestDTO {

    @NotNull(message = "You have to provide a valid search input.")
    private List<String> tokens;
}
