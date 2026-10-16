package baseNoStates;

import baseNoStates.areas.DirectoryAreas;

import java.util.ArrayList;

public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {
    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    users.add(new User("Bernat", "12345"));
    users.add(new User("Blai", "77532"));

    // employees :
    // Sep. 1 this year to Mar. 1 next year
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    users.add(new User("Ernest", "74984"));
    findUserByCredential("74984").addArea(DirectoryAreas.findAreaById("ground_floor"));
    findUserByCredential("74984").addArea(DirectoryAreas.findAreaById("floor1"));
    findUserByCredential("74984").addArea(DirectoryAreas.findAreaById("exterior"));
    findUserByCredential("74984").addArea(DirectoryAreas.findAreaById("stairs"));

    users.add(new User("Eulalia", "43295"));
    findUserByCredential("43295").addArea(DirectoryAreas.findAreaById("ground_floor"));
    findUserByCredential("43295").addArea(DirectoryAreas.findAreaById("floor1"));
    findUserByCredential("43295").addArea(DirectoryAreas.findAreaById("exterior"));
    findUserByCredential("43295").addArea(DirectoryAreas.findAreaById("stairs"));

    // managers :
    // Sep. 1 this year to Mar. 1 next year
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    users.add(new User("Manel", "95783"));
    findUserByCredential("95783").addArea(DirectoryAreas.findAreaById("building"));

    users.add(new User("Marta", "05827"));
    findUserByCredential("05827").addArea(DirectoryAreas.findAreaById("building"));

    // admin :
    // always=Jan. 1 this year to 2100
    // all days of the week
    // all actions
    // all spaces
    users.add(new User("Ana", "11343"));
    findUserByCredential("11343").addArea(DirectoryAreas.findAreaById("building"));
  }

  public static User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
