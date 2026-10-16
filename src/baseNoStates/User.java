package baseNoStates;


import baseNoStates.areas.Space;
import baseNoStates.groups.UserGroup;

import java.time.LocalDateTime;

// A person recognized by a credential. It holds no permissions itself:
// it just delegates the can... questions to the group it belongs to.
public class User {
  private final String name;
  private final String credential;
  private UserGroup userGroup = null;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public void setUserGroup(UserGroup group) {
    this.userGroup = group;
  }

  public String getCredential() {
    return credential;
  }

  public boolean canBeInSpace(Space space) {
    return userGroup.canBeInSpace(space);
  }
  public boolean canSendRequests(LocalDateTime now) {
    return userGroup.canSendRequests(now);
  }
  public boolean canDoAction(String action) {
    return userGroup.canDoAction(action);
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
