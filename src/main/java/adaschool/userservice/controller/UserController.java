package adaschool.userservice.controller;

import adaschool.userservice.controller.dto.UserDto;
import adaschool.userservice.document.User;
import adaschool.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto){
        return userService.create(new User(userDto));
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent())
            return optionalUser.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "User with id: " + id + "not found");

    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable String id, User user){
        return userService.updateNameAndLastName( id, user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id){

        return userService.deleteById(id);
    }
}
