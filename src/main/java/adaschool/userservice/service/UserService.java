package adaschool.userservice.service;

import adaschool.userservice.document.User;

import java.util.Optional;

public interface UserService
{
    User create(User user);

    User findByEmail(String email);

    Optional<User> findById(String id);

    User updateNameAndLastName(String id, User user);

    boolean deleteById(String id);

}
