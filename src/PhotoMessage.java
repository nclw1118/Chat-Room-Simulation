/*
 * NAME: Xue Wang
 * PID: A15908778
 */

/**
 * Description of Sample Class
 * PhotoMessage class extends Message Class
 * @author Xue Wang
 * @since 04/20/2020
 */

public class PhotoMessage extends Message {

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    // input validation criteria
    private static final String[] ACCEPTABLE_EXTENSIONS =
            new String[] {"jpg", "jpeg", "gif", "png", "tif"};

    // instance variable
    private String extension;
    /**
     * Description of constructor
     * constructor of the PhotoMessage class
     * @param sender the user object to initialize sender
     * @param photoSource the String object to initialize content
     * @throws OperationDeniedException when the input is not valid
     */
    public PhotoMessage(User sender, String photoSource)
                        throws OperationDeniedException {
        /* TODO : constructor of photoMessage class*/
        // must use super by extending an abstract class
        super(sender);
        // input validation
        if(photoSource==null){
            throw new IllegalArgumentException();
        }
        if(sender instanceof PremiumUser==false){
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        // separate the filename and extension
        int index = photoSource.lastIndexOf('.');
        String extent= photoSource.substring(index+1).toLowerCase();
        Boolean criteria = false;
        // loop through the acceptable extensions, check if the extension is acceptable
        for (int i=0; i<ACCEPTABLE_EXTENSIONS.length; i++){
            if( ACCEPTABLE_EXTENSIONS[i].equals(extent)){
                criteria=true;
                break;
            }
        }
        // if the extension is not acceptable, throw error
        if (criteria==false){
            throw  new OperationDeniedException(INVALID_INPUT);
        }
        // initiate the contents and extension
        contents=photoSource;
        extension= extent;
    }

    /**
     * Description of method
     * Method will return the contents of this message.
     * @return String of the contents of the class
     */
    public String getContents() {
        /* TODO :return the contents of this message. */
        return getSender().displayName()+" ["+ getDate()+"]: Picture at "+contents;
    }

    /**
     * Description of method
     * Method will return the extension of this message.
     * @return String of the extension of the class
     */
    public String getExtension() {
        /* TODO :return the extension of this message. */
        return extension;
    }

}
