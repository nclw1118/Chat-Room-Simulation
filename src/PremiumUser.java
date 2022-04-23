/*
 * NAME: Xue Wang
 * PID: A15908778
 */

import java.util.ArrayList;
/**
 * Description of Sample Class
 * PremiumUser class extends user class
 * @author Xue Wang
 * @since 04/20/2020
 */

public class PremiumUser extends User {

    // instance variable
    private String customTitle;
    /**
     * Description of constructor
     * Calls the super class with the input parameters.
     * Also initializes the customTitle class variable which is exclusive to the PremiumUser class.
     * @param username the username to initialize the username variable
     * @param bio the stirn gbio to initialize the bio variable
     */
    public PremiumUser(String username, String bio) {
        /* TODO */
        // call the super class with input parameters
        super(username,bio);
        // set the default tile to "premium"
        customTitle="Premium";
    }

    /**
     * Description of method
     * Fetches all messages from the log of the MessageExchange.
     * @param me the MessageExchange platform to fetch messages form
     * @return string of message that has been fetched
     * @throws IllegalArgumentException when the input is null
     */
    public String fetchMessage(MessageExchange me) {
        /* TODO */
        // input validation
        if (me==null){
            throw new IllegalArgumentException();
        }
        // collect all the message to a string and return the string
        String out= new String("");
        for(int i=0; i<me.getLog().size(); i++){
            out+=me.getLog().get(i).getContents()+"\n";
        }
        return out;
    }

    /**
     * Description of method
     * create a photoRoom instance
     * @param users the list of user to join the room
     * @return the room that has been created
     * @throws IllegalArgumentException if the input user is null
     */
    public MessageExchange createPhotoRoom(ArrayList<User> users) {
        /* TODO */
        // input validation check
        if(users==null){
            throw new IllegalArgumentException();
        }
        // create a new room
        PhotoRoom room= new PhotoRoom();
        // add the creator to the room
        room.addUser(this);
        //add the users in the list to the room
        for (int i=0; i<users.size(); i++){
            // handle the case if the user cannot join the room
            try {
                users.get(i).joinRoom(room);
            }catch(OperationDeniedException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        //return the room
        return room;
    }
    /**
     * Description of method
     * Returns the username and customTitle in the following format:
     * “<customTitle> username” where customTitle and username are replaced with their values.
     * @return a string in sepcial format of username and title
     */
    public String displayName() {
        /* TODO */
        return "<"+customTitle+"> "+username;
    }

    /**
     * Description of method
     * set the customTitle to a new value
     * @return void
     */
    public void setCustomTitle(String newTitle) {
        /* TODO */
        // set the customTitle to a new value
        customTitle=newTitle;
    }
}
