package baseNoStates.doorstates;

import baseNoStates.Door;

// The door was left open after an unlock shortly. It stays open until
// someone closes it, and then it returns to Locked: this close is the
// only transition of this state.
public class Propped extends DoorState {

  public Propped(Door door) {
    super(door, States.PROPPED);
  }

  @Override
  public void open() {
    System.out.println("Door " + door.getId() + " already open (propped)");
  }

  @Override
  public void close() {
    door.setClosed(true);
    door.setState(new Locked(door));
  }

  @Override
  public void lock() {
    System.out.println("Can't lock door " + door.getId() + " because it's open (propped)");
  }

  @Override
  public void unlock() {
    System.out.println("Can't unlock door " + door.getId() + " because it's open (propped)");
  }

  @Override
  public void unlockShortly() {
    System.out.println("Can't unlock shortly door " + door.getId() + " because it's open (propped)");
  }
}
