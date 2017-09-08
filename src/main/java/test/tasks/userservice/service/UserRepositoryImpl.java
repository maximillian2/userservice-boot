package test.tasks.userservice.service;

import org.springframework.stereotype.Service;
import test.tasks.userservice.domain.User;
import test.tasks.userservice.exceptions.UserAlreadyExistsException;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class UserRepositoryImpl implements UserRepository {

  private final static Random random = new Random();
  private final static Set<User> users = new HashSet<User>() {
    {
      add(new User(1, "first name", "lastName", "userName", "pass", "hashed"));
      add(new User(2, "first name1", "lastName1", "userName1", "pass1", "hashed1"));
      add(new User(3, "first name2", "lastName2", "userName2", "pass2", "hashed2"));
      add(new User(4, "first name3", "lastName3", "userName3", "pass3", "hashed3"));
    }
  };

  public User createUser(User user) throws UserAlreadyExistsException {
    if (!users.contains(user)) {
      user.setId(random.nextInt(5) + 1);
      user.setHashedPassword(String.valueOf(user.getPassword().hashCode()));
      users.add(user);

      return user;
    }

    throw new UserAlreadyExistsException();
  }
}
