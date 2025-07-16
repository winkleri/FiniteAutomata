package Component;

public class Transition {
    //modifiable amount of letters
    private final char[] letters = new char[5];
    private final State destination;

    public Transition(State destination, char... chars) {
        this.destination = destination;
        //copy varargs into array
        System.arraycopy(chars, 0, letters, 0, chars.length);
    }

    public State getDestination() {
        return this.destination;
    }

    public char[] getTransitionLetters() {
        return letters.clone();
    }
}