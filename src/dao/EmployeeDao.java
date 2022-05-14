package src.dao;

import src.connection.ConnectionFactory;
import src.model.Employee;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class EmployeeDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;


    public EmployeeDao() {

    }
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    public ArrayList<Employee> fetchEmployeeList() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM employee";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee.EmployeeBuilder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .address(resultSet.getString("address"))
                        .phoneNumber(resultSet.getString("phoneNumber"))
                        .type(resultSet.getString("type"))
                        .salaryScale(Integer.valueOf(resultSet.getString("salaryScale")))
                        .departmentId(Integer.valueOf(resultSet.getString("departmentId")))
                        .build();
                employeeList.add(employee);
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
        return employeeList;
    }

    public boolean addEmployee(Employee employee) {
        boolean success = false;
        try {
            String queryString = "INSERT INTO employee(name, address, phoneNumber, type, salaryScale, departmentId) VALUES(?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, employee.getName());
            ptmt.setString(2, employee.getAddress());
            ptmt.setString(3, employee.getPhoneNumber());
            ptmt.setString(4, employee.getType());
            ptmt.setString(5, String.valueOf(employee.getSalaryScale()));
            ptmt.setString(6, String.valueOf(employee.getDepartmentId()));
            ptmt.executeUpdate();
            success = true;
            System.out.println("Data Added Successfully");
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
    public boolean editEmployee(Employee employee) {
        boolean success = false;
        try {
            String sql = "UPDATE employee SET name = ?, address = ?, phoneNumber = ?, type = ?, salaryScale = ?, departmentId = ? WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, employee.getName());
            ptmt.setString(2, employee.getAddress());
            ptmt.setString(3, employee.getPhoneNumber());
            ptmt.setString(4, employee.getType());
            ptmt.setString(5, String.valueOf(employee.getSalaryScale()));
            ptmt.setString(6, String.valueOf(employee.getDepartmentId()));
            ptmt.setString(7, String.valueOf(employee.getId()));
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
    public boolean deleteEmployee(Integer id) {
        boolean success = false;
        try {
            String sql = "DELETE FROM employee WHERE id = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(sql);
            ptmt.setString(1, String.valueOf(id));
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
