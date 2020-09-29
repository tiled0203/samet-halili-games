package repositories;

import domain.Borrower;
import domain.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BorrowerJDBCRepository {
    private static final BorrowerJDBCRepository instance = new BorrowerJDBCRepository();

    public static BorrowerJDBCRepository getInstance() {
        return instance;
    }

    public List<Borrower> findAll() {
        ArrayList<Borrower> borrowers = new ArrayList<>();
        try(PreparedStatement preparedStatement = DbLogin.createConnection()
                .prepareStatement("SELECT b.id, b.borrower_name, b.street, b.house_number, b.bus_number, " +
                        "b.postcode, b.city, b.telephone, b.email from borrower as b")){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while(resultSet.next()) {
                borrowers.add(buildFromSet(resultSet));
            }
            return borrowers;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Borrower findById(int id) {
        try(PreparedStatement preparedStatement = DbLogin.createConnection()
                .prepareStatement("SELECT b.id, b.borrower_name, b.street, b.house_number, b.bus_number, " +
                        "b.postcode, b.city, b.telephone, b.email from borrower as b WHERE b.id = ?")){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return buildFromSet(resultSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Borrower buildFromSet(ResultSet resultSet) {
        try {
            return new Borrower.Builder()
                    .withId(resultSet.getInt("id"))
                    .withBorrowerName(resultSet.getString("borrower_name"))
                    .withStreet(resultSet.getString("street"))
                    .withHouseNumber(resultSet.getString("house_number"))
                    .withBusNumber(resultSet.getString("bus_number"))
                    .withPostCode(resultSet.getInt("postcode"))
                    .withCity(resultSet.getString("city"))
                    .withTelephone(resultSet.getString("telephone"))
                    .withEmail(resultSet.getString("email"))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
