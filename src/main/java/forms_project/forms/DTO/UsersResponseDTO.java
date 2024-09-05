package forms_project.forms.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UsersResponseDTO {
    private String name;
    private String email;
    private String phone;
    private String crpath;
}
