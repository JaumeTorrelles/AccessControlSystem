package baseNoStates;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

// The clock of the ACU: a thread of its own that ticks every `period`
// seconds and, as an Observable of the Observer pattern, notifies its
// observers (the states unlocked shortly) so that they can check their
// 10 seconds while the ACU keeps processing new requests.
public class Clock extends Observable {
  private final Timer timer;
  private final int period; // seconds

  public Clock(int period) {
    this.period = period;
    timer = new Timer();
  }

  public void start() {
    TimerTask repeatedTask = new TimerTask() {
      @Override
      public void run() {
        setChanged();
        notifyObservers();
      }
    };
    timer.scheduleAtFixedRate(repeatedTask, 0, 1000L * period);
  }

  public void stop() {
    timer.cancel();
  }
}