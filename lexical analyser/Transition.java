import java.util.*;

public class Transition {
    public State fromState;
    public State toState;
    ArrayList<Character> charList = new ArrayList<>();
    public int id;

    // Constructor
    public Transition(int id ,State fromState, State toState, ArrayList<Character> charList) {
        this.fromState = fromState;
        this.toState = toState;
        this.charList = charList;
        this.id=id;
    }
    @Override
    public String toString() {
        return "Transition{" +
               "id=" + id +
               ", fromState=" + fromState.name +
               ", toState=" + toState.name +
               ", charList=" + charList +
               '}';
    }
}
