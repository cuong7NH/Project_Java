package src.dao;

import jdk.dynalink.linker.support.Guards;
import src.connection.ConnectionFactory;
import src.model.Guard;
import src.model.WorkPlace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuardDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public GuardDao() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<Guard> getGuardList() {
        ArrayList<Guard> guardList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_guard";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Guard guard = new Guard(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("coefficients_salary"),
                        resultSet.getInt("work_day"),
                        resultSet.getInt("work_place_id"),
                        resultSet.getInt("home_town_id")
                );
                guardList.add(guard);
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
        return guardList;
    }

    public boolean addGuard(Guard guard) {
        System.out.println("guard" + guard.toString());
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_guard(id, name, age, gender, address, phone, coefficients_salary, work_day, work_place_id, home_town_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, guard.getId());
            ptmt.setString(2, guard.getName());
            ptmt.setInt(3, guard.getAge());
            ptmt.setInt(4, guard.getGender());
            ptmt.setString(5, guard.getAddress());
            ptmt.setString(6, guard.getPhone());
            ptmt.setInt(7, guard.getCoefficientsSalary());
            ptmt.setInt(8, guard.getWorkDay());
            ptmt.setInt(9, guard.getWorkPlaceId());
            ptmt.setInt(10, guard.getHomeTownId());
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

    public boolean editGuard(Guard guard) {
        boolean success = false;
        try {
            String sql = "UPDATE tbl_guard SET name = ?, age = ?, gender = ?, address = ?, phone = ?, coefficients_salary = ?, work_day = ?, work_place_id = ?, home_town_id = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, guard.getName());
            ptmt.setInt(2, guard.getAge());
            ptmt.setInt(3, guard.getGender());
            ptmt.setString(4, guard.getAddress());
            ptmt.setString(5, guard.getPhone());
            ptmt.setInt(6, guard.getCoefficientsSalary());
            ptmt.setInt(7, guard.getWorkDay());
            ptmt.setInt(8, guard.getWorkPlaceId());
            ptmt.setInt(9, guard.getHomeTownId());
            ptmt.setString(10, guard.getId());
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

    public boolean deleteGuard(String id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_guard WHERE id = ?";
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
    public String getNewGuardId() {
        String lastId = "BV1";
        String sql = "SELECT * FROM tbl_guard ORDER BY Id DESC LIMIT 1";
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
            return "BV1";
        }
        int lastIdNumber = Integer.parseInt(lastId.substring(2));
        return "BV" + (lastIdNumber + 1);
    }

    public boolean checkGuard(String id) {
        GuardDao guardDao = new GuardDao();
        Guard guard =  guardDao.getGuardList().stream()
                .filter(o -> id.equals(o.getId()))
                .findAny()
                .orElse(null);
        return guard != null;
    }
}

