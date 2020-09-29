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
        try(PreparedStatement preparedStatement = DbLogin.createConnection().prepareStatement("SELECT c.id, c.category_name from category as c")){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                categories.add(buildFromSet(resultSet).build());
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
        try(PreparedStatement preparedStatement = DbLogin.createConnection()
                .prepareStatement("SELECT c.id, c.category_name from category as c WHERE c.id = ?")){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return buildFromSet(resultSet).build();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Category.Builder buildFromSet(ResultSet resultSet) {
        try {
            return new Category.Builder()
                    .withId(resultSet.getInt("id"))
                    .withCategoryName(resultSet.getString("category_name"));
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
