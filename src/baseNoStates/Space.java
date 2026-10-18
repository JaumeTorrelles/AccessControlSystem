package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class Space extends Area{

  private ArrayList<Door> doors;

  public Space(String id, Partition parent){
    super(id);
    doors = new ArrayList<Door>();
    parent.addChild(this);
  }

  public void addDoor(Door door){
    this.doors.add(door);
  }

  @Override
  public Area findAreaById(String id) {
    if(this.id.equals(id)){
      return this;
    }else{
      return null;
    }
  }

  @Override
  public ArrayList<Space> getSpaces() {
    return new ArrayList<Space>(Arrays.asList(this));
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return this.doors;
  }
}
