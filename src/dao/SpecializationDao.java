package src.dao;

import src.connection.ConnectionFactory;
import src.model.Specialization;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpecializationDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public SpecializationDao() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<Specialization> getSpecializationList() {
        ArrayList<Specialization> specializationList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_specialization";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Specialization specialization = new Specialization(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                specializationList.add(specialization);
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
        return specializationList;
    }

    public boolean addSpecialization(Specialization specialization) {
        System.out.println("add");
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_specialization(name) VALUES(?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, specialization.getName());
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

    public boolean editSpecialization(Specialization specialization) {
        boolean success = false;
        try {
            String sql = "UPDATE tbl_specialization SET name = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, specialization.getName());
            ptmt.setInt(2, specialization.getId());
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

    public boolean deleteSpecialization(Integer id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_specialization WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setInt(1, id);
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

    public boolean checkSpecialization(Integer id) {
        SpecializationDao specializationDao = new SpecializationDao();
        Specialization specialization =  specializationDao.getSpecializationList().stream()
                .filter(o -> id.equals(o.getId()))
                .findAny()
                .orElse(null);
        return specialization != null;
    }
}
