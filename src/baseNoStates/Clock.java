package baseNoStates;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {
  private LocalDateTime date;
  private Timer timer;
  private int period; // seconds

  public Clock(int period) {
    this.period = period;
    timer = new Timer();
    start();
  }

  public void start() {
    TimerTask repeatedTask = new TimerTask() {
      public void run() { // instance of anonymous class
        date = LocalDateTime.now();
        setChanged();
        notifyObservers(date);
      }
    };
    timer.scheduleAtFixedRate(repeatedTask, 0, 1000 * period);
  }

  public void stop() { timer.cancel(); }

  public int getPeriod() { return period; }

  public LocalDateTime getDate() { return date; }

}
