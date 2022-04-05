package ua.azbest.ProxyBandTask.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.azbest.ProxyBandTask.controller.UserController;
import ua.azbest.ProxyBandTask.model.User;
import ua.azbest.ProxyBandTask.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //TODO: fix null returning in saveUser
    public User saveUser(User user) {
        if (userRepository.findUserByEmail(user.getEmail()).isEmpty())
            return userRepository.save(user);
        logger.info("user with email: " + user.getEmail() + " already stored");
        return null;
    }

    public void deleteUserByEmail(String email) {
        final Optional<User> userByEmail = userRepository.findUserByEmail(email);
        userByEmail
                .ifPresentOrElse(
                        userRepository::delete,
                        () -> System.out.println("No such email: " + email));
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).get();
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public User updateUser(String id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresentOrElse(
                (renewedUser) -> {
                    if (user.getName() != null)
                        renewedUser.setName(user.getName());
                    if (user.getEmail() != null
                            && !renewedUser.getEmail().equals(user.getEmail())) {
                        renewedUser.setEmail(user.getEmail());
                    }
                    userRepository.save(renewedUser);
                },
                () -> {
                    logger.info("no user with id: " + id);
                }
        );
        return user;
    }

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
}
