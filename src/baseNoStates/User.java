package baseNoStates;

import baseNoStates.areas.Area;
import baseNoStates.areas.Space;

import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private final ArrayList<Area> associatedAreas = new ArrayList<>();

  public boolean canBeInSpace (Space space) {
    for (Area area : associatedAreas) {
      for(Space areaSpace : area.getSpaces()){
        if(areaSpace.equals(space)){
          return true;
        }
      }
    }
    return false;
  }

  public void addArea(Area area){
    associatedAreas.add(area);
  }

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
