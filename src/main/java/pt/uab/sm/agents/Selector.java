package pt.uab.sm.agents;


import jade.core.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.uab.sm.agents.behaviours.AddNewHighlights;

public class Selector extends Agent {

    private static final Logger logger = LoggerFactory.getLogger(Selector.class);

    @Override
    public void setup() {
        final String feedbackAgent = (String) this.getArguments()[0];
        logger.info("Collector-agent "+getAID().getName()+" is ready. Other => " + feedbackAgent);
        addBehaviour(new AddNewHighlights(this, feedbackAgent));
    }

    @Override
    public void takeDown() {

    }


}
