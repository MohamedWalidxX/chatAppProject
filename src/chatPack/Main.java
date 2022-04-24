package chatPack;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws SQLException {
        App app = new App();
        User u= new User(12, "MohamedAhmed", "01014891962", "abcd", "hello", true);
        u.setCurrentChatId(3);
<<<<<<< HEAD
        app.searchForMessageHint(u.getCurrentChatId(), "VIETNAAAAAM");
=======
        app.addConnection("BO2loz", 15, 16);
>>>>>>> 4048c8b (Hashing-2)
    }
}
