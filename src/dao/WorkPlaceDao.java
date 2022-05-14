package src.dao;

import src.connection.ConnectionFactory;
import src.model.WorkPlace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkPlaceDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public WorkPlaceDao() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<WorkPlace> getWorkPlaceList() {
        ArrayList<WorkPlace> workPlaceList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_work_place";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                WorkPlace workPlace = new WorkPlace(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                workPlaceList.add(workPlace);
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
        return workPlaceList;
    }

    public boolean addWorkPlace(WorkPlace workPlace) {
        System.out.println("add");
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_work_place(name) VALUES(?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, workPlace.getName());
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

    public boolean editWorkPlace(WorkPlace workPlace) {
        boolean success = false;
        try {
            String sql = "UPDATE tbl_work_place SET name = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, workPlace.getName());
            ptmt.setInt(2, workPlace.getId());
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

    public boolean deleteWorkPlace(Integer id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_work_place WHERE id = ?";
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

    public boolean checkWorkPlace(Integer id) {
        WorkPlaceDao workPlaceDao = new WorkPlaceDao();
        WorkPlace workPlace =  workPlaceDao.getWorkPlaceList().stream()
                .filter(o -> id.equals(o.getId()))
                .findAny()
                .orElse(null);
        return workPlace != null;
    }
}
