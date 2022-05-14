package src.view;

import src.model.Engineer;
import src.model.GuardShift;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuardShiftView extends JFrame implements ActionListener {

    // Button
    private JButton addGuardShiftBtn;
    private JButton editGuardShiftBtn;
    private JButton deleteGuardShiftBtn;
    // Field
    private JTextField shiftIdField;
    private JTextField guardIdField;
    // Table
    private JTable guardShiftTable;
    private final String[] columnNames = new String[]{"Ca trực", "Guard ID"};
    private final Object guardShiftData = new Object[][]{};


    public GuardShiftView() {
        initComponents();
    }
    private void initComponents() {
        // Tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addGuardShiftBtn = new JButton("Add");
        editGuardShiftBtn = new JButton("Edit");
        deleteGuardShiftBtn = new JButton("Delete");
        addGuardShiftBtn.setBounds(50, 100, 70, 30);
        editGuardShiftBtn.setBounds(50, 100, 70, 30);
        deleteGuardShiftBtn.setBounds(50, 100, 70, 30);
        panel.add(addGuardShiftBtn);
//        panel.add(editGuardShiftBtn);
        panel.add(deleteGuardShiftBtn);
        layout.putConstraint(SpringLayout.WEST, addGuardShiftBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addGuardShiftBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editGuardShiftBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editGuardShiftBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteGuardShiftBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteGuardShiftBtn, 90, SpringLayout.NORTH, panel);

        // khởi tạo các label
        JLabel shiftLabel = new JLabel("Ca Trực");
        JLabel guardLabel = new JLabel("Guard ID");
        panel.add(shiftLabel);
        panel.add(guardLabel);
        layout.putConstraint(SpringLayout.WEST, shiftLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, shiftLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, guardLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, guardLabel, 40, SpringLayout.NORTH, panel);

        // khởi tạo các input
        shiftIdField = new JTextField(6);
//        shiftIdField.setEditable(false);
        guardIdField = new JTextField(15);
        panel.add(shiftIdField);
        panel.add(guardIdField);
        layout.putConstraint(SpringLayout.WEST, shiftIdField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, shiftIdField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, guardIdField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, guardIdField, 40, SpringLayout.NORTH, panel);

        // khởi tạo Table worker
        JScrollPane jScrollPaneGuardShiftTable = new JScrollPane();
        guardShiftTable= new JTable();
        guardShiftTable.setModel(new DefaultTableModel((Object[][]) guardShiftData, columnNames));
        jScrollPaneGuardShiftTable.setViewportView(guardShiftTable);
        jScrollPaneGuardShiftTable.setPreferredSize(new Dimension(300, 300));
        panel.add(jScrollPaneGuardShiftTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneGuardShiftTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneGuardShiftTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Quản lý ca trực");
        this.setSize(670, 360);
    }

    public void showGuardShiftList(ArrayList<GuardShift> guardShiftList) {
        int size = guardShiftList.size();
        String[][] guardShifts = new String[size][10];
        for (int i = 0; i < size; i++) {
            guardShifts[i][0] = String.valueOf(guardShiftList.get(i).getShift_id());
            guardShifts[i][1] = guardShiftList.get(i).getGuard_id();
        }
        guardShiftTable.setModel(new DefaultTableModel(guardShifts, columnNames));
    }

    public GuardShift getGuardShiftInfo() {
        try {
            return new GuardShift(
                    guardIdField.getText().trim(),
                    shiftIdField.getText() != null && !"".equals(shiftIdField.getText()) ? Integer.parseInt(shiftIdField.getText().trim()) : 0
                        );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void handleAddGuardShiftListener(ActionListener listener) {
        addGuardShiftBtn.addActionListener(listener);
    }
    public void handleEditGuardShiftListener(ActionListener listener) {
        editGuardShiftBtn.addActionListener(listener);
    }
    public void handleDeleteGuardShiftListener(ActionListener listener) {
        deleteGuardShiftBtn.addActionListener(listener);
    }
    public void handleClickRowGuardShiftList(ListSelectionListener listener) {
        guardShiftTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillGuardShiftFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = guardShiftTable.getSelectedRow();
        if (row >= 0) {
            shiftIdField.setText(guardShiftTable.getModel().getValueAt(row, 0).toString());
            guardIdField.setText(guardShiftTable.getModel().getValueAt(row, 1).toString());
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
