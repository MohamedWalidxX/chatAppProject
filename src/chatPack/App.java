/**
 * IMPORTANT RULES FOR DEVELOPER :
 * 1. you have the right to change your assigned function components eg (inputs - return type - function body)
 * as long as it reaches the goal.
 * 2. you don't have the right to change your friend function components directly you have to ask him to change it by himself.
 * 3. you have to be careful when you use SQL statement that the data still
 * consistent eg (check the select syntax in the mysql ide first then copy it to INTELLIJ)
 */
package chatPack;

import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class App {
    Connection con;
    Statement statement;
    PreparedStatement preQuery;
    ResultSet result;
    String query;
    Enumeration<Integer>e;


    /**
     * This class is the backend of the UI experience
     *
     * @throws SQLException
     */
    App() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatApp", "mohamed",
                "password");
        Statement st = con.createStatement();
    }

    /**
     * Task for : Mohamed Walid
     * create new user account and check if it's already exists
     */
    void newUser(User user) throws SQLException {
        // call the userValidation function to validate the user data whether it exists or no
        // and save the return value
        int isValidOp = userDataValidation(user);
        if (isValidOp == 0) {
            query = "insert into user (username, password, phoneNumber) values (?,?,?)";
            preQuery = con.prepareStatement(query);
            preQuery.setString(1, user.getUsername());
            preQuery.setString(2, user.getPassword());
            preQuery.setString(3, user.getPhoneNumber());
            preQuery.executeUpdate();
            System.out.println("registration process is done.");
        } else if (isValidOp == 1)
            System.out.println("Username already exists.");
        else if (isValidOp == 2)
            System.out.println("Phone number already exists.");
    }

    /**
     * Task for : Mohamed Yehia
     * this function is taking a user information then compare it with the database to make the user login
     */
    void login(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid , a sub task from userDataValidation function to remove duplicate code
     *
     * @return
     * @throws SQLException
     */
    int countChecker() throws SQLException {
        result = preQuery.executeQuery();
        result.next();
        return result.getInt(1);
    }

    /**
     * Task For : Mohamed Walid
     * check if the data user has entered is valid for login or exists for registration process
     * e.g.(username, correct password, never exist phoneNumber while registering etc.)
     * the function will return a nonZero number which means that we find a data matches the user input
     * or return zero otherwise,,,
     * <p>
     * OPTIMIZATION : MAKE one function that takes the column name you want to check and return
     */
    int userDataValidation(User user) throws SQLException {
        // check every attribute if it exists or not in the database by count the number of elements that matches
        //  the user input and return a value for the caller function to decide

        //check  username if it exists by count function as if it was zero then it does not exist otherwise it exists
        query = "select count(username) from user where username = ?";
        preQuery = con.prepareStatement(query);
        preQuery.setString(1, user.getUsername());
        if (countChecker() == 1)
            return 1;

        //check phoneNumber same as above
        query = "select count(phoneNumber) from user where phoneNumber = ?";
        preQuery = con.prepareStatement(query);
        preQuery.setString(1, user.getPhoneNumber());
        if (countChecker() == 1)
            return 2;
        return 0;
    }

    /**
     * Task for: bavley,,,
     * add new connection to the user list
     */
    void addConnection() {

    }


    boolean searchForConnection(int currentUserId, int friendId) throws SQLException {
        query = "select count(*) from userconnection where userid = ? and friendid = ?";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, currentUserId);
        preQuery.setInt(2, friendId);
        result = preQuery.executeQuery();
        result.next();
        if (result.getInt(1) == 0) {
            System.out.println("not found!");
            return false;
        } else {
            System.out.println("Found!");
            return true;
        }
    }

    /**
     * Task for : Mohamed Walid
     * checkGarbage functionality is to search for any data that it's existence is related to time or date
     * eg (all user stories) and delete it from database before the user open his UI
     */
    void checkGarbage(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Yehia
     * For each user check his connection list and expand all his connections as a 2 members chat list
     * and for each chat the name of it and the last message was sent
     */
    void expandConnectionChats(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid && Mohamed Yehia
     * create a group of members with at least 3 initial members in it
     */
    void createGroup(/*Your parameters here */) {

    }

    /**
     * Task for : Mahmoud sobhy
     * select a specific chat room from user chat list and open it with all its information and all messages
     * don't forget to save the current opened chat room in the user class
     */
    void openChat(User u, int chatId) {
        u.setCurrentChatId(chatId);
    }

    /**
     * Task for : Mohamed Walid
     * for the opened chat let him show the name of the group first then each group user
     * with his last chat opened date
     * Corner case: if the chat was private chat between only two persons then for each show the friend name if he was in his connection lsit
     * or show his number otherwise
     */
    void showChatInfo(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid
     * after opening a chat expand all it's messages with its time
     * CORNER CASE : you have to split each day messages
     */
    void expandMessages(int chatId, int currentUserId) throws SQLException{
        // make a query to get all the messages of a specific chat from database with ascending order by date first then time
        query = "select senderId, messageText, date, time from message where chatId = ? order by date asc, time asc";
        //to make the pointer of resultSet go forward and backward in the dataSet we have to make this next line
        preQuery = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        preQuery.setInt(1,chatId);
        result = preQuery.executeQuery();
        System.out.println("____________________________________");
        while (result.next()){
            //detect a cycle
            boolean innerLoopCheckInfinity = false;
            //take the first message date so that the message could be printed with ascending order of date
            String testConstDate = result.getString(3);
            //for all messages have the same date print them all
            System.out.println("\t\t\t[[[" + testConstDate + "]]]\n\n");
            while (testConstDate.equals(result.getString(3))){
                innerLoopCheckInfinity = true;
                // the UI experience said that your message will be printed on the left half of the screen
                // and your friends will be on the right half
                if (result.getInt(1) == currentUserId)
                    System.out.println(returnUsername(currentUserId) + "\n" + result.getString(2) + "\n[" + result.getString(4) + "]\n");
                else
                    System.out.println("\t\t\t\t\t" + returnUsername(result.getInt(1)) + "\n\t\t\t\t\t" + result.getString(2) + "\n\t\t\t\t\t["
                    + result.getString(4) + "]\n");
                if (!result.next())
                    break;
            }
            System.out.println("____________________________________");
            // the previous inner while loop could make a cycle if it's condition was not true and the resultSet pointer will go back and forward
            //in the same data and check the condition
            if (innerLoopCheckInfinity)
                result.previous();
        }
    }

    /**
     * Task for : Mohamed Yehia
     * send message to the current opened chat
     */
    void sendMessage(/* Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid
     * UNDO your sent messages
     */
    void deleteMessage(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid
     * close the current opened chat and go back to chat list
     */
    void closeChat(User u) {
        u.setCurrentChatId(-1);
    }

    /**
     * Task for : Mohamed Yehia
     * the user choose a contact friend and add him to the opened chat room
     */
    void addUserToGroup(User user) throws SQLException {
        query = "insert into userJoinChat(userId,chatId) values(?,?);";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, user.getId());
        preQuery.setInt(2, user.getCurrentChatId());
        preQuery.executeUpdate();
        System.out.println("User han been added");

    }

    /**
     * Task for : Mohamed Walid
     * remove yourself or any user from the chat group
     */
    void removeUserFromGroup(User user) throws SQLException {
        query = "delete from userJoinChat where userId = ? and chatId = ?";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, user.getId());
        preQuery.setInt(2, user.getCurrentChatId());
        preQuery.executeUpdate();
        System.out.println("User han been deleted");
    }

    /**
     * Task for : Mohamed Yehia
     * EDIT : add blocked user to database contact mohamed walid
     */
    void blockUser(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Yehia using hash table
     * in the chat list you search for message by text keyword WITHOUT HINTS
     */
    void searchForMessage(int userId, String text) throws SQLException{
        query = "select chatId from userjoinchat where userId = ?";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, userId);
        result = preQuery.executeQuery();
        while (result.next()){
            searchForMessageHint(result.getInt(1), text);
        }
        System.out.println("\n\n");
        searchForConnectionByName(userId, text);
        searchForConnectionByNumber(userId, text);
    }

    /**
     * Task for : Mohamed Walid... using hash table
     */
    void searchForConnectionByNumber(int userId, String friendNumber) throws SQLException{
        System.out.println("user search by number: \n\n");
        query = "select * from userconnection where userId= ?";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, userId);
        result = preQuery.executeQuery();
        Hashtable<Integer, User> findUser = new Hashtable<Integer, User>();
        while (result.next()){
            query = "select id, username, phoneNumber, password, profileDesc, profileVisibility from user where id = ?";
            preQuery = con.prepareStatement(query);
            preQuery.setInt(1, result.getInt(2));
            ResultSet tmpResult = preQuery.executeQuery();
            tmpResult.next();
            findUser.put(result.getInt(1), new User(tmpResult.getInt(1), result.getString(3), tmpResult.getString(3), tmpResult.getString(4),
                    tmpResult.getString(5), tmpResult.getBoolean(6)));
        }
        Enumeration<Integer> e = findUser.keys();
        ArrayList<Integer> keySave = new ArrayList<Integer>();
        while (e.hasMoreElements())
            keySave.add(e.nextElement());

        for (int i = keySave.size() - 1; i >= 0; i--) {
            // retrieve the value of specific hashmap key
            User friend = findUser.get(keySave.get(i));
            //if the user text matches ours print the full message with its data
            if (friend.getPhoneNumber().contains(friendNumber)) {
                System.out.println(friend.getUsername() + "\n\n");
            }
        }
    }

    /**
     * Task for : Mohamed Walid
     */
    void searchForConnectionByName(int userId, String friendName) throws SQLException{
        System.out.println("user search by name: \n\n");
        query = "select * from userconnection where userId= ?";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, userId);
        result = preQuery.executeQuery();
        Hashtable<Integer, User> findUser = new Hashtable<Integer, User>();
        while (result.next()){
            query = "select id, username, phoneNumber, password, profileDesc, profileVisibility from user where id = ?";
            preQuery = con.prepareStatement(query);
            preQuery.setInt(1, result.getInt(2));
            ResultSet tmpResult = preQuery.executeQuery();
            tmpResult.next();
            findUser.put(result.getInt(1), new User(tmpResult.getInt(1), result.getString(3), tmpResult.getString(3), tmpResult.getString(4),
                    tmpResult.getString(5), tmpResult.getBoolean(6)));
        }
        Enumeration<Integer> e = findUser.keys();
        ArrayList<Integer> keySave = new ArrayList<Integer>();
        while (e.hasMoreElements())
            keySave.add(e.nextElement());

        for (int i = keySave.size() - 1; i >= 0; i--) {
            // retrieve the value of specific hashmap key
            User friend = findUser.get(keySave.get(i));
            //if the user text matches ours print the full message with its data
            if (friend.getUsername().contains(friendName)) {
                System.out.println(friend.getUsername() + "\n\n");
            }
        }
    }

    /**
     * return username from user id
     * @param id
     * @return
     */
    String returnUsername(int id) throws SQLException{
        String query = "select username from user where id = ?";
        PreparedStatement preQuery = con.prepareStatement(query);
        preQuery.setInt(1,id);
        ResultSet result = preQuery.executeQuery();
        result.next();
        return result.getString(1);
    }
    /**
     * Task for : Mohamed Walid
     * given a specific chat room search for a message using hash table
     */
    void searchForMessageHint(int currentChatRoomId, String text) throws SQLException {
        query = "select * from message where chatId = ? ";
        preQuery = con.prepareStatement(query);
        preQuery.setInt(1, currentChatRoomId);
        result = preQuery.executeQuery();
        //Hashtable to map every message with its id
        Hashtable<Integer, Message> findStr = new Hashtable<Integer, Message>();
        while (result.next()) {
            // insert into hashtable
            findStr.put(result.getInt(1), new Message(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4),
                    result.getString(5), result.getString(6), result.getBoolean(7)));
        }
        // to iterate over the hashmap we need to save all the keys in  Enumeration object
        Enumeration<Integer> e = findStr.keys();
        ArrayList<Integer> keySave = new ArrayList<Integer>();
        while (e.hasMoreElements())
            keySave.add(e.nextElement());
        //the enumeration gives a reversed order of your hashmap key
        // you have to reverse it again as the order matters in printing
        for (int i = keySave.size() - 1; i >= 0; i--) {
            // retrieve the value of specific hashmap key
            Message finalMessage = findStr.get(keySave.get(i));
            //if the user text matches ours print the full message with its data
            if (finalMessage.getMessageText().contains(text)) {
                System.out.println(returnUsername(finalMessage.getSenderId()) + "\n" + finalMessage.getMessageText() + "\n" +
                        finalMessage.getDate() + " | " + finalMessage.getTime() + "\n\n");
            }
        }
    }
}