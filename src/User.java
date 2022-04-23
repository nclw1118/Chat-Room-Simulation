/*
 * NAME: Xue Wang
 * PID: A15908778
 */
import java.util.ArrayList;

/**
 * Description of Sample Class
 * Abstract class User
 * @author Xue Wang
 * @since 04/20/2020
 */
public abstract class User {

    // Error message to use in OperationDeniedException
    protected static final String JOIN_ROOM_FAILED =
            "Failed to join the chat room.";
    protected static final String INVALID_MSG_TYPE =
            "Cannot send this type of message to the specified room.";

    // instance variables
    protected String username;
    protected String bio;
    protected ArrayList<MessageExchange> rooms;

    /**
     * Description of constructor
     * initialize bio, username, and rooms
     * @param username the string used to initialize the username
     * @param bio the string used to initialize the bio
     * @throws IllegalArgumentException if the username or bio is null
     */
    public User(String username, String bio) {
        /* TODO :initialize bio, username, and rooms */
        // input validation check
        if(username==null|| bio==null){
            throw new IllegalArgumentException();
        }
        //initialize bio, username, and rooms
        this.username=username;
        this.bio=bio;
        rooms= new ArrayList<MessageExchange>();
    }

    /**
     * Description of method
     * This method updates the class variable bio with a new one.
     * @param newBio the new Bio to assign
     * @return void
     * @throws IllegalArgumentException when the newBio is null
     */
    public void setBio(String newBio) {
        /* TODO :updates the class variable bio with a new one.*/
        // input validation check
        if(newBio==null){
            throw new IllegalArgumentException();
        }
        // assign bio to the newBio
        bio=newBio;
    }

    /**
     * Description of method
     * This method Returns the bio.
     * @return String, the bio of the user
     */
    public String displayBio() {
        /* TODO ; returns the bio of the uer*/
        return bio;
    }

    /**
     * Description of method
     * This method adds the user to the list of users in the message
     * exchange platform and adds the platform to the list of rooms of this user.
     * @param me the MessageExchange platform for the user to join
     * @return void
     * @throws IllegalArgumentException if me is null
     * @throws OperationDeniedException if the user is already in the room
     */
    public void joinRoom(MessageExchange me) throws OperationDeniedException {
        /* TODO :adds the user to the list of users in the message exchange platform
            and adds the platform to the list of rooms of this user.*/
        // if the user is already in the room, throw exception
        if(rooms.contains(me)){
            throw new OperationDeniedException(JOIN_ROOM_FAILED);
        }
        // if input me is null, throw exception
        if(me==null){
            throw new IllegalArgumentException();
        }
        //adds the user to the list of users in the message exchange platform and
        // adds the platform to the list of rooms of this user.
        me.addUser(this);
        rooms.add(me);
    }

    /**
     * Description of method
     * Removes the message exchange platform from the list of rooms that this user
     * is a member of and removes the user from the list of users recorded in the
     * MessageExchange object.
     * @param me the MessageExchange platform to quit
     * @return void
     * @throws IllegalArgumentException if me is null
     */
    public void quitRoom(MessageExchange me) {
        /* TODO : make the user quit the MessageExchange platform */
        // input validation check
        if(me==null){
            throw new IllegalArgumentException();
        }
        // remove the user from the platform
        me.removeUser(this);
        rooms.remove(me);
    }

    /**
     * Description of method
     * Creates a new instance of the ChatRoom (will be implemented later) class.
     * @param users list of users to join the chatroom
     * @return the MessageExchange that has been created
     * @throws IllegalArgumentException if the users is null
     */
    public MessageExchange createChatRoom(ArrayList<User> users) {
        /* TODO :Creates a new instance of the ChatRoom*/
        // input validation
        if(users==null){
            throw new IllegalArgumentException();
        }
        //create a new chat room and add the users in the users list to it
        ChatRoom chat= new ChatRoom();
        chat.addUser(this);
        for (int i=0; i<users.size(); i++){
            // handle the exception if the user cannot join the room
            try {
                users.get(i).joinRoom(chat);
            }catch(OperationDeniedException e){
                System.out.println(e.getMessage());
                continue;
            }
        }
        // return
        return chat;
    }

    /**
     * Description of method
     * Creates an instance of a message with the correct type specified by
     * the msgType (compare it to the static class variables in the Message class).
     * Record the message instance in the MessageExchange.
     * @param me the MessageExchange platform to send message
     * @param msgType int number to describe the type of the message
     * @param contents string the content of the message
     * @return void
     * @throws  IllegalArgumentException if the value of msgType is invalid
     * @throws  IllegalArgumentException if me or content is null
     * @throws  IllegalArgumentException if user didn't join ime
     */
    public void sendMessage(MessageExchange me, int msgType, String contents) {
        /* TODO */
        //input validation check
        if(!(msgType==Message.TEXT||msgType==Message.STICKER||msgType==Message.PHOTO)){
            throw new IllegalArgumentException();
        }
        if(me==null||contents==null){
            throw new IllegalArgumentException();
        }
        if(! me.getUsers().contains(this)){
            throw new IllegalArgumentException();
        }
        try {
            // check the type of the message, print out the INVALID_MSG_TYPE
            // message if the message cannot be recorded.
            if (msgType == Message.TEXT) {
                TextMessage mes = new TextMessage(this, contents);
                if(me.recordMessage(mes)== false){
                    System.out.println(INVALID_MSG_TYPE);
                }
            } else if (msgType == Message.PHOTO) {
                PhotoMessage mes = new PhotoMessage(this, contents);
                if(me.recordMessage(mes)== false){
                    System.out.println(INVALID_MSG_TYPE);
                }
            } else if (msgType == Message.STICKER) {
                StickerMessage mes = new StickerMessage(this, contents);
                if(me.recordMessage(mes)== false){
                    System.out.println(INVALID_MSG_TYPE);
                }
            }
        }catch(OperationDeniedException e){
            System.out.println(e.getMessage());
        }
    }

    public abstract String fetchMessage(MessageExchange me);

    public abstract String displayName();
}
