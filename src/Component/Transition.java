package Component;

public class Transition {
    char[] letters = new char[5];
    State origin;
    State destination;
    //        Currently no use case for method found since transition handles loops already
//        public boolean isLoop() {
//            return origin.equals(destination);
//        }
    public Transition(State origin, State destination, char... chars) {
        this.origin = origin;
        this.destination = destination;
        //copy varargs into array
        for (int i = 0; i < chars.length; i++) {
            letters[i] = chars[i];
        }
    }

    public State getDestination() {
        return this.destination;
    }
    public char[] getTransitionLetters() {
        return letters.clone();
    }
}