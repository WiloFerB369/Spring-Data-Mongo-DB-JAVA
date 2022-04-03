package adaschool.userservice.service;

import adaschool.userservice.controller.dto.UserDto;
import adaschool.userservice.document.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService
{
    User create(User user);

    List<User> all();

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);

    User update(UserDto userDto, User user);

    boolean deleteById(String id);

    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(Date startDate);



}
