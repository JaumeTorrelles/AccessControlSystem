package baseNoStates;

import java.time.LocalDateTime;

public class User {
  private final String name;
  private final String credential;
  private final UserGroup userGroup;

  public User(String name, String credential,UserGroup userGroup) {
    this.name = name;
    this.credential = credential;
    this.userGroup = userGroup;
  }

  public String getName() {
    return name;
  }

  public boolean canBeInSpace(Space space){
    return userGroup.canBeInSpace(space);
  }

  public boolean canSendRequests(LocalDateTime now){
    return userGroup.canSendRequests(now);
  }

  public boolean canDoAction(String action){
    return userGroup.canDoAction(action);
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
