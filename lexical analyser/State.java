import java.util.*;
public class State {
    public boolean isFinal;
    public boolean isStart;
    public String name;
    public String tokenTypeOut; 

   
    public State(String name, boolean isStart, boolean isFinal, String tokenTypeOut) {
        this.name = name;
        this.isStart = isStart;
        this.isFinal = isFinal;
        this.tokenTypeOut = tokenTypeOut;
      
    }

    @Override
    public String toString() {
        return "State{" +
               "name='" + name + '\'' +
               ", isStart=" + isStart +
               ", isFinal=" + isFinal +
               ", tokenTypeOut='" + tokenTypeOut + '\'' +
               '}';
    }
}
