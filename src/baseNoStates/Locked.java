package baseNoStates;

import static baseNoStates.States.LOCKED;

public class Locked extends DoorState{


  public Locked(Door door) {
    super(door);
    super.name = LOCKED;
  }

  @Override
  public void open(){
    System.out.println("Can't open "+  door.getId()  +" door because it's already locked");
  }

  @Override
  public void close(){
    System.out.println("Can't close "+  door.getId()  +" door because it's already locked");
  }

  @Override
  public void lock(){
    System.out.println("Can't lock " +  door.getId()  +" door because it's already locked");
  }

  @Override
  public void unlock(){
    this.door.setState(new Unlocked(door));
  }

}
