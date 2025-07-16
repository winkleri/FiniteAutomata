package Automaton;

import Component.State;
import Component.Transition;
import java.util.HashSet;
import java.util.Scanner;

public class FiniteAutomaton implements Automaton {
    private final State dead = new State("dead");
    private final Scanner sc;
    private final String name;
    private State start;
    private State current;
    private State win;
    private final HashSet<State> accepting;

    public FiniteAutomaton(String name) {
        this.name = name;
        this.start = new State("start");
        this.sc = new Scanner(System.in);
        this.accepting = new HashSet<>();
        initialize();
    }

    public void initialize() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        Transition t1 = new Transition(q0, '0');
        Transition t2 = new Transition(q1, '1');
        Transition t3 = new Transition(q1, 'a', 'b', 'c');
        q0.addEdge(t1,t2); //q0 calls method .addEdge() because it is an origin state for t1 and t2
        q1.addEdge(t3); // t3 loops on q1
        start = q0;
        win = q1;
        accepting.add(win);
    }

    public void run() {
        current = start;
        System.out.printf("Enter word for state machine %s\n", name);
        String input = sc.nextLine();
        sc.close();
        current = transition(input);

        if(current.equals(win)) {
            System.out.printf("Your word: '%s' was accepted by state machine %s\n", input, name);
        } else if (current.equals(dead)){
            System.out.printf("Your word: '%s' was not accepted by state machine %s\n", input, name);
        }
    }

    public State transition(String word) {
        if(word.isEmpty() && accepting.contains(current)) { //End of recursion
            current = win; //win is a state that marks when satisfactory conditions for acceptance are met
            return current;
        } else if(word.isEmpty()) {
            current = dead;
            return current;
        }
        for(Transition transition : current.getEdges()) {
            for(char c : transition.getTransitionLetters()) {
                if(word.charAt(0) == c) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.delete(0,1); //
                    current = transition.getDestination();
                    transition(sb.toString());
                    return current;
                }
            }
        }
        return dead; //dead state always rejects
    }

}
