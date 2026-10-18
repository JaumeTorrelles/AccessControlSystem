package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area{

  private ArrayList<Area> children;

  public Partition (String id, Partition parent) {
    super(id);
    children = new ArrayList<Area>();
    if(parent != null){
      parent.addChild(this);
    }
  }

  public void addChild(Area child){
    if(!children.contains(child)){
      children.add(child);
    }
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area child : children){
      spaces.addAll(child.getSpaces());
    }
    return spaces;
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doors = new ArrayList<>();
    for (Area child : children){
      doors.addAll(child.getDoorsGivingAccess());
    }
    return doors;
  }

  @Override
  public Area findAreaById(String id) {
    if(this.id.equals(id)){
      return this;
    }else{
      for (Area child : children){
        Area found = child.findAreaById(id);
        if(found != null){
          return found;
        }
      }
      return null;
    }
  }

}
