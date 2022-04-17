package chatPack;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws SQLException {
        App app = new App();
        User u = new User(1,"Mezo", "0110110123", "Momom", null, true);
        app.newUser(u);
    }
}
