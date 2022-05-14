package src.view;

import src.enums.EmployeeType;
import src.model.Employee;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeeView extends JFrame implements ActionListener {

    private JButton addEmployeeBtn;
    private JButton editEmployeeBtn;
    private JButton deleteEmployeeBtn;
    private JTable employeeTable;
    private JTextField idField;
    private JTextField nameField;
    private JTextArea addressTA;
    private JTextField phoneNumberField;
    private final EmployeeType employeeType[]={EmployeeType.NORMAL, EmployeeType.DEPUTY, EmployeeType.MANAGER};
    private JComboBox typeField;
    private JTextField salaryScaleField;

    private JTextField departmentIdField;
    private final String[] columnNames = new String[]{
            "ID", "Name", "Address", "Phone Number", "Type", "Salary Scale", "Department Id"};
    private final Object employeeData = new Object[][]{};
    public EmployeeView() {
        initComponents();
    }
    private void initComponents() {
        // tạo spring layout
        // khởi tạo các phím chức năng
        addEmployeeBtn = new JButton("Add");
        editEmployeeBtn = new JButton("Edit");
        deleteEmployeeBtn = new JButton("Delete");
        // khởi tạo bảng employee
        JScrollPane jScrollPaneEmployeeTable = new JScrollPane();
        employeeTable = new JTable();
        // khởi tạo các label
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneNumberLabel = new JLabel("Phone Number");
        JLabel typeLabel = new JLabel("Type");
        JLabel salaryScaleLabel = new JLabel("Salary Scale");
        JLabel departmentIdLabel = new JLabel("Department ID");
        // khởi tạo các trường nhập dữ liệu cho
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        JScrollPane jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        phoneNumberField = new JTextField(15);
        typeField =new JComboBox(employeeType);
        salaryScaleField = new JTextField(15);
        departmentIdField = new JTextField(15);
        // cài đặt các cột và data cho bảng Employee
        employeeTable.setModel(new DefaultTableModel((Object[][]) employeeData, columnNames));
        jScrollPaneEmployeeTable.setViewportView(employeeTable);
        jScrollPaneEmployeeTable.setPreferredSize(new Dimension(680, 300));
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Employee
        JPanel panel = new JPanel();
        panel.setSize(1000, 420);
        panel.setLayout(layout);
        addEmployeeBtn.setBounds(50, 100, 70, 30);
        editEmployeeBtn.setBounds(50, 100, 70, 30);
        deleteEmployeeBtn.setBounds(50, 100, 70, 30);
        panel.add(addEmployeeBtn);
        panel.add(editEmployeeBtn);
        panel.add(deleteEmployeeBtn);
        panel.add(jScrollPaneEmployeeTable);
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(addressLabel);
        panel.add(phoneNumberLabel);
        panel.add(typeLabel);
        panel.add(salaryScaleLabel);
        panel.add(departmentIdLabel);
        panel.add(idField);
        panel.add(nameField);
        panel.add(jScrollPaneAddress);
        panel.add(phoneNumberField);
        panel.add(typeField);
        panel.add(salaryScaleField);
        panel.add(departmentIdField);
        // cài đặt vị trí các thành phần trên màn hình login
        // label
        layout.putConstraint(SpringLayout.WEST, jScrollPaneEmployeeTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneEmployeeTable, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneNumberLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNumberLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, typeLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, typeLabel, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, salaryScaleLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, salaryScaleLabel, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, departmentIdLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, departmentIdLabel, 250, SpringLayout.NORTH, panel);
        // field
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneNumberField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneNumberField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, typeField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, typeField, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, salaryScaleField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, salaryScaleField, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, departmentIdField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, departmentIdField, 250, SpringLayout.NORTH, panel);
        // button
        layout.putConstraint(SpringLayout.WEST, addEmployeeBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addEmployeeBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editEmployeeBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editEmployeeBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteEmployeeBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteEmployeeBtn, 290, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Employee Information");
        this.setSize(1000, 420);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    /**
     * lấy thông tin student
     *
     * @return
     */
    /**
     * xóa thông tin student
     */
    public void clearEmployeeInfo() {
        idField.setText("");
        nameField.setText("");
        phoneNumberField.setText("");
        addressTA.setText("");
        salaryScaleField.setText("");
        departmentIdField.setText("");
    }

    // Lấy thông tin employee từ Form
    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }
    private boolean validateType() {
        String type = String.valueOf(typeField.getItemAt(typeField.getSelectedIndex()));
        if (type == null || "".equals(type.trim())) {
            typeField.requestFocus();
            showMessage("Type không được trống.");
            return false;
        }
        return true;
    }
    private boolean validateDepartment() {
        String name = departmentIdField.getText();
        if (name == null || "".equals(name.trim())) {
            departmentIdField.requestFocus();
            showMessage("Department không được trống.");
            return false;
        }
        return true;
    }
    public Employee getEmployeeInfo() {
        // validate Employee
        if (!validateName() || !validateType() || !validateDepartment()) {
            return null;
        }
        try {
            Employee employee = new Employee.EmployeeBuilder()
                    .id(idField.getText() != null && !"".equals(idField.getText()) ? Integer.parseInt(idField.getText().trim()) : 0)
                    .name(nameField.getText().trim())
                    .address(addressTA.getText().trim())
                    .phoneNumber(phoneNumberField.getText().trim())
                    .type(String.valueOf(typeField.getItemAt(typeField.getSelectedIndex())))
                    .salaryScale(Integer.parseInt(salaryScaleField.getText()))
                    .departmentId(Integer.parseInt(departmentIdField.getText()))
                    .build();
            return employee;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public void handleAddEmployeeListener(ActionListener listener) {
        addEmployeeBtn.addActionListener(listener);
    }
    public void handleEditEmployeeListener(ActionListener listener) {
        editEmployeeBtn.addActionListener(listener);
    }
    public void handleDeleteEmployeeListener(ActionListener listener) {
        deleteEmployeeBtn.addActionListener(listener);
    }
    //Click row in table
    public void handleClickRowEmployeeList(ListSelectionListener listener) {
        employeeTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void showEmployeeList(ArrayList<Employee> employeeList) {
        int size = employeeList.size();
        String[][] employees = new String[size][7];
        for (int i = 0; i < size; i++) {
            employees[i][0] = String.valueOf(employeeList.get(i).getId());
            employees[i][1] = employeeList.get(i).getName();
            employees[i][2] = employeeList.get(i).getAddress();
            employees[i][3] = employeeList.get(i).getPhoneNumber();
            employees[i][4] = employeeList.get(i).getType();
            employees[i][5] = String.valueOf(employeeList.get(i).getSalaryScale());
            employees[i][6] = String.valueOf(employeeList.get(i).getDepartmentId());
        }
        employeeTable.setModel(new DefaultTableModel(employees, columnNames));
    }

    /**
     * điền thông tin của hàng được chọn từ bảng employee
     * vào các trường tương ứng của employee.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = employeeTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(employeeTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(employeeTable.getModel().getValueAt(row, 1).toString());
            addressTA.setText(employeeTable.getModel().getValueAt(row, 2).toString());
            phoneNumberField.setText(employeeTable.getModel().getValueAt(row, 3).toString());
            typeField.setSelectedIndex(EmployeeType.getIndexEmployeeType(employeeTable.getModel().getValueAt(row, 4).toString()));
            salaryScaleField.setText(employeeTable.getModel().getValueAt(row, 5).toString());
            departmentIdField.setText(employeeTable.getModel().getValueAt(row, 6).toString());
        }
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
