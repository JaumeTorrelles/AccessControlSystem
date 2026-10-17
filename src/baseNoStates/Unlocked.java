package baseNoStates;

import static baseNoStates.States.UNLOCKED;

public class Unlocked extends DoorState{

  public Unlocked(Door door) {
    super(door);
    super.name = UNLOCKED;
  }

  @Override
  public void open(){
    if(door.isClosed()){
      door.setClosed(false);
    }else{
      System.out.println("Can't open door " + door.getId() + " because it's already open");
    }
  }

  @Override
  public void close(){
    if(!door.isClosed()){
      door.setClosed(true);
    }else{
      System.out.println("Can't close door " + door.getId() + " because it's already closed");
    }
  }

  @Override
  public void lock(){
    if(door.isClosed()){
      this.door.setState(new Locked(door));
    }else{
      System.out.println("Can't lock door " + door.getId() + " because it's already open");
    }
  }

  @Override
  public void unlock(){
    System.out.println("Can't unlock "+  door.getId()  +" door because it's already unlocked");
  }
}
