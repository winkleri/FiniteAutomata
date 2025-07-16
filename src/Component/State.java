package Component;

import java.util.ArrayList;
import java.util.List;

public class State {
        String name;
        ArrayList<Transition> edges;
        public State(String name) {
            this.name = name;
            this.edges = new ArrayList<>();
        }
        public ArrayList<Transition> getEdges() {
            return new ArrayList<>(edges);
        }

        public void addEdge(Transition... t) {
            edges.addAll(List.of(t));
        }

}
