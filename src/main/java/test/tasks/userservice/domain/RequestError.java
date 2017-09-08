package test.tasks.userservice.domain;

public class RequestError {
  private String returnCodeDescription;
  private String description;

  public RequestError(Integer errorCode) {
    this.returnCodeDescription = "USER_ALREADY_EXISTS";
    this.description = "A user with the given username already exists";
  }

  public String getReturnCodeDescription() {
    return returnCodeDescription;
  }

  public void setReturnCodeDescription(String returnCodeDescription) {
    this.returnCodeDescription = returnCodeDescription;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
