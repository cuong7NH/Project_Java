package src.dao;

import src.connection.ConnectionFactory;
import src.model.HomeTown;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.OptionalInt;

public class HomeTownDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public HomeTownDao() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<HomeTown> getHomeTownList() {
        ArrayList<HomeTown> homeTownList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_home_town";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                HomeTown homeTown = new HomeTown(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                homeTownList.add(homeTown);
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
        return homeTownList;
    }

    public boolean addHomeTown(HomeTown homeTown) {
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_home_town(name) VALUES(?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, homeTown.getName());
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

    public boolean editHomeTown(HomeTown homeTown) {
        boolean success = false;
        try {
            String sql = "UPDATE tbl_home_town SET name = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, homeTown.getName());
            ptmt.setInt(2, homeTown.getId());
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

    public boolean deleteHomeTown(Integer id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_home_town WHERE id = ?";
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

    public Integer getIndexHomeTown(String name) {
        HomeTownDao homeTownDao = new HomeTownDao();
        ArrayList<HomeTown> homeTownList = homeTownDao.getHomeTownList();
        int size = homeTownList.size();
        Integer index = 0;
        for (int i = 0; i< size;  i++) {
            if (homeTownList.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    public String getNameHomeTown(Integer home_town_id) {
        HomeTownDao homeTownDao = new HomeTownDao();
        ArrayList<HomeTown> homeTownList = homeTownDao.getHomeTownList();
        int size = homeTownList.size();
        String name = "";
        for (int i = 0; i< size;  i++) {
            if (homeTownList.get(i).getId().equals(home_town_id)) {
                name = homeTownList.get(i).getName();
            }
        }
        return name;
    }



    public boolean checkHomeTown(Integer id) {
        HomeTownDao homeTownDao = new HomeTownDao();
        HomeTown homeTown =  homeTownDao.getHomeTownList().stream()
                .filter(o -> id.equals(o.getId()))
                .findAny()
                .orElse(null);
        return homeTown != null;
    }
}
