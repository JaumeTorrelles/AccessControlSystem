package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryAreas {

  private static Area rootArea;
  private static ArrayList<Door> allDoors;

  public static void makeAreas() {
    // Partitions first, from the root down: a child needs its parent to exist
    // so that it can add itself to the parent's children
    Partition building = new Partition("building", null);
    Partition basement = new Partition("basement", building);
    Partition groundFloor = new Partition("ground_floor", building);
    Partition floor1 = new Partition("floor1", building);

    // Spaces, the leaves of the tree. Each one adds itself to its parent partition
    Space parking = new Space("parking", basement);
    Space hall = new Space("hall", groundFloor);
    Space room1 = new Space("room1", groundFloor);
    Space room2 = new Space("room2", groundFloor);
    Space room3 = new Space("room3", floor1);
    Space corridor = new Space("corridor", floor1);
    Space IT = new Space("IT", floor1);
    Space stairs = new Space("stairs", building);
    Space exterior = new Space("exterior", building);

    // Doors last, because they need both spaces to exist.
    // new Door(id, from, to): the reader is in "from", opening it you enter "to"
    Door d1 = new Door("D1", exterior, parking);
    Door d2 = new Door("D2", stairs, parking);
    Door d3 = new Door("D3", exterior, hall);
    Door d4 = new Door("D4", stairs, hall);
    Door d5 = new Door("D5", hall, room1);
    Door d6 = new Door("D6", hall, room2);
    Door d7 = new Door("D7", stairs, corridor);
    Door d8 = new Door("D8", corridor, room3);
    Door d9 = new Door("D9", corridor, IT);

    rootArea = building;
    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  public static Area findAreaById(String id){
    return rootArea.findAreaById(id); // an Area or null if not found
  }

  public static Door findDoorById(String id){
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    System.out.println("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  public static ArrayList<Door> getAllDoors(){
    System.out.println(allDoors);
    return allDoors;
  }

}
