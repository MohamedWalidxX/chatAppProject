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

public class App {
    Connection con;
    Statement statement;
    PreparedStatement preQuery;
    ResultSet result;
    String query;

    /**
     * This class is the backend of the UI experience
     *
     * @throws SQLException
     */
    App() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatApp", "mohamed",
                "password");
        statement = con.createStatement();
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
     * Task for : Mohamed Yehia && bavley
     * checkGarbage functionality is to search for any data that it's existence is related to time or date
     * eg (all user stories) and delete it from database before the user open his UI
     */
    void checkGarbage(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Mamdouh && Sobhy.
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
    void openChat(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid && Mohamed Mamdouh
     * for the opened chat let him show the name of the group first then each group user
     * with his last chat opened date
     * Corner case: if the chat was private chat between only two persons then for each show the friend name if he was in his connection lsit
     * or show his number otherwise
     */
    void showChatInfo(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid && Mohamed Yehia && Bavley
     * after opening a chat expand all it's messages with its time
     * CORNER CASE : you have to split each day messages
     */
    void expandMessages(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Mamdouh && bavley
     * send message to the current opened chat
     */
    void sendMessage(/* Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid && Sobhy
     * UNDO your sent messages
     */
    void deleteMessage(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Mamdouh && Sobhy
     * close the current opened chat and go back to chat list
     */
    void closeChat(/*Your parameters here */) {

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
     * Task for : Mohamed Mamdouh   remove a user
     * EDIT : add blocked user to database contact mohamed walid
     */
    void blockUser(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Mamdouh && bavley
     * in the chat list you search for message by text keyword WITHOUT HINTS
     */
    void searchForMessage(/*Your parameters here */) {
    }

    /**
     * Task for : Mohamed Walid && bavley
     */
    void searchForConnectionByNumber() {

    }

    /**
     * Task for : Sobhy
     */
    void searchForConnectionByName() {

    }

    /**
     * Task for : Mohamed Walid && Mohamed Yehia
     * For a specific chat room search for a message
     */
    void searchForMessageHint(/*Your parameters here */) {

    }
}