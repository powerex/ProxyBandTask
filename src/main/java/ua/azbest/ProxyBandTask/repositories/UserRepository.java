package ua.azbest.ProxyBandTask.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.azbest.ProxyBandTask.model.User;

import java.util.Optional;

public interface UserRepository
        extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
}
