package baseNoStates;

import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private ArrayList<Area> areas;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
    areas = new ArrayList<Area>();
  }

  public void addArea(Area area){
    areas.add(area);
  }

  public String getName() {
    return name;
  }

  private ArrayList<Space> getSpaces(){
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area child : areas){
      spaces.addAll(child.getSpaces());
    }
    return spaces;
  }

  public boolean canBeInSpace(Space space){
    if(getSpaces().contains(space)){
      return true;
    }else{
      return false;
    }
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
