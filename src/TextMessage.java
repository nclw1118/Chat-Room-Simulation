/*
 * NAME: Xue Wang
 * PID: A15908778
 */

/**
 * Description of Sample Class
 * Textmessage class, subclass of Message
 * @author Xue Wang
 * @since 04/20/2020
 */
public class TextMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String EXCEED_MAX_LENGTH =
            "Your input exceeded the maximum length limit.";

    // input validation criteria
    private static final int MAX_TEXT_LENGTH = 1000;

    /**
     * Description of constructor
     * constructor of textMessage object
     * @param sender user object to initialize sender
     * @param text string object to initialize contents
     * @throws IllegalArgumentException if the text is null
     * @throws OperationDeniedException if the length of text exceeds 1000
     */
    public TextMessage(User sender, String text)
            throws OperationDeniedException {
        /* TODO: constructor of textmessage class */
        // super required by extending an abstract class
        super(sender);
        // input validation
        if(text==null){
            throw new IllegalArgumentException();
        }
        if(text.length()>MAX_TEXT_LENGTH){
            throw new OperationDeniedException(EXCEED_MAX_LENGTH);
        }
        // initialize the contents
        this.contents=text;
    }

    /**
     * Description of method
     *Returns a String in the form:
     * “SenderName [2020-01-15]: A sample text message.”
     * @return String, a special format of the username and content
     */
    public String getContents() {
        /* TODO : return a string in a special format*/
        //get the name and date in string
        String name= getSender().displayName();
        String date2 = getDate().toString();
        // add the name, date, and content in to one string and return
        String result = name+" ["+date2+"]: "+contents;
        return result;
    }

}
