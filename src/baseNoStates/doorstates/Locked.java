package baseNoStates.doorstates;

import baseNoStates.Door;

// State in which the door can not be opened. It holds the invariant that
// the door is closed, and it can only be left by the actions unlock and,
// later on (step 1.4), unlock shortly.
public class Locked extends DoorState {

  public Locked(Door door) {
    super(door, States.LOCKED);
  }

  @Override
  public void open() {
    System.out.println("Can't open door " + door.getId() + " because it's locked");
  }

  @Override
  public void close() {
    System.out.println("Door " + door.getId() + " already closed");
  }

  @Override
  public void lock() {
    System.out.println("Door " + door.getId() + " already locked");
  }

  @Override
  public void unlock() {
    door.setState(new Unlocked(door));
  }

  @Override
  public void unlockShortly() {
    door.setState(new UnlockedShortly(door));
  }
}
