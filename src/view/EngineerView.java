package src.view;
import src.dao.EngineerDao;
import src.dao.HomeTownDao;
import src.model.Engineer;
import src.model.HomeTown;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EngineerView extends JFrame implements ActionListener {

    // Button
    private JButton addEngineerBtn;
    private JButton editEngineerBtn;
    private JButton deleteEngineerBtn;
    // Field
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private final String[] genderList ={"MALE", "FEMALE"};
    private JComboBox genderField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField coefficientsSalaryField;
    private JTextField workDayField;
    private JTextField yearsOfExperienceField;
    private JComboBox homeTownField;
    // Table
    private JTable engineerTable;
    private final String[] columnNames = new String[]{
            "ID", "Name", "Age", "Gender", "Address", "Phone", "Coefficients", "Work Day", "Experience", "Home Town"};
    private final Object engineerData = new Object[][]{};

    public EngineerView() {
        initComponents();
    }
    private void initComponents() {
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addEngineerBtn = new JButton("Add");
        editEngineerBtn = new JButton("Edit");
        deleteEngineerBtn = new JButton("Delete");
        addEngineerBtn.setBounds(50, 100, 70, 30);
        editEngineerBtn.setBounds(50, 100, 70, 30);
        deleteEngineerBtn.setBounds(50, 100, 70, 30);
        panel.add(addEngineerBtn);
        panel.add(editEngineerBtn);
        panel.add(deleteEngineerBtn);
        layout.putConstraint(SpringLayout.WEST, addEngineerBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addEngineerBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editEngineerBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editEngineerBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteEngineerBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteEngineerBtn, 320, SpringLayout.NORTH, panel);

        // khởi tạo các label
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel ageLabel = new JLabel("Age");
        JLabel genderLabel = new JLabel("Gender");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel coefficientsSalaryLabel = new JLabel("Coefficients");
        JLabel workDayLabel = new JLabel("Work Day");
        JLabel experienceLabel = new JLabel("Experience");
        JLabel homeTownLabel = new JLabel("Home Town");
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(genderLabel);
        panel.add(addressLabel);
        panel.add(phoneLabel);
        panel.add(coefficientsSalaryLabel);
        panel.add(workDayLabel);
        panel.add(experienceLabel);
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
        layout.putConstraint(SpringLayout.WEST, experienceLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, experienceLabel, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownLabel, 280, SpringLayout.NORTH, panel);

        // khởi tạo các input
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        genderField = new JComboBox(genderList);
        addressField = new JTextField(15);
        phoneField = new JTextField(15);
        coefficientsSalaryField = new JTextField(15);
        workDayField = new JTextField(15);
        yearsOfExperienceField = new JTextField(15);
        HomeTownDao homeTownDao = new HomeTownDao();
        homeTownField = new JComboBox();
        ArrayList<HomeTown> homeTownList = homeTownDao.getHomeTownList();
        for (HomeTown homeTown : homeTownList) {
            homeTownField.addItem(homeTown.getName());
        }
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(genderField);
        panel.add(addressField);
        panel.add(phoneField);
        panel.add(coefficientsSalaryField);
        panel.add(workDayField);
        panel.add(yearsOfExperienceField);
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
        layout.putConstraint(SpringLayout.WEST, yearsOfExperienceField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, yearsOfExperienceField, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownField, 280, SpringLayout.NORTH, panel);

        // khởi tạo Table worker
        JScrollPane jScrollPaneEngineerTable = new JScrollPane();
        engineerTable= new JTable();
        engineerTable.setModel(new DefaultTableModel((Object[][]) engineerData, columnNames));
        jScrollPaneEngineerTable.setViewportView(engineerTable);
        jScrollPaneEngineerTable.setPreferredSize(new Dimension(780, 300));
        panel.add(jScrollPaneEngineerTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneEngineerTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneEngineerTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Engineer Manager");
        this.setSize(1110, 520);
    }
 
    public void showEngineerList(ArrayList<Engineer> engineerList) {
        HomeTownDao homeTownDao = new HomeTownDao();
        int size = engineerList.size();
        String[][] workers = new String[size][10];
        for (int i = 0; i < size; i++) {
            workers[i][0] = engineerList.get(i).getId();
            workers[i][1] = engineerList.get(i).getName();
            workers[i][2] = String.valueOf(engineerList.get(i).getAge());
            workers[i][3] = engineerList.get(i).getGender() == 0 ? "MALE" : "FEMALE";
            workers[i][4] = engineerList.get(i).getAddress();
            workers[i][5] = engineerList.get(i).getPhone();
            workers[i][6] = String.valueOf(engineerList.get(i).getCoefficientsSalary());
            workers[i][7] = String.valueOf(engineerList.get(i).getWorkDay());
            workers[i][8] = String.valueOf(engineerList.get(i).getYearsOfExperience());
            workers[i][9] = homeTownDao.getNameHomeTown(engineerList.get(i).getHomeTownId());
        }
        engineerTable.setModel(new DefaultTableModel(workers, columnNames));
    }
    public Engineer getEngineerInfo() {
        HomeTownDao homeTownDao = new HomeTownDao();
        ArrayList<HomeTown> homeTownList = homeTownDao.getHomeTownList();
        try {
            return new Engineer(
                    idField.getText() != null && !"".equals(idField.getText()) ? idField.getText().trim() : "",
                    nameField.getText().trim(),
                    Integer.parseInt(ageField.getText().trim()),
                    genderField.getSelectedIndex(),
                    addressField.getText().trim(),
                    phoneField.getText().trim(),
                    Integer.parseInt(coefficientsSalaryField.getText().trim()),
                    Integer.parseInt(workDayField.getText().trim()),
                    homeTownList.get(homeTownField.getSelectedIndex()).getId(),
                    Integer.parseInt(yearsOfExperienceField.getText().trim())
            );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void handleAddEngineerListener(ActionListener listener) {
        addEngineerBtn.addActionListener(listener);
    }
    public void handleEditEngineerListener(ActionListener listener) {
        editEngineerBtn.addActionListener(listener);
    }
    public void handleDeleteEngineerListener(ActionListener listener) {
        deleteEngineerBtn.addActionListener(listener);
    }
    public void handleClickRowEngineerList(ListSelectionListener listener) {
        engineerTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillWorkerFromSelectedRow() {
        HomeTownDao homeTownDao = new HomeTownDao();
        // lấy chỉ số của hàng được chọn
        int row = engineerTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(engineerTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(engineerTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(engineerTable.getModel().getValueAt(row, 2).toString());
            genderField.setSelectedIndex(engineerTable.getModel().getValueAt(row, 3).toString() == "MALE" ? 0 : 1);
            addressField.setText(engineerTable.getModel().getValueAt(row, 4).toString());
            phoneField.setText(engineerTable.getModel().getValueAt(row, 5).toString());
            coefficientsSalaryField.setText(engineerTable.getModel().getValueAt(row, 6).toString());
            workDayField.setText(engineerTable.getModel().getValueAt(row, 7).toString());
            yearsOfExperienceField.setText(engineerTable.getModel().getValueAt(row, 8).toString());
            homeTownField.setSelectedIndex(homeTownDao.getIndexHomeTown(engineerTable.getModel().getValueAt(row, 9).toString()));
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
