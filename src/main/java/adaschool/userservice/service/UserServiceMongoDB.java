package adaschool.userservice.service;

import adaschool.userservice.controller.dto.UserDto;
import adaschool.userservice.document.User;
import adaschool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user)
    {
        return userRepository.save( user );
    }

    @Override
    public Optional<User> findById(String id)
    {
        return userRepository.findById(id);
    }

    @Override
    public User update(UserDto userDto, User user)
    {
        user.update(userDto);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(String id)
    {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByEmail(String email)
    {
        return Optional.of(userRepository.findByEmail(email));
    }

    @Override
    public List<User> findUsersWithNameOrLastNameLike(String queryText) {
        return null;
    }

    @Override
    public List<User> findUsersCreatedAfter(Date startDate) {
        return null;
    }
}
