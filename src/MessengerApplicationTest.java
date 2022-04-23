/*
  Name: Your Name
  PID:  A12345678
 */


import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Messenger Application Test
 * @author Xue Wang
 * @since  04/06/2020
 */
public class MessengerApplicationTest {

    /*
      Messages defined in starter code. Remember to copy and paste these strings to the
      test file if you cannot directly access them. DO NOT change the original declaration
      to public.
     */
    private static final String INVALID_INPUT =
            "The source path given cannot be parsed as photo.";

    /*
      Global test variables. Initialize them in @Before method.
     */
    PremiumUser marina;
    MessageExchange room;
    TextMessage t1;
    TextMessage t2;
    TextMessage t3;
    TextMessage t4;
    StickerMessage s1;
    StickerMessage s2;
    StickerMessage s3;
    StickerMessage s4;
    PhotoMessage p1;
    PhotoMessage p2;
    PhotoMessage p3;
    PhotoMessage p4;
    PremiumUser prem1;
    StandardUser standard;
    StandardUser standard1;
    StandardUser standard2;
    StandardUser standard3;
    StandardUser standard4;
    ChatRoom chat;
    PremiumUser prem2;
    PremiumUser prem;
    ChatRoom chat2;
    PhotoRoom photo;

    /*
      The date used in Message and its subclasses. You can directly
      call this in your test methods.
     */
    LocalDate date = LocalDate.now();

    @Before
    public void setup() {
        marina = new PremiumUser("Marina", "Instructor");
        room = new ChatRoom();
        prem1= new PremiumUser("Nicole","beautiful");
        standard= new StandardUser("Xue","pretty");
        chat2= new ChatRoom();
        standard1= new StandardUser("nicole","hi");
        standard2= new StandardUser("Jack","police");
        photo= new PhotoRoom();
    }

    /*
      Recap: Assert exception without message
     */
    @Test (expected = IllegalArgumentException.class)
    public void testPremiumUserThrowsIAE() {
        marina = new PremiumUser("Marina", null);
    }

    /*
      Assert exception with message
     */
    @Test
    public void testPhotoMessageThrowsODE() {
        try {
            PhotoMessage pm = new PhotoMessage(marina, "PA02.zip");
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_INPUT, ode.getMessage());
        }
    }

    /*
      TODO: Add your tests
     */

    @Test
    public void testGetContentAndNormalConstructor() {
        try {
            t1 = new TextMessage(standard1, "hi");
        } catch (OperationDeniedException error) {
        }
        assertEquals("nicole [2020-04-20]: hi",t1.getContents());
    }
    @Test
    public void testNormalConstructor2(){
        try{
           t2 = new TextMessage(standard1, "pretty");
        }catch(OperationDeniedException e){
            System.out.println("error");
        }
        assertEquals("nicole [2020-04-20]: pretty",t2.getContents());
    }

    @Test
    public void testNormalConstructor3() {
        try {
            t2 = new TextMessage(prem1, "sohard");
        } catch (OperationDeniedException e) {
            System.out.println("error");
        }
        assertEquals("<Premium> Nicole [2020-04-20]: sohard", t2.getContents());
    }

    @Test
    public void testDisplayName() {
        try {
            t1 = new TextMessage(standard1, "hi");
        } catch (OperationDeniedException error) {
        }
        assertEquals(t1.getSender().displayName(),"nicole");
    }

    @Test
    public void testConstructor1(){
        try{
            t1 = new TextMessage(standard1, new String(new char[1111]));
        }catch (OperationDeniedException error){
            System.out.println(error.getMessage());
            assertEquals(error.getMessage(),"Your input exceeded the maximum length limit.");
        };
    }

    @Test
    public void testConstructor2(){
        try {
            t2 = new TextMessage(standard1, null);
        }
        catch( OperationDeniedException e1){
        }
        catch(IllegalArgumentException e2){
            assertEquals(null, e2.getMessage());
        }
    }

    @Test
    public void testNormalConstructor4() {
        try{
            p1= new PhotoMessage(prem1, "sohard.gif");
        } catch (OperationDeniedException e) {
            System.out.println("error");
        }
        assertEquals("<Premium> Nicole [2020-04-20]: Picture at sohard.gif", p1.getContents());
        assertEquals("gif", p1.getExtension());
    }

    @Test
    public void testNormalConstructor5() {
        try{
            p2= new PhotoMessage(prem1, "hiworld.gif");
        } catch (OperationDeniedException e) {
            System.out.println("error");
        }
        assertEquals("<Premium> Nicole [2020-04-20]: Picture at hiworld.gif", p2.getContents());
        assertEquals("gif", p2.getExtension());
    }

    @Test
    public void testConstructor3(){
        try{
            p1 = new PhotoMessage(prem1,null);
        }catch (OperationDeniedException e1){
        }
        catch(IllegalArgumentException e2){
            assertEquals(null, e2.getMessage());
        }
    }

    @Test
    public void testConstrutor4(){
        try{
            p2 = new PhotoMessage(prem1,"hihihi");
        }
        catch(OperationDeniedException e){
            assertEquals("The source path given cannot be parsed as photo.", e.getMessage());
        }
    }

    @Test
    public void testConstructor5(){
        try{
            p3 = new PhotoMessage(standard1,"hi.gif");
        }
        catch (OperationDeniedException e) {
            assertEquals("This operation is disabled in your user group.", e.getMessage());
        }
    }

    @Test
    public void testConstructorandGetContentsandGetExtension(){
        try{
            p3 = new PhotoMessage(prem1,"hi.gif");
        }
        catch (OperationDeniedException e){
            System.out.println("error occured");
        }
        assertEquals(p3.getContents(),"<Premium> Nicole [2020-04-20]: Picture at hi.gif");
        assertEquals(p3.getExtension(), "gif");

    }

    @Test
    public void testNormalConstructor6() {
        try{
            s1= new StickerMessage(prem1, "Nicole/pretty");
        } catch (OperationDeniedException e) {
            System.out.println("error");
        }
        assertEquals(s1.getContents(),"<Premium> Nicole [2020-04-20]: Sticker [pretty] from Pack [Nicole]");
        assertEquals(s1.getPackName(),"Nicole");
    }

    @Test
    public void testNormalConstructor7() {
        try{
            s1= new StickerMessage(prem1, "happy/day");
        } catch (OperationDeniedException e) {
            System.out.println("error");
        }
        assertEquals(s1.getContents(),"<Premium> Nicole [2020-04-20]: Sticker [day] from Pack [happy]");
        assertEquals(s1.getPackName(),"happy");
    }

    @Test
    public void testConstructor6(){
        try {
            s1 = new StickerMessage(prem1, null);
        }
        catch(OperationDeniedException e1){
        }
        catch(IllegalArgumentException e2){
            assertEquals(null, e2.getMessage());
        }
    }
    @Test
    public void testConstructor7(){
        try{
            s2= new StickerMessage(standard1, "name1/name2");
        }
        catch (OperationDeniedException e){
            assertEquals("This operation is disabled in your user group.", e.getMessage());
        }
    }

    @Test
    public void testConstructorAndGetContentsAndGetPackName(){
        try{
            s3= new StickerMessage(prem1, "name1/name2");
        }
        catch (OperationDeniedException e){
            System.out.println("error occured");
        }
        assertEquals("<Premium> Nicole [2020-04-20]: Sticker [name2] from Pack [name1]",s3.getContents());
        assertEquals("name1",s3.getPackName());
    }

    @Test
    public  void testStandard(){
        standard1 = new StandardUser("Nicole","prettygirl");
        standard1.setBio("pretty");
        assertEquals(standard1.displayBio(),"pretty");
        assertEquals(standard1.displayName(),"Nicole");
        chat=new ChatRoom();
        try{
            standard1.joinRoom(chat);
        }
        catch(OperationDeniedException e){
        }
        ArrayList<User> result = new ArrayList<User>();
        result.add(standard1);
        assertEquals(chat.getUsers(), result);
        standard1.quitRoom(chat);
        assertEquals(standard1.rooms, new ArrayList<MessageExchange>());
        ArrayList<User> users = new ArrayList<User>();
        standard2=new StandardUser("Alice","beautiful");
        standard3=new StandardUser("Jessy","elegant");
        standard4=new StandardUser("Cain","ugly");
        users.add(standard3);
        users.add(standard2);
        users.add(standard4);
        ArrayList<User> out=standard1.createChatRoom(users).getUsers();
        MessageExchange c= standard1.createChatRoom(users);
        assertEquals(4, out.size());
        standard1.sendMessage(c,1000, "Hi everyone");
        standard2.sendMessage(c,1000, "Hi ");
        standard3.sendMessage(c,1000, "good night");
        standard4.sendMessage(c,1000, "bye");
        assertEquals(c.getLog().size(),4);
        String out2=standard1.fetchMessage(c);
        assertEquals(out2, "");
        assertEquals(standard1.displayBio(),"pretty");
    }

    @Test
    public void testPremiumandPhotoRoom(){
        prem1= new PremiumUser("Nicole","pretty");
        assertEquals(prem1.displayName(), "<Premium> Nicole");
        prem1.setCustomTitle("fairy");
        assertEquals(prem1.displayName(),"<fairy> Nicole");
        prem2=new PremiumUser("xue","hothothot");
        ArrayList<User> user= new ArrayList<User>();
        user.add(prem2);
        System.out.println(user.size());
        assertEquals(prem1.createPhotoRoom(user).getUsers().size(), 2);
        MessageExchange room= prem1.createPhotoRoom(user);
        prem1.sendMessage(room,1001, "Nicole.jpg");
        assertEquals(room.getLog().size(),1);
        room.removeUser(prem2);
        assertEquals(room.getUsers().size(),1);
        room.addUser(prem2);
        assertEquals(room.getUsers().size(),2);
        assertEquals(prem1.fetchMessage(room),"<fairy> Nicole [2020-04-20]: Picture at Nicole.jpg\n");
    }

    @Test(expected = IllegalArgumentException.class)
    public  void testConstructor(){
        standard1=new StandardUser(null,"hi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor8(){
        standard1=new StandardUser("hi",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBio(){
        standard1= new StandardUser("nicole","hi");
        standard1.setBio(null);
    }

    @Test
    public void testSetBio2(){
        standard1= new StandardUser("nicole","hi");
        standard1.setBio("pretty");
        assertEquals(standard1.displayBio(),"pretty");
    }

    @Test
    public void testSteBio3(){
        standard1= new StandardUser("nicole","hi");
        standard1.setBio("beautiful");
        assertEquals(standard1.displayBio(),"beautiful");
    }

    @Test
    public void testJoinRoom(){
        standard1= new StandardUser("nicole","hi");
        try{
            standard1.joinRoom(chat2);
            standard1.joinRoom(chat2);
        }
        catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinRoom2(){
        standard1= new StandardUser("nicole","hi");
        try{
            standard1.joinRoom(null);
        }
        catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testJoinRoom3(){
        standard1= new StandardUser("nicole","hi");
        try{
            standard1.joinRoom(chat2);
        }
        catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        assertEquals(chat2.getUsers().size(),1);
    }

    @Test
    public void testJoinRoom4(){
        standard1= new StandardUser("nicole","hi");
        standard2= new StandardUser("Jack","police");
        try{
            standard1.joinRoom(chat2);
            standard2.joinRoom(chat2);
        }
        catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        assertEquals(chat2.getUsers().size(),2);
    }
    @Test
    public void testJoinRoom5(){
        standard1= new StandardUser("nicole","hi");
        standard2= new StandardUser("Jack","police");
        try{
            standard1.joinRoom(chat2);
            standard2.joinRoom(chat2);
            standard.joinRoom(chat2);
        }
        catch (OperationDeniedException e){
            System.out.println(e.getMessage());
        }
        assertEquals(chat2.getUsers().size(),3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuit(){
        standard.quitRoom(null);
    }

    @Test
    public void testQuit2(){
        try{
            standard.joinRoom(chat2);
            standard.quitRoom(chat2);
        }
        catch(OperationDeniedException e){
        }
        assertEquals(chat2.getUsers().size(),0);
    }

    @Test
    public void testQuit3(){
        try{
            standard.joinRoom(chat2);
            standard1.joinRoom(chat2);
            standard.quitRoom(chat2);
        }
        catch(OperationDeniedException e){
        }
        assertEquals(chat2.getUsers().size(),1);
    }

    @Test
    public void testQuit4(){
        standard.quitRoom(chat2);
        assertEquals(chat2.getUsers().size(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateChat(){
        standard.createChatRoom(null);
    }

    @Test
    public void testCreateChat2(){
        ArrayList<User> users= new ArrayList<User>();
        users.add(standard1);
        users.add(standard2);
        MessageExchange me= standard.createChatRoom(users);
        assertEquals(3,me.getUsers().size());
    }
    @Test
    public void testCreateChat3(){
        ArrayList<User> users= new ArrayList<User>();
        MessageExchange me= standard.createChatRoom(users);
        assertEquals(1,me.getUsers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendMessage(){
        standard.sendMessage(chat2,1000,"hi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendMessage2(){
        try{
            standard.joinRoom(chat2);
            standard.sendMessage(chat2,2000,"hi");
        }
        catch (OperationDeniedException e){

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendMessage3(){
        try{
            standard.joinRoom(chat2);
            standard.sendMessage(null,1000,"hi");
        }
        catch(OperationDeniedException e){
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendMessage4(){
        try{
            standard.joinRoom(chat2);
            standard.sendMessage(chat2,1000,null);
        }
        catch(OperationDeniedException e){
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendMessage5(){
        try{
            t4=new TextMessage(standard,"hi");
            standard.joinRoom(photo);
            standard.sendMessage(photo,1001,"hi.jpg");
        }
        catch(OperationDeniedException e){
        }
        assertEquals(photo.recordMessage(t4),false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fetchMessage(){
        standard.fetchMessage(null);
    }

    @Test
    public void fetchMessage2(){
        try{
            standard.joinRoom(chat2);
            for(int i =0; i<12; i++){
                standard.sendMessage(chat2,1000,"hi");
            }
        }
        catch (OperationDeniedException e){

        }
        assertEquals(standard.fetchMessage(chat2),"Xue [2020-04-20]: hi\n");
        assertEquals(chat2.getLog().size(), 12);
    }

    @Test
    public void fetchMessage3(){
        try{
            standard.joinRoom(chat2);
            for(int i =0; i<12; i++){
                standard.sendMessage(chat2,1000,"hi");
            }
            prem1.joinRoom(chat2);
            prem1.sendMessage(chat2, 1001, "hi.jpg");
        }
        catch (OperationDeniedException e){

        }
        assertEquals(standard.fetchMessage(chat2),"This message cannot be " +
                "fetched because you are not a premium user.\n");
        assertEquals(13,chat2.getLog().size());
    }

    @Test
    public void testdisplayName(){
        assertEquals(standard.displayName(),"Xue");
        assertEquals(standard1.displayName(),"nicole");
        assertEquals(standard2.displayName(),"Jack");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFetchPrem(){
        prem1.fetchMessage(null);
    }

    @Test
    public void testFetchPrem2(){
        try{
            prem1.joinRoom(chat2);
            prem1.sendMessage(chat2, 1000, "hi");
            prem1.sendMessage(chat2,1000,"how are you");
        }
        catch (OperationDeniedException e){

        }
        assertEquals("<Premium> Nicole [2020-04-20]: hi\n<Premium> " +
                "Nicole [2020-04-20]: how are you\n", prem1.fetchMessage(chat2));
        assertEquals(2,chat2.getLog().size());

    }
    @Test
    public void testFetchPrem3(){
        try{
            prem1.joinRoom(photo);
            prem1.sendMessage(photo, 1001,"hi.jpg");
        }
        catch (OperationDeniedException e){
        }
        assertEquals("<Premium> Nicole [2020-04-20]: " +
                "Picture at hi.jpg\n", prem1.fetchMessage(photo));
        assertEquals(1,photo.getLog().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePhoto(){
        prem1.createPhotoRoom(null);
    }

    @Test
    public void testCreatePhoto2(){
        ArrayList<User> users= new ArrayList<User>();
        users.add(standard2);
        users.add(standard);
        assertEquals(prem1.createPhotoRoom(users).getUsers().size(),1);
    }

    @Test
    public void testCreatePhoto3(){
        prem=new PremiumUser("nicole","student");
        ArrayList<User> users= new ArrayList<User>();
        users.add(prem);
        assertEquals(prem1.createPhotoRoom(users).getUsers().size(),2);
    }

    @Test
    public void testSetTitle(){
        prem1.setCustomTitle("hi");
        assertEquals(prem1.displayName(),"<hi> Nicole");
        prem1.setCustomTitle("girl");
        assertEquals(prem1.displayName(),"<girl> Nicole");
    }

    @Test
    public void testRemove(){
        photo.addUser(prem1);
        assertEquals(1,photo.getUsers().size());
        photo.removeUser(prem1);
        assertEquals(0,photo.getUsers().size());
    }






}
