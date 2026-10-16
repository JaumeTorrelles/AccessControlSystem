package baseNoStates.doorstates;

import baseNoStates.Clock;
import baseNoStates.Door;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

// The bolt of the door is switched off for 10 seconds, so the door can be
// opened. After those 10 seconds the clock warns this state, that is an
// Observer of it: if the door is closed it returns to Locked, but if
// someone has left it open it becomes Propped.
public class UnlockedShortly extends DoorState implements Observer {

  // a unique clock, shared by all the doors in this state and started
  // just once, the first time this class is used
  private static final Clock CLOCK = new Clock(1);
  private final LocalDateTime startTime = LocalDateTime.now();

  static {
    CLOCK.start();
  }

  public UnlockedShortly(Door door) {
    super(door, States.UNLOCKED_SHORTLY);
    // entering the state = becoming an observer of the clock
    CLOCK.addObserver(this);
  }

  // called by the clock at every tick
  @Override
  public void update(Observable o, Object arg) {
    if (Duration.between(startTime, LocalDateTime.now()).getSeconds() >= 10) {
      // the state is about to change, so it must stop observing the clock
      CLOCK.deleteObserver(this);
      if (door.isClosed()) {
        door.setState(new Locked(door));
      } else {
        door.setState(new Propped(door));
      }
    }
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

  @Override
  public void lock() {
    System.out.println("Can't lock door " + door.getId() + " it's unlocked shortly");
  }

  @Override
  public void unlock() {
    System.out.println("Door " + door.getId() + " is already unlocked (shortly)");
  }

  @Override
  public void unlockShortly() {
    System.out.println("Door " + door.getId() + " is unlocked shortly");
  }
}