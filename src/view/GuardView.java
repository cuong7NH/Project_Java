package src.view;

import src.model.Guard;
import src.model.Worker;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuardView extends JFrame implements ActionListener {

    // Button
    private JButton addGuardBtn;
    private JButton editGuardBtn;
    private JButton deleteGuardBtn;
    // Field
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField coefficientsSalaryField;
    private JTextField workDayField;
    private JTextField workPlaceField;
    private JTextField homeTownField;
    // Table
    private JTable guardTable;
    private final String[] columnNames = new String[]{
            "ID", "Name", "Age", "Gender", "Address", "Phone", "CS", "Work Day", "Work Place", "Home Town"};
    private final Object guardData = new Object[][]{};

    public GuardView() {
        initComponents();
    }
    private void initComponents() {
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(1000, 420);
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addGuardBtn = new JButton("Add");
        editGuardBtn = new JButton("Edit");
        deleteGuardBtn = new JButton("Delete");
        addGuardBtn.setBounds(50, 100, 70, 30);
        editGuardBtn.setBounds(50, 100, 70, 30);
        deleteGuardBtn.setBounds(50, 100, 70, 30);
        panel.add(addGuardBtn);
        panel.add(editGuardBtn);
        panel.add(deleteGuardBtn);
        layout.putConstraint(SpringLayout.WEST, addGuardBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addGuardBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editGuardBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editGuardBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteGuardBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteGuardBtn, 320, SpringLayout.NORTH, panel);

        // khởi tạo các label
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel ageLabel = new JLabel("Age");
        JLabel genderLabel = new JLabel("Gender");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel coefficientsSalaryLabel = new JLabel("Coefficients");
        JLabel workDayLabel = new JLabel("Work Day");
        JLabel workPlaceLabel = new JLabel("Work Place");
        JLabel homeTownLabel = new JLabel("Home Town");
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(genderLabel);
        panel.add(addressLabel);
        panel.add(phoneLabel);
        panel.add(coefficientsSalaryLabel);
        panel.add(workDayLabel);
        panel.add(workPlaceLabel);
        panel.add(homeTownLabel);
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, genderLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, genderLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneLabel, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, coefficientsSalaryLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, coefficientsSalaryLabel, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, workDayLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, workDayLabel, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, workPlaceLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, workPlaceLabel, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownLabel, 280, SpringLayout.NORTH, panel);

        // khởi tạo các input
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        genderField = new JTextField(15);
        addressField = new JTextField(15);
        phoneField = new JTextField(15);
        coefficientsSalaryField = new JTextField(15);
        workDayField = new JTextField(15);
        workPlaceField = new JTextField(15);
        homeTownField = new JTextField(15);
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(genderField);
        panel.add(addressField);
        panel.add(phoneField);
        panel.add(coefficientsSalaryField);
        panel.add(workDayField);
        panel.add(workPlaceField);
        panel.add(homeTownField);
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, genderField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, genderField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressField, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneField, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, coefficientsSalaryField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, coefficientsSalaryField, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, workDayField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, workDayField, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, workPlaceField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, workPlaceField, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownField, 280, SpringLayout.NORTH, panel);

        // khởi tạo Table worker
        JScrollPane jScrollPaneGuardTable = new JScrollPane();
        guardTable= new JTable();
        guardTable.setModel(new DefaultTableModel((Object[][]) guardData, columnNames));
        jScrollPaneGuardTable.setViewportView(guardTable);
        jScrollPaneGuardTable.setPreferredSize(new Dimension(780, 300));
        panel.add(jScrollPaneGuardTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneGuardTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneGuardTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Guard Manager");
        this.setSize(1110, 520);
    }

    public void showGuardList(ArrayList<Guard> guardList) {
        int size = guardList.size();
        String[][] workers = new String[size][10];
        for (int i = 0; i < size; i++) {
            workers[i][0] = guardList.get(i).getId();
            workers[i][1] = guardList.get(i).getName();
            workers[i][2] = String.valueOf(guardList.get(i).getAge());
            workers[i][3] = String.valueOf(guardList.get(i).getGender());
            workers[i][4] = guardList.get(i).getAddress();
            workers[i][5] = guardList.get(i).getPhone();
            workers[i][6] = String.valueOf(guardList.get(i).getCoefficientsSalary());
            workers[i][7] = String.valueOf(guardList.get(i).getWorkDay());
            workers[i][8] = String.valueOf(guardList.get(i).getWorkPlaceId());
            workers[i][9] = String.valueOf(guardList.get(i).getHomeTownId());
        }
        guardTable.setModel(new DefaultTableModel(workers, columnNames));
    }
    public Guard getGuardInfo() {
        try {
            return new Guard(
                    idField.getText() != null && !"".equals(idField.getText()) ? idField.getText().trim() : "",
                    nameField.getText().trim(),
                    Integer.parseInt(ageField.getText().trim()),
                    Integer.parseInt(genderField.getText().trim()),
                    addressField.getText().trim(),
                    phoneField.getText().trim(),
                    Integer.parseInt(coefficientsSalaryField.getText().trim()),
                    Integer.parseInt(workDayField.getText().trim()),
                    Integer.parseInt(homeTownField.getText().trim()),
                    Integer.parseInt(workPlaceField.getText().trim())
            );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void handleAddGuardListener(ActionListener listener) {
        addGuardBtn.addActionListener(listener);
    }
    public void handleEditGuardListener(ActionListener listener) {
        editGuardBtn.addActionListener(listener);
    }
    public void handleDeleteGuardListener(ActionListener listener) {
        deleteGuardBtn.addActionListener(listener);
    }
    public void handleClickRowGuardList(ListSelectionListener listener) {
        guardTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillWorkerFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = guardTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(guardTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(guardTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(guardTable.getModel().getValueAt(row, 2).toString());
            genderField.setText(guardTable.getModel().getValueAt(row, 3).toString());
            addressField.setText(guardTable.getModel().getValueAt(row, 4).toString());
            phoneField.setText(guardTable.getModel().getValueAt(row, 5).toString());
            coefficientsSalaryField.setText(guardTable.getModel().getValueAt(row, 6).toString());
            workDayField.setText(guardTable.getModel().getValueAt(row, 7).toString());
            workPlaceField.setText(guardTable.getModel().getValueAt(row, 8).toString());
            homeTownField.setText(guardTable.getModel().getValueAt(row, 9).toString());

        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
