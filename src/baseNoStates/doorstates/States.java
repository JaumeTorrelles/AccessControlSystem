package baseNoStates.doorstates;

// Names of the logical states of a door, as expected by the simulator in
// the "state" field of the JSON answers: it colors each reader with the
// color of its state (see colorsOfStates in building.js), so these strings
// can not be changed freely.
public final class States {
  public static final String LOCKED = "locked";
  public static final String UNLOCKED = "unlocked";
  public static final String UNLOCKED_SHORTLY = "unlocked_shortly";
}
