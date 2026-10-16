package baseNoStates.doorstates;

import baseNoStates.Door;

// The State pattern applied to doors: what an action (open, close, lock,
// unlock) does depends on the state of the door, so instead of scattering
// if-then-else checking the state inside the methods of Door, each state of
// the diagram of figure 7 of the handout is a subclass of DoorState knowing
// what to do, or to refuse, for each action. Adding the new states of the
// next steps, unlocked shortly and propped, will just be adding new
// subclasses.
//
// Each state object holds its door because the state is the one that makes
// the changes of state: when a valid action arrives, it calls
// door.setState(new SomeState(door)).
public abstract class DoorState {
  protected final Door door;
  private final String name;

  public DoorState(Door door, String name) {
    this.door = door;
    this.name = name;
  }

  public String getStateName() {
    return name;
  }

  public abstract void open();

  public abstract void close();

  public abstract void lock();

  public abstract void unlock();
}
