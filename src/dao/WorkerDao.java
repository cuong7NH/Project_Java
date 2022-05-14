package src.dao;

import src.connection.ConnectionFactory;
import src.model.Employee;
import src.model.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WorkerDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;


    public WorkerDao() {

    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public ArrayList<Worker> getWorkerList() {
        ArrayList<Worker> workerList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM tbl_worker";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Worker worker = new Worker(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("gender"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("coefficients_salary"),
                        resultSet.getInt("work_day"),
                        resultSet.getInt("home_town_id"),
                        resultSet.getInt("level")
                );
                workerList.add(worker);
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
        return workerList;
    }

    public boolean addWorker(Worker worker) {
        boolean success = false;
        try {
            String queryString = "INSERT INTO tbl_worker(id, name, age, gender, address, phone, coefficients_salary, work_day, level, home_town_id) VALUES(?,?,?,?,?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, worker.getId());
            ptmt.setString(2, worker.getName());
            ptmt.setInt(3, worker.getAge());
            ptmt.setInt(4, worker.getGender());
            ptmt.setString(5, worker.getAddress());
            ptmt.setString(6, worker.getPhone());
            ptmt.setInt(7, worker.getCoefficientsSalary());
            ptmt.setInt(8, worker.getWorkDay());
            ptmt.setInt(9, worker.getLevel());
            ptmt.setInt(10, worker.getHomeTownId());
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

    public boolean editWorker(Worker worker) {
        boolean success = false;
        try {
            String sql = "UPDATE tbl_worker SET name = ?, age = ?, gender = ?, address = ?, phone = ?, coefficients_salary = ?, work_day = ?, level = ?, home_town_id = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, worker.getName());
            ptmt.setInt(2, worker.getAge());
            ptmt.setInt(3, worker.getGender());
            ptmt.setString(4, worker.getAddress());
            ptmt.setString(5, worker.getPhone());
            ptmt.setInt(6, worker.getCoefficientsSalary());
            ptmt.setInt(7, worker.getWorkDay());
            ptmt.setInt(8, worker.getLevel());
            ptmt.setInt(9, worker.getHomeTownId());
            ptmt.setString(10, worker.getId());
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

    public boolean deleteWorker(String id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM tbl_worker WHERE id = ?";
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

    public String getNewWorkerId() {
        String lastId = "CN1";
        String sql = "SELECT * FROM tbl_worker ORDER BY Id DESC LIMIT 1";
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
            return "CN1";
        }
        int lastIdNumber = Integer.parseInt(lastId.substring(2));
        return "CN" + (lastIdNumber + 1);
    }

}
