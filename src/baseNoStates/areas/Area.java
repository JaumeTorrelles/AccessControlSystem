package baseNoStates.areas;

import baseNoStates.Door;

import java.util.ArrayList;

// The Component of the Composite pattern: an Area is either a Partition
// (a group of areas) or a Space (a leaf with doors giving access to it).
// Clients like RequestArea or User treat both the same way through these
// three methods, that each subclass implements, recursively for partitions.
public abstract class Area {

  public abstract ArrayList<Door> getDoorsGivingAccess();
  public abstract ArrayList<Space> getSpaces();
  public abstract Area findAreaById(String id);

}