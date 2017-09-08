package test.tasks.userservice.service;

import test.tasks.userservice.domain.User;
import test.tasks.userservice.exceptions.UserAlreadyExistsException;

public interface UserRepository {
  User createUser(User user) throws UserAlreadyExistsException;
}
