/*
 * NAME: Xue Wang
 * PID: A15908778
 */
import java.time.LocalDate;
/**
 * Description of Sample Class
 * Abstract class Message
 * @author Xue Wang
 * @since 04/20/2020
 */
public abstract class Message {

    // Use these variable names as the msgType argument of sendMessage()
    // DO NOT MODIFY!
    public static final int TEXT    = 1000;
    public static final int PHOTO   = 1001;
    public static final int STICKER = 1002;

    // Error message to use in OperationDeniedException
    protected static final String DENIED_USER_GROUP =
            "This operation is disabled in your user group.";

    // instance variables
    private LocalDate date;
    private User sender;
    protected String contents;

    /**
     * Description of constructor
     * Constructor will set the sender and date fields.
     * @param sender user object to initiate the variable sender
     * @throws IllegalArgumentException if the sender is null
     */
    public Message(User sender) {
        /* TODO : constructor of the Message class*/
        // input validation
        if(sender==null){
            throw new IllegalArgumentException();
        }
        // set date and sender
        this.date = LocalDate.now();
        this.sender= sender;
    }

    /**
     * Description of method
     * Method will return the date of this message.
     * @return return the date of message
     */
    public LocalDate getDate() {
        /* TODO: return the date of message */
        return date;
    }

    /**
     * Description of method
     * Method will return the sender of this message.
     * @return return the sender of message
     */
    public User getSender() {
        /* TODO: return the sender of the message */
        return this.sender;
    }

    /**
     * Description of method
     * abstract method get content
     * @return string of the content of the message.
     */
    public abstract String getContents();


}