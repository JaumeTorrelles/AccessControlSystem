package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import static baseNoStates.States.UNLOCKED_SHORTLY;

public class UnlockedShortly extends DoorState implements Observer {

  private static final Clock clock = new Clock(1);
  private static final int MAX_SECONDS_UNLOCKED = 10;
  private LocalDateTime start;

  public UnlockedShortly(Door door) {
    super(door);
    this.name = UNLOCKED_SHORTLY;
    start = LocalDateTime.now();
    clock.addObserver(this);
  }

  @Override
  public void open() {
    if (door.isClosed()) {
      this.door.setClosed(false);
    } else {
      System.out.println("Can't open door " + door.getId() + " because it's already open");
    }
  }

  @Override
  public void close() {
    if (!door.isClosed()) {
      this.door.setClosed(true);
    } else {
      System.out.println("Can't close door " + door.getId() + " because it's already closed");
    }
  }

  @Override
  public void lock() {
    System.out.println("Can't lock door " + door.getId() + " because it's already UnlockedShortly");
  }

  @Override
  public void unlock() {
    System.out.println("Can't unlock door " + door.getId() + " because it's already UnlockedShortly");
  }

  @Override
  public void unlockShortly() {
    System.out.println("Can't unlockShortly door " + door.getId() + " because it's already UnlockedShortly");
  }

  @Override
  public void update(Observable o, Object arg) {

    LocalDateTime now = (LocalDateTime) arg;
    long secondsPassed = Duration.between(start, now).getSeconds();
    if (secondsPassed >= MAX_SECONDS_UNLOCKED) {
      clock.deleteObserver(this);
      if (door.isClosed()) {
        door.setState(new Locked(door));
      } else {
        door.setState(new Propped(door));
      }
    }
  }

}
