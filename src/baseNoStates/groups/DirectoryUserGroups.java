package baseNoStates.groups;

import baseNoStates.Actions;
import baseNoStates.User;
import baseNoStates.areas.DirectoryAreas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups {
  private static final ArrayList<UserGroup> userGroups = new ArrayList<>();

  public static void makeUserGroups() {
    ArrayList<DayOfWeek> monToFri = new ArrayList<>(Arrays.asList(
        DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
    Schedule employeeSchedule = new Schedule(
        LocalDate.of(2026, 9, 1), LocalDate.of(2027, 3, 1),
        monToFri, LocalTime.of(9, 0), LocalTime.of(17, 0));
    UserGroup employees = new UserGroup("employees", employeeSchedule);
    employees.addAction(Actions.OPEN);
    employees.addAction(Actions.CLOSE);
    employees.addAction(Actions.UNLOCK_SHORTLY);
    employees.addArea(DirectoryAreas.findAreaById("ground_floor"));
    employees.addArea(DirectoryAreas.findAreaById("floor1"));
    employees.addArea(DirectoryAreas.findAreaById("exterior"));
    employees.addArea(DirectoryAreas.findAreaById("stairs"));
    employees.addUser(new User("Ernest", "74984"));
    employees.addUser(new User("Eulalia", "43295"));
    userGroups.add(employees);

    ArrayList<DayOfWeek> everyday = new ArrayList<>(Arrays.asList(DayOfWeek.values()));
    Schedule adminSchedule = new Schedule(
        LocalDate.of(2026, 1, 1), LocalDate.of(2100, 1, 1),
        everyday, LocalTime.of(0, 0), LocalTime.of(23, 59));
    UserGroup admins = new UserGroup("admins", adminSchedule);
    admins.addAction(Actions.OPEN);
    admins.addAction(Actions.CLOSE);
    admins.addAction(Actions.LOCK);
    admins.addAction(Actions.UNLOCK);
    admins.addAction(Actions.UNLOCK_SHORTLY);
    admins.addArea(DirectoryAreas.findAreaById("building"));
    admins.addUser(new User("Ana", "11343"));
    userGroups.add(admins);

    ArrayList<DayOfWeek> monToSat = new ArrayList<>(Arrays.asList(
        DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    Schedule managerSchedule = new Schedule(
        LocalDate.of(2026, 9, 1), LocalDate.of(2027, 3, 1),
        monToSat, LocalTime.of(8, 0), LocalTime.of(20, 0));
    UserGroup managers = new UserGroup("managers", managerSchedule);
    managers.addAction(Actions.OPEN);
    managers.addAction(Actions.CLOSE);
    managers.addAction(Actions.LOCK);
    managers.addAction(Actions.UNLOCK);
    managers.addAction(Actions.UNLOCK_SHORTLY);
    managers.addArea(DirectoryAreas.findAreaById("building"));
    managers.addUser(new User("Manel", "95783"));
    managers.addUser(new User("Marta", "05827"));
    userGroups.add(managers);

    UserGroup blanks = new UserGroup("blanks", adminSchedule);
    blanks.addUser(new User("Bernat", "12345"));
    blanks.addUser(new User("Blai", "77532"));
    userGroups.add(blanks);
  }

  public static User findUserByCredential(String credential) {
    for (UserGroup group : userGroups) {
      User found = group.findUser(credential);
      if (found != null) {
        return found;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null;
  }
}
