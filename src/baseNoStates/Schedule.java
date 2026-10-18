package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {

  private LocalDate fromDate;
  private LocalDate toDate;
  private ArrayList<DayOfWeek> days;
  private LocalTime fromTime;
  private LocalTime toTime;

  public Schedule(LocalDate fromDate, LocalDate toDate,
                  ArrayList<DayOfWeek> days, LocalTime fromTime,LocalTime toTime){
    this.fromDate = fromDate;
    this.toDate = toDate;
    this.days = days;
    this.fromTime = fromTime;
    this.toTime = toTime;
  }

  public boolean isInSchedule(LocalDateTime now) {

    LocalDate date = now.toLocalDate();
    LocalTime time = now.toLocalTime();

    boolean isDateInRange = !date.isBefore(fromDate) && !date.isAfter(toDate);
    boolean isDayAllowed = days.contains(date.getDayOfWeek());
    boolean isTimeInRange = !time.isBefore(fromTime) && !time.isAfter(toTime);

    return isDateInRange && isDayAllowed && isTimeInRange;

  }

}
