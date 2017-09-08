package test.tasks.userservice.domain;

import java.io.Serializable;

public class User implements Serializable {
  private Integer id;
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String hashedPassword;
  public User() {
  }

  public User(Integer id, String firstName, String lastName, String userName, String password, String hashedPassword) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.hashedPassword = hashedPassword;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return userName != null ? userName.equals(user.userName) : user.userName == null;
  }

  @Override
  public int hashCode() {
    return userName != null ? userName.hashCode() : 0;
  }
}
