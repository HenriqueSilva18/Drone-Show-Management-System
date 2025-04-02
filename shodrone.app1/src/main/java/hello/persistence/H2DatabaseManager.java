package hello.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2DatabaseManager {
    private static final String URL = "jdbc:h2:./database/shodrone-db";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void setupDatabase() {
        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS USERS (id INT PRIMARY KEY, name VARCHAR(255))";
            stmt.execute(sql);
            System.out.println("✅ Banco de dados H2 configurado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        setupDatabase();
    }
}