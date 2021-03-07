package pt.uab.sm.agents.behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import pt.uab.sm.model.Book;
import pt.uab.sm.model.User;

import java.util.HashMap;
import java.util.List;

import static pt.uab.sm.Main.users;
import static pt.uab.sm.agents.messages.MessageBuilder.inform;

public class AddNewHighlights extends Behaviour {

    private final Agent agent;
    //private State state;
    private final String feedbackAgent;
    private HashMap<Integer, List<Book>> favortiesPerUser;

    public AddNewHighlights(Agent agent, String feedbackAgent) {
        this.agent = agent;
        this.feedbackAgent = feedbackAgent;
    }

    @Override
    public void action() {
        favortiesPerUser = new HashMap<>();

        agent.send(inform().toLocal(feedbackAgent).withContent(1).build());

    }

    @Override
    public boolean done() {
        return false;
    }

}
