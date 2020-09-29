package repositories;

import domain.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryJDBCRepository  {
    private static final CategoryJDBCRepository instance = new CategoryJDBCRepository();

    public static CategoryJDBCRepository getInstance() {
        return instance;
    }

    public List<Category> findAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try(PreparedStatement preparedStatement = createConnection().prepareStatement("SELECT c.id, c.category_name from category as c")){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Category.Builder category = new Category.Builder()
                        .withId(resultSet.getInt("id"))
                        .withCategoryName(resultSet.getString("category_name"));
                categories.add(category.build());
            }
            return categories;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Category findById(int id) {
        ArrayList<Category> categories = new ArrayList<>();
        try(PreparedStatement preparedStatement = createConnection()
                .prepareStatement("SELECT c.id, c.category_name from category as c WHERE c.id = ?")){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            Category.Builder category = new Category.Builder()
                    .withId(resultSet.getInt("id"))
                    .withCategoryName(resultSet.getString("category_name"));
            return category.build();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DbLogin.url
                , DbLogin.username
                , DbLogin.password);
    }
}
