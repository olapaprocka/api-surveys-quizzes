package pl.paprocka.apisurveysquizzes.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class EditUserForm {
    @NotNull
    private Long id;
    @NotNull(message = "Pole imię musi być wypełnione.")
    private String firstName;
    @NotBlank(message = "Nazwisko nie może być puste.")
    private String lastName;
    @NotNull
    @Email(message = "Nieprawidłowy email")
    private String email;


    private Collection<String> roles;

    public static EditUserForm create(User user) {
        EditUserForm form = new EditUserForm();
        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setRoles(user.getRoles().stream()
                .map(Role :: getRoleName)
                .collect(Collectors.toSet()));
        return form;
    }
}
