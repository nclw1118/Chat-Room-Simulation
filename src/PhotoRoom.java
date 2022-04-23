/*
 * NAME: Xue Wang
 * PID: A15908778
 */
import java.util.ArrayList;

/**
 * Description of Sample Class
 * PhotoRoom class implements the MessageExchange interface
 * @author Xue Wang
 * @since 04/20/2020
 */

public class PhotoRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    /**
     * Description of constructor
     * initialize the users and log variable
     */
    public PhotoRoom() {
        /* TODO */
        //initialize the users and log variable
        users=new ArrayList<User>();
        log= new ArrayList<Message>();
    }

    /**
     * Description of method
     * Method returns the log of this chat room.
     * @return the log of that chat room
     */
    public ArrayList<Message> getLog() {
        /* TODO */
        return log;
    }

    /**
     * Description of method
     * Method adds the given user u to this room and returns true.
     * @return boolean, true if the user is a premium user, false otherwise
     */
    public boolean addUser(User u) {
        /* TODO */
        //if the user is a premium user, add he to the room and return true
        if(u instanceof PremiumUser){
            users.add(u);
            return true;
        }
        // if he is not a premium user, return false
        else{
            return false;
        }
    }

    /**
     * Description of method
     * Method removes the given user u from this room.
     * No action needed if you cannot find the given user before removal.
     * @return void
     */
    public void removeUser(User u) {
        /* TODO */
        // if the user is in the room, remove it
        // no action needed if the user is not in the room
        if (users.contains(u)){
            users.remove(u);
        }
    }

    /**
     * Description of method
     * Method returns the users of this photo room.
     * @return the users of this chat room
     */
    public ArrayList<User> getUsers() {
        /* TODO */
        return users;
    }

    /**
     * Description of method
     * Method adds a new message to the log of this photo room.
     * If this message is not a PhotoMessage, deny this operation by returning false.
     * Otherwise, record the message and return true.
     * @return true if the message is a PhotoMessage, false otherwise.
     */
    public boolean recordMessage(Message m) {
        /* TODO */
        //If this message is a PhotoMessage, record the message and return true.
        if(m instanceof PhotoMessage){
            log.add(m);
            return true;
        }
        //If this message is not a PhotoMessage, deny this operation by returning false.
        else{
            return false;
        }
    }

}
