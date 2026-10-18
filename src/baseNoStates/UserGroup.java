package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserGroup {

  private String name;
  private Schedule schedule;
  private ArrayList<Area> areas;
  private ArrayList<String> actions;
  private ArrayList<User> users;

  public UserGroup(String name, Schedule schedule, ArrayList<String> actions){
    this.name = name;
    this.schedule = schedule;
    this.actions = actions;
    this.areas = new ArrayList<Area>();
    this.users = new ArrayList<User>();
  }

  public String getName(){
    return name;
  }

  public void addArea(Area area){
    areas.add(area);
  }

  public void addUser(User user){
    users.add(user);
  }

  private ArrayList<Space> getSpaces(){
    ArrayList<Space> spaces = new ArrayList<Space>();
    for(Area area : areas){
      spaces.addAll(area.getSpaces());
    }
    return spaces;
  }

  public boolean canBeInSpace(Space space){
    return getSpaces().contains(space);
  }

  public boolean canSendRequests(LocalDateTime now){
    return schedule.isInSchedule(now);
  }

  public boolean canDoAction(String action){
    return actions.contains(action);
  }

  public User findUserByCredential(String credential){
    for(User user: users){
      if(user.getCredential().equals(credential)){
        return user;
      }
    }
    return null;

  }

}
