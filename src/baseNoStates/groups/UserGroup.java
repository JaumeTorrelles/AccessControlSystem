package baseNoStates.groups;

import baseNoStates.User;
import baseNoStates.areas.Area;
import baseNoStates.areas.Space;

import java.time.LocalDateTime;
import java.util.ArrayList;

// A user group of the RBAC model: it holds the permissions with the 4 Ws —
// who (its users), what (the actions), where (the areas) and when (the
// schedule). The group is the one knowing the permissions, so users just
// delegate their can... questions here.
public class UserGroup {
  private final String name;
  private final ArrayList<User> users = new ArrayList<>();
  private final ArrayList<String> actions = new ArrayList<>();
  private final ArrayList<Area> areas = new ArrayList<>();
  private final Schedule schedule;

  public UserGroup(String name, Schedule schedule) {
    this.name = name;
    this.schedule = schedule;
  }

  public void addAction(String action) {
    actions.add(action);
  }

  public void addArea(Area area) {
    areas.add(area);
  }

  public void addUser(User user) {
    users.add(user);
    user.setUserGroup(this);
  }

  public User findUser(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    return null;
  }

  // what: if the action is among the ones granted to the group
  public boolean canDoAction(String action) {
    return actions.contains(action);
  }

  // when: if the group's schedule allows sending a request at date-time now
  public boolean canSendRequests(LocalDateTime now) {
    return schedule.isDateTimeValid(now);
  }

  // where: if the space is among the ones of the group's areas
  public boolean canBeInSpace(Space space) {
    for (Area area : areas) {
      for(Space areaSpace : area.getSpaces()){
        if(areaSpace.equals(space)){
          return true;
        }
      }
    }
    return false;
  }
}