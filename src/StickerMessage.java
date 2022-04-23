/*
 * NAME: Xue Wang
 * PID: A15908778
 */

/**
 * Description of Sample Class
 * StickerMessage class extends Message Class
 * @author Xue Wang
 * @since 04/20/2020
 */

public class StickerMessage extends Message {

    // instance variable
    private String packName;
    /**
     * Description of constructor
     * constructor of the StickerMessage class
     * @param sender user object to initiate the sender
     * @param stickerSource string object to initiate the packname and content
     * @throws OperationDeniedException when the sender is not an instance of Premium user
     * @throws IllegalArgumentException when the stickerSource is null
     */
    public StickerMessage(User sender, String stickerSource)
            throws OperationDeniedException {
        super(sender);
        /* TODO : constructor of the StickerMessage class */
        // input validation check, throw exception if the standard is not met
        if(! (sender instanceof PremiumUser)){
            throw new OperationDeniedException(DENIED_USER_GROUP);
        }
        if(stickerSource==null) {
            throw new IllegalArgumentException();
        }
        // separate the packname and contents from the stickerSource
        int index = stickerSource.lastIndexOf('/');
        String sticker=stickerSource.substring(index+1);
        String name=stickerSource.substring(0,index);
        // initiate the packname and contents
        packName=name;
        contents=sticker;
    }

    /**
     * Description of method
     * Returns a String in the form:
     * “SenderName [2019-10-29]: Sticker [Questioning] from Pack [yourcraft-8]”
     * @return String of the content in a special form
     */
    public String getContents() {
        /* TODO : return the content in a special form */
        // return the content in a special form
        return getSender().displayName()+" ["+ getDate().toString()
                +"]: Sticker [" + contents+"] from Pack ["+ packName+"]";
    }
    /**
     * Description of method
     * Returns the packname of the package
     * @return String, the pack name of the package
     */
    public String getPackName() {
        /* TODO: return the packname of the package */
        return packName;
    }
}
