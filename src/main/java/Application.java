import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        String qeary = "Select*From employes where id=?";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(qeary)){
            statement.setInt(1, 31);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int city = resultSet.getInt("city_id");

                System.out.println(first_name + " " + last_name + " " + gender + " " + city);
            }

        }


    }

    private static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "Dovaziyliil1551.";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        return DriverManager.getConnection(url, user, password);

    }
}
