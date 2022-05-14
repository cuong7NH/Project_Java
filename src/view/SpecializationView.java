package src.view;

import src.model.Engineer;
import src.model.Specialization;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpecializationView extends JFrame implements ActionListener {

    // Button
    private JButton addSpecializationBtn;
    private JButton editSpecializationBtn;
    private JButton deleteSpecializationBtn;
    // Field
    private JTextField idField;
    private JTextField nameField;
    // Table
    private JTable specializationTable;
    private final String[] columnNames = new String[]{"ID", "Name"};
    private final Object specializationData = new Object[][]{};


    public SpecializationView() {
        initComponents();
    }
    private void initComponents() {
        // Tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addSpecializationBtn = new JButton("Add");
        editSpecializationBtn = new JButton("Edit");
        deleteSpecializationBtn = new JButton("Delete");
        addSpecializationBtn.setBounds(50, 100, 70, 30);
        editSpecializationBtn.setBounds(50, 100, 70, 30);
        deleteSpecializationBtn.setBounds(50, 100, 70, 30);
        panel.add(addSpecializationBtn);
        panel.add(editSpecializationBtn);
        panel.add(deleteSpecializationBtn);
        layout.putConstraint(SpringLayout.WEST, addSpecializationBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addSpecializationBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editSpecializationBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editSpecializationBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteSpecializationBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteSpecializationBtn, 90, SpringLayout.NORTH, panel);

        // khởi tạo các label
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        panel.add(idLabel);
        panel.add(nameLabel);
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);

        // khởi tạo các input
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        panel.add(idField);
        panel.add(nameField);
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);

        // khởi tạo Table worker
        JScrollPane jScrollPaneSpecializationTable = new JScrollPane();
        specializationTable= new JTable();
        specializationTable.setModel(new DefaultTableModel((Object[][]) specializationData, columnNames));
        jScrollPaneSpecializationTable.setViewportView(specializationTable);
        jScrollPaneSpecializationTable.setPreferredSize(new Dimension(300, 300));
        panel.add(jScrollPaneSpecializationTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneSpecializationTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneSpecializationTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Quản lý chuyên ngành");
        this.setSize(670, 360);
    }

    public void showSpecializationList(ArrayList<Specialization> specializationList) {
        int size = specializationList.size();
        String[][] specializations = new String[size][10];
        for (int i = 0; i < size; i++) {
            specializations[i][0] = String.valueOf(specializationList.get(i).getId());
            specializations[i][1] = specializationList.get(i).getName();
        }
        specializationTable.setModel(new DefaultTableModel(specializations, columnNames));
    }

    public Specialization getSpecializationInfo() {
        try {
            return new Specialization(
                    idField.getText() != null && !"".equals(idField.getText()) ? Integer.parseInt(idField.getText().trim()) : 0,
                    nameField.getText().trim()
            );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void handleAddSpecializationListener(ActionListener listener) {
        addSpecializationBtn.addActionListener(listener);
    }
    public void handleEditSpecializationListener(ActionListener listener) {
        editSpecializationBtn.addActionListener(listener);
    }
    public void handleDeleteSpecializationListener(ActionListener listener) {
        deleteSpecializationBtn.addActionListener(listener);
    }
    public void handleClickRowSpecializationList(ListSelectionListener listener) {
        specializationTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillSpecializationFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = specializationTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(specializationTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(specializationTable.getModel().getValueAt(row, 1).toString());
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
