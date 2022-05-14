package src.controller;

import src.dao.EmployeeDao;
import src.enums.EmployeeType;
import src.model.Employee;
import src.view.EmployeeView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private final EmployeeDao employeeDao;
    private final EmployeeView employeeView;
    public EmployeeController(EmployeeView employeeView) {
        this.employeeView = employeeView;
        employeeDao = new EmployeeDao();
        employeeView.handleAddEmployeeListener(new AddEmployeeListener());
        employeeView.handleEditEmployeeListener(new EditEmployeeListener());
        employeeView.handleDeleteEmployeeListener(new DeleteEmployeeListener());
        employeeView.handleClickRowEmployeeList(new ListEmployeeSelectionListener());
    }
    public void showEmployeeView() {
        employeeView.setVisible(true);
        employeeView.showEmployeeList(employeeDao.fetchEmployeeList());
    }
    class AddEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Employee employee = employeeView.getEmployeeInfo();
            if (employee != null) {
                if(EmployeeType.checkEmployeeType(employee.getType())) {
                    if (employeeDao.addEmployee(employee)) {
                        employeeView.showEmployeeList(employeeDao.fetchEmployeeList());
                        employeeView.showMessage("Thêm mới nhân viên thành công!");
                    } else {
                        employeeView.showMessage("Error!");
                    }
                } else {
                    employeeView.showMessage("Type sai!");
                }

            }
        }
    }

    class EditEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Employee employee = employeeView.getEmployeeInfo();
            if (employee != null) {
                if (employeeDao.editEmployee(employee)) {
                    employeeView.showEmployeeList(employeeDao.fetchEmployeeList());
                    employeeView.showMessage("Chỉnh sửa thành công!");
                }
            }
        }
    }

    class DeleteEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Employee employee = employeeView.getEmployeeInfo();
            if (employee != null) {
                if (employeeDao.deleteEmployee(employee.getId())) {
                    employeeView.showEmployeeList(employeeDao.fetchEmployeeList());
                    employeeView.showMessage("Xóa thành công!");
                }
            }
        }
    }


    class ListEmployeeSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            employeeView.fillStudentFromSelectedRow();
        }
    }
}
