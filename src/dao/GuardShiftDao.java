package src.dao;

import src.connection.ConnectionFactory;
import src.model.GuardShift;
import src.model.WorkPlace;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuardShiftDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public GuardShiftDao() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<GuardShift> getGuardShiftList() {
        ArrayList<GuardShift> guardShiftList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_quard_shift";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                GuardShift guardShift = new GuardShift(
                        resultSet.getString("guard_id"),
                        resultSet.getInt("shift_id")
                );
                guardShiftList.add(guardShift);
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
        return guardShiftList;
    }

    public boolean addGuardShift(GuardShift guardShift) {
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_quard_shift(guard_id, shift_id) VALUES(?, ?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, guardShift.getGuardId());
            ptmt.setInt(2, guardShift.getShiftId());
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

    public boolean deleteGuardShift(String guard_id, Integer shift_id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_quard_shift WHERE guard_id = ? AND shift_id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, guard_id);
            ptmt.setInt(2, shift_id);
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

}
