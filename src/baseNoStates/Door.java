package baseNoStates;

import baseNoStates.areas.Space;
import baseNoStates.doorstates.DoorState;
import baseNoStates.doorstates.Unlocked;
import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed;
  // the logical state of the door (unlocked, locked, ...), not to be
  // confused with the physical state closed, see DoorState
  private DoorState state;
  private final Space fromSpace;
  private final Space toSpace;

  public Door(String id, Space fromSpace, Space toSpace) {
    this.id = id;
    this.fromSpace = fromSpace;
    this.toSpace = toSpace;
    this.closed = true;
    this.state = new Unlocked(this);

    toSpace.addDoor(this);
  }

  public Space getFromSpace() {
    return fromSpace;
  }

  public Space getToSpace() {
    return toSpace;
  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        state.open();
        break;
      case Actions.CLOSE:
        state.close();
        break;
      case Actions.LOCK:
        state.lock();
        break;
      case Actions.UNLOCK:
        state.unlock();
        break;
      case Actions.UNLOCK_SHORTLY:
        state.unlockShortly();
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return state.getStateName();
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }

  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  public void setState(DoorState newState) {
    state = newState;
  }
}
