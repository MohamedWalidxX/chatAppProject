/**
 * IMPORTANT RULES FOR DEVELOPER :
 *      1. you have the right to change your assigned function components eg (inputs - return type - function body)
 *      as long as it reaches the goal.
 *      2. you don't have the right to change your friend function components directly you have to ask him to change it by himself.
 *      3. you have to be careful when you use SQL statement that the data still
 *      consistent eg (check the select syntax in the mysql ide first then copy it to INTELLIJ)
 */
package chatPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {
    PreparedStatement
    /**
     * This class is the backend of the UI experience
     *
     * @throws SQLException
     */
    App() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatApp", "mohamed",
                "password");
    }

    /**
     * Task for : Mohamed Walid
     * create new user account and check if it's already exists
     */
    void newUser(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Yehia
     * this function is taking a user information then compare it with the database to make the user login
     */
    void login(/*Your parameters here */) {

    }

    /**
     * Task For : Mohamed Walid
     * check if the data that user has entered is valid or exists
     * (username, correct password, never exist phoneNumber while registering etc.)
     * the function will return true if it exists
     * false otherwise
     */
    boolean userDataValidation(/*Your parameters here */) {

        return false;
    }

    /**
     * add new connection to the user list
     */
    void addConnection(){

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
    void addUserToGroup(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Walid
     * remove yourself or any user from the chat group
     */
    void removeUserFromGroup(/*Your parameters here */) {

    }

    /**
     * Task for : Mohamed Mamdouh   remove a user
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
