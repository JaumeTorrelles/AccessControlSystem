package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically
  private DoorState state;
  private Space fromSpace;
  private Space toSpace;

  public Door(String id, Space from, Space to) {
    this.id = id;
    closed = true;
    this.state = new Unlocked(this);
    this.fromSpace = from;
    this.toSpace = to;
    to.addDoor(this);
  }

  public Space getFromSpace(){
    return fromSpace;
  }

  public Space getToSpace(){
    return toSpace;
  }

  public void setState(DoorState state){

    this.state = state;

  }

  public void setClosed(boolean closed){

    this.closed = closed;

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
        // TODO
        System.out.println("Action " + action + " not implemented yet");
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

    return state.getName();

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
    json.put("originSpace",getFromSpace().getId() );
    json.put("destinationSpace",getToSpace().getId());
    return json;
  }
}
