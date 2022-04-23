/*
 * NAME: Xue Wang
 * PID: A15908778
 */

import java.util.ArrayList;

/**
 * Description of Sample Class
 * ChatRoom class implements MessageExchange interface
 * @author Xue Wang
 * @since 04/20/2020
 */

public class ChatRoom implements MessageExchange {

    // instance variables
    private ArrayList<User> users;
    private ArrayList<Message> log;

    /**
     * Description of constructor
     * The constructor should initialize class variable users and log.
     */
    public ChatRoom() {
        /* TODO */
        // initialize the users and log.
        users= new ArrayList<User>();
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
     * @return boolean, true if the operation succeeded
     */
    public boolean addUser(User u) {
        /* TODO */
        users.add(u);
        //always return true
        return true;
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
        if(users.contains(u)){
            users.remove(u);
        }
    }

    /**
     * Description of method
     * Method returns the users of this chat room.
     * @return the users of this chat room
     */
    public ArrayList<User> getUsers() {
        /* TODO */
        return users;
    }

    /**
     * Description of method
     * Method adds a new message to the log of this chat room and returns true.
     * @return always return true
     */
    public boolean recordMessage(Message m) {
        /* TODO */
        log.add(m);
        // the method always returns true
        return true;
    }


}