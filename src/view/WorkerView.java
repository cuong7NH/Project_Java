package src.view;
import src.dao.HomeTownDao;
import src.model.HomeTown;
import src.model.Worker;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerView extends JFrame implements ActionListener {
    // Button
    private JButton addWorkerBtn;
    private JButton editWorkerBtn;
    private JButton deleteWorkerBtn;
    // Field
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
//    private JTextField genderField;
    private final String genderList[]={"MALE", "FEMALE"};
    private JComboBox genderField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField coefficientsSalaryField;
    private JTextField workDayField;
    private JTextField levelField;
    private JTextField homeTownField;

    private JComboBox homeTownTestField;

    // Table
    private JTable workerTable;
    private final String[] columnNames = new String[]{
            "ID", "Name", "Age", "Gender", "Address", "Phone", "Coefficients", "Work Day", "level", "Home Town"};
    private final Object workerData = new Object[][]{};
    public WorkerView() {
        initComponents();
    }
    private void initComponents() {
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(1000, 420);
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addWorkerBtn = new JButton("Add");
        editWorkerBtn = new JButton("Edit");
        deleteWorkerBtn = new JButton("Delete");
        addWorkerBtn.setBounds(50, 100, 70, 30);
        editWorkerBtn.setBounds(50, 100, 70, 30);
        deleteWorkerBtn.setBounds(50, 100, 70, 30);
        panel.add(addWorkerBtn);
        panel.add(editWorkerBtn);
        panel.add(deleteWorkerBtn);
        layout.putConstraint(SpringLayout.WEST, addWorkerBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addWorkerBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editWorkerBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editWorkerBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteWorkerBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteWorkerBtn, 320, SpringLayout.NORTH, panel);
        // khởi tạo các label
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel ageLabel = new JLabel("Age");
        JLabel genderLabel = new JLabel("Gender");
        JLabel addressLabel = new JLabel("Address");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel coefficientsSalaryLabel = new JLabel("Coefficients");
        JLabel workDayLabel = new JLabel("Work Day");
        JLabel levelLabel = new JLabel("Level");
        JLabel homeTownLabel = new JLabel("Home Town");
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(genderLabel);
        panel.add(addressLabel);
        panel.add(phoneLabel);
        panel.add(coefficientsSalaryLabel);
        panel.add(workDayLabel);
        panel.add(levelLabel);
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
        layout.putConstraint(SpringLayout.WEST, levelLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, levelLabel, 250, SpringLayout.NORTH, panel);
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
        levelField = new JTextField(15);
        homeTownField = new JTextField(15);
        HomeTownDao homeTownDao = new HomeTownDao();
        homeTownTestField = new JComboBox();
        ArrayList<HomeTown> homeTownList = homeTownDao.getHomeTownList();
        int homeTownListSize = homeTownList.size();
        for (int i = 0; i < homeTownListSize; i++) {
            homeTownTestField.addItem(homeTownList.get(i));
        }
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(genderField);
        panel.add(addressField);
        panel.add(phoneField);
        panel.add(coefficientsSalaryField);
        panel.add(workDayField);
        panel.add(levelField);
//        panel.add(homeTownField);
        panel.add(homeTownTestField);
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
        layout.putConstraint(SpringLayout.WEST, levelField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, levelField, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownField, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownTestField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownTestField, 280, SpringLayout.NORTH, panel);
        // khởi tạo Table worker
        JScrollPane jScrollPaneWorkerTable = new JScrollPane();
        workerTable = new JTable();
        workerTable.setModel(new DefaultTableModel((Object[][]) workerData, columnNames));
        jScrollPaneWorkerTable.setViewportView(workerTable);
        jScrollPaneWorkerTable.setPreferredSize(new Dimension(780, 300));
        panel.add(jScrollPaneWorkerTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneWorkerTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneWorkerTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Worker Manager");
        this.setSize(1110, 520);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    public void showWorkerList(ArrayList<Worker> workerList) {
        HomeTownDao homeTownDao = new HomeTownDao();
        int size = workerList.size();
        String[][] workers = new String[size][10];
        for (int i = 0; i < size; i++) {
            workers[i][0] = workerList.get(i).getId();
            workers[i][1] = workerList.get(i).getName();
            workers[i][2] = String.valueOf(workerList.get(i).getAge());
            workers[i][3] = workerList.get(i).getGender() == 0 ? "MALE" : "FEMALE";
            workers[i][4] = workerList.get(i).getAddress();
            workers[i][5] = workerList.get(i).getPhone();
            workers[i][6] = String.valueOf(workerList.get(i).getCoefficientsSalary());
            workers[i][7] = String.valueOf(workerList.get(i).getWorkDay());
            workers[i][8] = String.valueOf(workerList.get(i).getLevel());
            workers[i][9] = homeTownDao.getNameHomeTown(workerList.get(i).getHomeTownId());
        }
        workerTable.setModel(new DefaultTableModel(workers, columnNames));
    }
    public Worker getWorkerInfo() {
        HomeTownDao homeTownDao = new HomeTownDao();
        ArrayList<HomeTown> homeTownList = homeTownDao.getHomeTownList();
        try {
            return new Worker(
                    idField.getText() != null && !"".equals(idField.getText()) ? idField.getText().trim() : "",
                    nameField.getText().trim(),
                    Integer.parseInt(ageField.getText().trim()),
                    genderField.getSelectedIndex(),
                    addressField.getText().trim(),
                    phoneField.getText().trim(),
                    Integer.parseInt(coefficientsSalaryField.getText().trim()),
                    Integer.parseInt(workDayField.getText().trim()),
                    homeTownList.get(homeTownTestField.getSelectedIndex()).getId(),
                    Integer.parseInt(levelField.getText().trim())
            );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public void handleAddWorkerListener(ActionListener listener) {
        addWorkerBtn.addActionListener(listener);
    }
    public void handleEditWorkerListener(ActionListener listener) {
        editWorkerBtn.addActionListener(listener);
    }
    public void handleDeleteWorkerListener(ActionListener listener) {
        deleteWorkerBtn.addActionListener(listener);
    }
    public void handleClickRowWorkerList(ListSelectionListener listener) {
        workerTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillWorkerFromSelectedRow() {
        HomeTownDao homeTownDao = new HomeTownDao();
        // lấy chỉ số của hàng được chọn
        int row = workerTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(workerTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(workerTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(workerTable.getModel().getValueAt(row, 2).toString());
            genderField.setSelectedIndex(workerTable.getModel().getValueAt(row, 3).toString() == "MALE" ? 0 : 1);
            addressField.setText(workerTable.getModel().getValueAt(row, 4).toString());
            phoneField.setText(workerTable.getModel().getValueAt(row, 5).toString());
            coefficientsSalaryField.setText(workerTable.getModel().getValueAt(row, 6).toString());
            workDayField.setText(workerTable.getModel().getValueAt(row, 7).toString());
            levelField.setText(workerTable.getModel().getValueAt(row, 8).toString());
            homeTownTestField.setSelectedIndex(homeTownDao.getIndexHomeTown(workerTable.getModel().getValueAt(row, 9).toString()));
        }
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
