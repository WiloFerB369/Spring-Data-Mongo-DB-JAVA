package adaschool.userservice.controller;

import adaschool.userservice.controller.dto.UserDto;
import adaschool.userservice.document.User;
import adaschool.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController
{

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto)
    {
        Optional<User> optionalUser = userService.findByEmail(userDto.getEmail());
        if(!optionalUser.isPresent()){
            return userService.create(new User(userDto));
        }
        else{
            throw new ResponseStatusException(HttpStatus.FOUND,
                    "User with email: " + userDto.getEmail() + "Exists");
        }

    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "User with id: " + id + "not found");
        }

    }

    @GetMapping("/{id}")
    public List<User> findAll(){
        List<User> userList = userService.all();

        if(!userList.isEmpty()){
            return userService.all();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "There are no users");
        }
    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable String id, @RequestBody UserDto userDto){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            return userService.update(userDto, optionalUser.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "User with id: " + id + "not found");
        }

    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id){
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isPresent()){
            return userService.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "User with id: " + id + "not found");
        }
    }
}
