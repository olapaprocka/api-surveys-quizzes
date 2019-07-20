package pl.paprocka.apisurveysquizzes.api;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.paprocka.apisurveysquizzes.user.EditUserForm;
import pl.paprocka.apisurveysquizzes.user.User;
import pl.paprocka.apisurveysquizzes.user.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//add automaticaly @ResponseBody and @RequestBody //Jeśli chcemy utworzyć restowe api to właśnie zamiast @Controller dać @RestController
@RequestMapping("/api")
@AllArgsConstructor
@Log
public class UserRestController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody //surowy json
    //mapujemy uzytkownika i zwracamy
    public Collection<EditUserForm> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(ue -> EditUserForm.create(ue))
                .collect(Collectors.toList());
    }

    @GetMapping("/user")// /admin/user?id=2
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EditUserForm getUserById(@RequestParam Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new EntityNotFoundException();
        }
        // log.info("Get cos tam", id);
        return EditUserForm.create(optionalUser.get());
    }

    @GetMapping("/users/{id}")// /api/users/2
    public EditUserForm getUserByIdv2(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new EntityNotFoundException();
        }
        return EditUserForm.create(optionalUser.get());
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {

    }
}

