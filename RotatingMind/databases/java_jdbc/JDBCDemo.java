import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    private static List<Book> retrieveBooks(){
        PreparedStatement statement = null;
        Connection conn = null;
        List<Book> books = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jpa", "****","****");
            statement =  conn.prepareStatement("select * from book where publisher_id = ?");
            statement.setInt(1, 3);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return books;
    }

    public static void main(String...args){
        retrieveBooks().stream().forEach(System.out::print);
    }


}
