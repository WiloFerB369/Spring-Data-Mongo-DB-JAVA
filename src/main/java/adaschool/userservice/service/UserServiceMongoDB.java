package adaschool.userservice.service;

import adaschool.userservice.document.User;
import adaschool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save( user );
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById( id );
    }

    @Override
    public User updateNameAndLastName(String id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
        {
            User userTemp = optionalUser.get();

            userTemp.setName(user.getName());
            userTemp.setLastName(user.getLastName());
            userTemp.setEmail(user.getEmail());

            return userRepository.save(userTemp);
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        if(userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
