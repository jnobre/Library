package pt.uab.sm.agents.behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import pt.uab.sm.model.Book;
import pt.uab.sm.model.User;

import java.util.HashMap;
import java.util.List;

import static pt.uab.sm.Main.users;
import static pt.uab.sm.agents.messages.MessageBuilder.inform;

public class SearchFeedback extends Behaviour {

    private final Agent agent;
    //private State state;
    private final String selectorAgent;
    private HashMap<Integer, List<Book>> favortiesPerUser;

    public SearchFeedback(Agent agent, String selectorAgent) {
        this.agent = agent;
        this.selectorAgent = selectorAgent;
    }

    @Override
    public void action() {
        System.out.println("Feddback]");

    }

    @Override
    public boolean done() {
        return false;
    }
}
