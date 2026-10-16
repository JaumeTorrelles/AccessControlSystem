package baseNoStates.doorstates;

import baseNoStates.Door;

// State in which the door can always be opened. The open and closed
// substates of the state diagram correspond to the attribute closed of
// Door, that the actions of this state set accordingly.
public class Unlocked extends DoorState {

  public Unlocked(Door door) {
    super(door, States.UNLOCKED);
  }

  @Override
  public void open() {
    if (door.isClosed()) {
      door.setClosed(false);
    } else {
      System.out.println("Door " + door.getId() + " already open");
    }
  }

  @Override
  public void close() {
    if (!door.isClosed()) {
      door.setClosed(true);
    } else {
      System.out.println("Door " + door.getId() + " already closed");
    }
  }

  // strict transition: the state diagram draws the lock action only from
  // the closed substate, so locking an open door is refused. This keeps
  // the invariant of Locked that its door is closed
  @Override
  public void lock() {
    if (door.isClosed()) {
      door.setState(new Locked(door));
    } else {
      System.out.println("Can't lock door " + door.getId() + " because it's open");
    }
  }

  @Override
  public void unlock() {
    System.out.println("Door " + door.getId() + " already unlocked");
  }

  @Override
  public void unlockShortly() {
    System.out.println("Door " + door.getId() + " already unlocked");
  }
}
