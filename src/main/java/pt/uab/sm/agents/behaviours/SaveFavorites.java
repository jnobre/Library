package pt.uab.sm.agents.behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import pt.uab.sm.model.Book;
import pt.uab.sm.model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pt.uab.sm.Main.books;
import static pt.uab.sm.Main.users;
import static pt.uab.sm.agents.messages.MessageBuilder.inform;

public class SaveFavorites extends Behaviour {

    private final Agent agent;
    //private State state;
    private final String selectorAgent;
    private HashMap<Integer, List<Book>> favortiesPerUser;
    final static String outputFilePath = "src/main/resources/favorites.txt";

    public SaveFavorites(Agent agent, String selectorAgent) {
        this.agent = agent;
        this.selectorAgent = selectorAgent;
    }

    @Override
    public void action() {
        favortiesPerUser = new HashMap<>();

        for(User user: users) {
            favortiesPerUser.put(user.getId(),user.getFavorites());
        }

        File file = new File(outputFilePath);

        BufferedWriter bf = null;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Map.Entry<Integer, List<Book>> entry :
                    favortiesPerUser.entrySet()) {

                bf.write(entry.getKey() + ": ");
                for(Book book : entry.getValue()) {
                    // put key and value separated by a colon
                    bf.write(book.toString());
                }
                // new line
                bf.newLine();
            }
            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // always close the writer
                bf.close();
            } catch (Exception e) {}
        }

        agent.send(inform().toLocal(selectorAgent).withContent(1).build());

    }

    @Override
    public boolean done() {
        return false;
    }


}
