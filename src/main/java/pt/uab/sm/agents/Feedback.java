package pt.uab.sm.agents;

import jade.core.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Feedback extends Agent {


    private static final Logger logger = LoggerFactory.getLogger(Feedback.class);


    @Override
    public void setup() {
        final String selectorAgent = (String) this.getArguments()[0];
        logger.info("Feedback-agent "+getAID().getName()+" is ready. Other => " + selectorAgent);
        //addBehaviour(new SearchNewPurchase(this, selectorAgent));
    }

    @Override
    public void takeDown() {

    }


}
