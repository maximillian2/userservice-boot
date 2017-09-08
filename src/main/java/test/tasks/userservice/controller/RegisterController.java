package test.tasks.userservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.tasks.userservice.domain.RequestError;
import test.tasks.userservice.domain.User;
import test.tasks.userservice.domain.UserDTO;
import test.tasks.userservice.exceptions.UserAlreadyExistsException;
import test.tasks.userservice.service.UserRepositoryImpl;

@RestController
@RequestMapping("/userservice")
public class RegisterController {

  private final UserRepositoryImpl userService;

  private final ModelMapper modelMapper;

  @Autowired
  public RegisterController(UserRepositoryImpl userService, ModelMapper modelMapper) {
    this.userService = userService;
    this.modelMapper = modelMapper;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<Object> registerUser(@RequestBody final User user) {
    UserDTO registeredUser;
    try {
      registeredUser = modelMapper.map(userService.createUser(user), UserDTO.class);

    } catch (UserAlreadyExistsException e) {
      return new ResponseEntity<>(new RequestError(409), HttpStatus.CONFLICT);
    }
    return new ResponseEntity<>(registeredUser, HttpStatus.ACCEPTED);
  }
}
