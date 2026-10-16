package baseNoStates.areas;

import baseNoStates.Door;

import java.util.ArrayList;

// A leaf of the Composite: a physical place of the building (a room, the
// hall, ...). It knows the doors giving access to it, that is, those whose
// toSpace is this space, because area requests must affect all of them.
public class Space extends Area {
  private final String id;
  private ArrayList<Door> doors;

  public Space(String id) {
    this.id = id;
    doors = new ArrayList<>();
  }

  public void addDoor(Door door) {
    doors.add(door);
  }

  public String getId() {
    return id;
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doors;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<Space>();
    spaces.add(this);
    return spaces;
  }

  @Override
  public Area findAreaById(String id) {
    return this.id.equals(id) ? this : null;
  }
}
