package baseNoStates;
// 1702612
// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

import baseNoStates.areas.DirectoryAreas;
import baseNoStates.groups.DirectoryUserGroups;

public class Main {
  public static void main(String[] args) {
    DirectoryAreas.makeAreas();
    DirectoryUserGroups.makeUserGroups();
    new WebServer();
  }
}