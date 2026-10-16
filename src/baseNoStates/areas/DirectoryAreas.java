package baseNoStates.areas;

import baseNoStates.Door;

import java.util.ArrayList;
import java.util.Arrays;

// Holds the tree of areas of the building (rootArea) and the list of its
// doors. Replaces the former DirectoryDoors: the doors are created here,
// each one registering itself in the space it gives access to.
public class DirectoryAreas {
  private static Area rootArea;
  private static ArrayList<Door> allDoors = new ArrayList<>();

  public static void makeAreas() {
    Partition building = new Partition("building");

    Partition basement = new Partition("basement");
    Space parking = new Space("parking");

    Partition groundFloor = new Partition("ground_floor");
    Space hall = new Space("hall");
    Space room1 = new Space("room1");
    Space room2 = new Space("room2");

    Partition floor1 = new Partition("floor1");
    Space room3 = new Space("room3");
    Space corridor = new Space("corridor");
    Space it = new Space("IT");

    Space stairs = new Space("stairs");
    Space exterior = new Space("exterior");

    building.addChildArea(basement);
    building.addChildArea(groundFloor);
    building.addChildArea(floor1);
    building.addChildArea(stairs);
    building.addChildArea(exterior);

    basement.addChildArea(parking);

    groundFloor.addChildArea(hall);
    groundFloor.addChildArea(room1);
    groundFloor.addChildArea(room2);

    floor1.addChildArea(room3);
    floor1.addChildArea(corridor);
    floor1.addChildArea(it);

    Door d1 = new Door("D1", exterior, parking); // exterior, parking
    Door d2 = new Door("D2", stairs, parking); // stairs, parking

    // ground floor
    Door d3 = new Door("D3", exterior, hall); // exterior, hall
    Door d4 = new Door("D4", stairs, hall); // stairs, hall
    Door d5 = new Door("D5", hall, room1); // hall, room1
    Door d6 = new Door("D6", hall, room2); // hall, room2

    // first floor
    Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
    Door d8 = new Door("D8", corridor, room3); // corridor, room3
    Door d9 = new Door("D9", corridor, it); // corridor, IT

    rootArea = building;
    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  public static Area findAreaById(String id) {
    return rootArea.findAreaById(id);
  }

  public static Door findDoorById(String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    System.out.println("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    System.out.println(allDoors);
    return allDoors;
  }
}
