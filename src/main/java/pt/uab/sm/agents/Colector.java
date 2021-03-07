package pt.uab.sm.agents;

import jade.core.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.uab.sm.agents.behaviours.SaveFavorites;

public class Colector extends Agent {

    private static final Logger logger = LoggerFactory.getLogger(Colector.class);

    @Override
    public void setup() {
        final String selectorAgent = (String) this.getArguments()[0];
        logger.info("Collector-agent "+getAID().getName()+" is ready. Other => " + selectorAgent);
        addBehaviour(new SaveFavorites(this, selectorAgent));
    }

    @Override
    public void takeDown() {

    }

}
