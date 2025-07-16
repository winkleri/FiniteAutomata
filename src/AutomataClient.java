import Automaton.FiniteAutomaton;

public class AutomataClient {
    public static void main(String[] args) {
        FiniteAutomaton statemachine = new FiniteAutomaton("A");
        statemachine.run();
    }
}
