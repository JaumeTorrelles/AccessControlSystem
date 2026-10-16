package baseNoStates.groups;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

// The "when" of the RBAC model: a validity interval made of a date
// interval, the days of the week it applies to and a daily time interval,
// all with inclusive limits. It knows nothing about users or doors: it
// just answers if a given date-time falls inside it.
public class Schedule {
  private final LocalDate startDate;
  private final LocalDate endDate;
  private final ArrayList<DayOfWeek> daysOfWeek;
  private final LocalTime startTime;
  private final LocalTime endTime;

  public Schedule(LocalDate startDate, LocalDate endDate,
                  ArrayList<DayOfWeek> daysOfWeek,
                  LocalTime startTime, LocalTime endTime) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.daysOfWeek = daysOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public boolean isDateTimeValid(LocalDateTime now) {
    LocalTime time = now.toLocalTime();
    LocalDate date = now.toLocalDate();

    return !date.isBefore(startDate)
        && !date.isAfter(endDate)
        && daysOfWeek.contains(now.getDayOfWeek())
        && !time.isBefore(startTime)
        && !time.isAfter(endTime);
  }
}