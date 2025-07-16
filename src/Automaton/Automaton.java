package Automaton;

import Component.State;

public interface Automaton {
    void run();
    State transition(String word);
}
