package baseNoStates.areas;

import baseNoStates.Door;

import java.util.ArrayList;

// The Composite of the pattern: a group of areas (other partitions and/or
// spaces), like a floor or the whole building. Its methods traverse the
// tree recursively through its children, which can be any Area, so the
// callers don't need to distinguish partitions from spaces.
public class Partition extends Area {
  private final String id;
  private ArrayList<Area> childAreas;

  public Partition(String id) {
    this.id = id;
    childAreas = new ArrayList<>();
  }

  public void addChildArea(Area child) {
    childAreas.add(child);
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> allDoors = new ArrayList<>();
    for (Area child : childAreas) {
      allDoors.addAll(child.getDoorsGivingAccess());
    }
    return allDoors;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> allSpaces = new ArrayList<>();
    for (Area child : childAreas) {
      allSpaces.addAll(child.getSpaces());
    }
    return allSpaces;
  }

  @Override
  public Area findAreaById(String id) {
    if (this.id.equals(id)) {
      return this;
    } else {
      for (Area child : childAreas) {
        Area found = child.findAreaById(id);
        if (found != null) {
          return found;
        }
      }
    }
    return null;
  }
}