package chatPack;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws SQLException {
        App app = new App();
        app.expandConnectionChats(1);

    }
}
