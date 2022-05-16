package src.view;

import src.model.WorkPlace;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorkPlaceView extends JFrame implements ActionListener {

    // Button
    private JButton addWorkPlaceBtn;
    private JButton editWorkPlaceBtn;
    private JButton deleteWorkPlaceBtn;
    // Field
    private JTextField idField;
    private JTextField nameField;
    // Table
    private JTable workPlaceTable;
    private final String[] columnNames = new String[]{"ID", "Name"};
    private final Object workPlaceData = new Object[][]{};


    public WorkPlaceView() {
        initComponents();
    }
    private void initComponents() {
        // Tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addWorkPlaceBtn = new JButton("Add");
        editWorkPlaceBtn = new JButton("Edit");
        deleteWorkPlaceBtn = new JButton("Delete");
        addWorkPlaceBtn.setBounds(50, 100, 70, 30);
        editWorkPlaceBtn.setBounds(50, 100, 70, 30);
        deleteWorkPlaceBtn.setBounds(50, 100, 70, 30);
        panel.add(addWorkPlaceBtn);
        panel.add(editWorkPlaceBtn);
        panel.add(deleteWorkPlaceBtn);
        layout.putConstraint(SpringLayout.WEST, addWorkPlaceBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addWorkPlaceBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editWorkPlaceBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editWorkPlaceBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteWorkPlaceBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteWorkPlaceBtn, 90, SpringLayout.NORTH, panel);

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
        JScrollPane jScrollPaneWorkPlaceTable = new JScrollPane();
        workPlaceTable= new JTable();
        workPlaceTable.setModel(new DefaultTableModel((Object[][]) workPlaceData, columnNames));
        jScrollPaneWorkPlaceTable.setViewportView(workPlaceTable);
        jScrollPaneWorkPlaceTable.setPreferredSize(new Dimension(300, 300));
        panel.add(jScrollPaneWorkPlaceTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneWorkPlaceTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneWorkPlaceTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Work Place Manager");
        this.setSize(670, 360);
    }

    public void showWorkPlaceList(ArrayList<WorkPlace> workPlaceList) {
        int size = workPlaceList.size();
        String[][] workPlaces = new String[size][10];
        for (int i = 0; i < size; i++) {
            workPlaces[i][0] = String.valueOf(workPlaceList.get(i).getId());
            workPlaces[i][1] = workPlaceList.get(i).getName();
        }
        workPlaceTable.setModel(new DefaultTableModel(workPlaces, columnNames));
    }

    public WorkPlace getWorkPlaceInfo() {
        try {
            return new WorkPlace(
                    idField.getText() != null && !"".equals(idField.getText()) ? Integer.parseInt(idField.getText().trim()) : 0,
                    nameField.getText().trim()
            );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void handleAddWorkPlaceListener(ActionListener listener) {
        addWorkPlaceBtn.addActionListener(listener);
    }
    public void handleEditWorkPlaceListener(ActionListener listener) {
        editWorkPlaceBtn.addActionListener(listener);
    }
    public void handleDeleteWorkPlaceListener(ActionListener listener) {
        deleteWorkPlaceBtn.addActionListener(listener);
    }
    public void handleClickRowWorkPlaceList(ListSelectionListener listener) {
        workPlaceTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillWorkPlaceFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = workPlaceTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(workPlaceTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(workPlaceTable.getModel().getValueAt(row, 1).toString());
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
        @Override
    public void actionPerformed(ActionEvent e) {

    }
}
