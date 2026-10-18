package baseNoStates;


import static baseNoStates.States.PROPPED;

public class Propped extends DoorState{

  public Propped(Door door){
    super(door);
    this.name = PROPPED;
  }

  @Override
  public void open() {
    System.out.println("Can't open door "+  door.getId()  +" because it's already propped");
  }

  @Override
  public void close() {
    if(!door.isClosed()){
      this.door.setClosed(true);
      this.door.setState(new Locked(door));
    }else{
      System.out.println("Can't close door " + door.getId() + " because it's already closed");
    }
  }

  @Override
  public void lock() {
    System.out.println("Can't lock door "+  door.getId()  +" because it's already propped");
  }

  @Override
  public void unlock() {
    System.out.println("Can't unlock door "+  door.getId()  +" because it's already propped");
  }

  @Override
  public void unlockShortly() {
    System.out.println("Can't unlockShortly door "+  door.getId()  +" because it's already propped");
  }
}
