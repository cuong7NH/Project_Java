package src.dao;

import src.connection.ConnectionFactory;
import src.model.Engineer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EngineerDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public EngineerDao() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<Engineer> getEngineerList() {
        ArrayList<Engineer> engineerList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_engineer";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Engineer engineer = new Engineer(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("coefficients_salary"),
                        resultSet.getInt("work_day"),
                        resultSet.getInt("home_town_id"),
                        resultSet.getInt("years_of_experience")
                );
                engineerList.add(engineer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return engineerList;
    }

    public boolean addEngineer(Engineer engineer) {
        System.out.println("engineer" + engineer.toString());
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_engineer(id, name, age, gender, address, phone, coefficients_salary, work_day, years_of_experience, home_town_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, engineer.getId());
            ptmt.setString(2, engineer.getName());
            ptmt.setInt(3, engineer.getAge());
            ptmt.setInt(4, engineer.getGender());
            ptmt.setString(5, engineer.getAddress());
            ptmt.setString(6, engineer.getPhone());
            ptmt.setInt(7, engineer.getCoefficientsSalary());
            ptmt.setInt(8, engineer.getWorkDay());
            ptmt.setInt(9, engineer.getYearsOfExperience());
            ptmt.setInt(10, engineer.getHomeTownId());
            ptmt.executeUpdate();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public boolean editEngineer(Engineer engineer) {
        boolean success = false;
        try {
            String sql = "UPDATE tbl_engineer SET name = ?, age = ?, gender = ?, address = ?, phone = ?, coefficients_salary = ?, work_day = ?, years_of_experience = ?, home_town_id = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, engineer.getName());
            ptmt.setInt(2, engineer.getAge());
            ptmt.setInt(3, engineer.getGender());
            ptmt.setString(4, engineer.getAddress());
            ptmt.setString(5, engineer.getPhone());
            ptmt.setInt(6, engineer.getCoefficientsSalary());
            ptmt.setInt(7, engineer.getWorkDay());
            ptmt.setInt(8, engineer.getYearsOfExperience());
            ptmt.setInt(9, engineer.getHomeTownId());
            ptmt.setString(10, engineer.getId());
            ptmt.executeUpdate();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public boolean deleteEngineer(String id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_engineer WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, id);
            ptmt.executeUpdate();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return success;
    }
    public String getNewEngineerId() {
        String lastId = "KS1";
        String sql = "SELECT * FROM tbl_engineer ORDER BY Id DESC LIMIT 1";
        try {
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                lastId = resultSet.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(lastId.length() <=2) {
            return "KS1";
        }
        int lastIdNumber = Integer.parseInt(lastId.substring(2));
        return "KS" + (lastIdNumber + 1);
    }
}
