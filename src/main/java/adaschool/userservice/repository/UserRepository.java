package adaschool.userservice.repository;

import adaschool.userservice.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository< User, String> {

    User findByEmail(String email);

}
