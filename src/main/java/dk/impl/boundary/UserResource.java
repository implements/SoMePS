package dk.impl.boundary;

import dk.impl.model.User;
import dk.impl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user/{id}")
    public String findUser(@PathVariable Long id) {
        return userRepository.findById(id).toString();
    }

    @PostMapping("/user")
    public User saveUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }
}