package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryUserGroups {

  private static ArrayList<UserGroup> userGroups = new ArrayList<>();

  public static void makeUserGroups() {

    // employees: Sep 1 2026 to Mar 1 2027, Monday to Friday, 9:00 to 17:00,
    // open, close and unlock shortly, everywhere but the parking
    ArrayList<DayOfWeek> monToFri = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
    Schedule employeesSchedule = new Schedule(LocalDate.of(2026, 9, 1), LocalDate.of(2027, 3, 1), monToFri, LocalTime.of(9, 0), LocalTime.of(17, 0));
    ArrayList<String> employeesActions = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.UNLOCK_SHORTLY));
    UserGroup employees = new UserGroup("employees", employeesSchedule, employeesActions);
    employees.addArea(DirectoryAreas.findAreaById("ground_floor"));
    employees.addArea(DirectoryAreas.findAreaById("floor1"));
    employees.addArea(DirectoryAreas.findAreaById("exterior"));
    employees.addArea(DirectoryAreas.findAreaById("stairs"));
    employees.addUser(new User("Ernest", "74984", employees));
    employees.addUser(new User("Eulalia", "43295", employees));
    userGroups.add(employees);

    ArrayList<DayOfWeek> monToSat = new ArrayList<DayOfWeek>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY));
    Schedule managersSchedule = new Schedule(LocalDate.of(2026, 9, 1), LocalDate.of(2027, 3, 1), monToSat, LocalTime.of(8, 0), LocalTime.of(20, 0));
    ArrayList<String> managersActions = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    UserGroup managers = new UserGroup("managers", managersSchedule, managersActions);
    managers.addArea(DirectoryAreas.findAreaById("building"));
    managers.addUser(new User("Manel", "95783", managers));
    managers.addUser(new User("Marta", "05827", managers));
    userGroups.add(managers);

    ArrayList<DayOfWeek> monToSun = new ArrayList<DayOfWeek>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY));
    Schedule adminsSchedule = new Schedule(LocalDate.of(2026, 1, 1), LocalDate.of(2100, 12, 31), monToSun, LocalTime.of(0, 0), LocalTime.of(23, 59));
    ArrayList<String> adminsActions = new ArrayList<>(Arrays.asList(Actions.OPEN, Actions.CLOSE, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY));
    UserGroup admins = new UserGroup("admins", adminsSchedule, adminsActions);
    admins.addArea(DirectoryAreas.findAreaById("building"));
    admins.addUser(new User("Ana", "11343", admins));
    userGroups.add(admins);

    ArrayList<DayOfWeek> blankDays = new ArrayList<DayOfWeek>();
    Schedule blankSchedule = new Schedule(LocalDate.of(2026, 1, 1), LocalDate.of(2100, 12, 31), blankDays, LocalTime.of(0, 0), LocalTime.of(23, 59));
    ArrayList<String> blankActions = new ArrayList<>();
    UserGroup blank = new UserGroup("blank", blankSchedule, blankActions);
    blank.addUser(new User("Bernat", "12345", blank));
    blank.addUser(new User("Blai", "77532", blank));
    userGroups.add(blank);

  }

  public static User findUserByCredential(String credential) {
    for (UserGroup group : userGroups) {
      User found = group.findUserByCredential(credential);
      if (found != null) {
        return found;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null;
  }

}
