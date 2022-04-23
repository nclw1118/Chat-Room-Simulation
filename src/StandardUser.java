/*
 * NAME: Xue Wang
 * PID: A15908778
 */

import java.util.ArrayList;
import java.util.List;
/**
 * Description of Sample Class
 * StandardUser class extends User calss
 * @author Xue Wang
 * @since 04/20/2020
 */

public class StandardUser extends User {

    // Message to append when fetching non-text message
    private static final String FETCH_DENIED_MSG =
            "This message cannot be fetched because you are not a premium user.";
    private  static final int DEVIDOR=10;
    private String customTitle;

    /**
     * Description of constructor
     * Calls the super class with the input parameters.
     * @param username a string to initialize the variable username
     * @param bio a string to intialize the variable bio
     */
    public StandardUser(String username, String bio) {
        // call the User class' constructor
        super(username,bio);
        /* TODO */
    }

    /**
     * Description of method
     * fetch message form the me. For standard users, they can only fetch
     * the latest 1/10 of all the messages in the message exchange.
     * @param me the MessageExchange platform to fetch message from
     * @return the message that is fetched by the user
     * @throws IllegalArgumentException when the input is null
     */
    public String fetchMessage(MessageExchange me) {
        /* TODO */
        // input validation check
        if (me==null){
            throw new IllegalArgumentException();
        }
        // if there is less than 10 messages, standard user cannot see anything
        if(me.getLog().size()<DEVIDOR){
            return "";

        }
        // if there are more than 10 messages, calculate the number of message the user can see
        int number= me.getLog().size()/DEVIDOR;
        ArrayList<String> strarry = new ArrayList<String>(number);
        // add the lasted n message to the output
        for( int i=0; i<number;i++){
            if(me.getLog().get(me.getLog().size()-i-1) instanceof TextMessage){
                strarry.add(me.getLog().get(me.getLog().size()-i-1).getContents());
            }
            else{
                // if the message is not a textmessage,
                // the standard user can only see FETCH_DENIED_MSG
                strarry.add(FETCH_DENIED_MSG);
            }
        }
        // since the message collected before is inversed, inverse them back
        String out= new String("");
        for(int i=strarry.size()-1; i>=0; i--){
            out+=strarry.get(i)+"\n";
        }
        return out;
    }

    /**
     * Description of method
     * return the username
     * @return the username
     */
    public String displayName() {
        return username;
    }
}
