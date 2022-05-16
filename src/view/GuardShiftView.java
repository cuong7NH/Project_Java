package src.view;

import jdk.dynalink.linker.support.Guards;
import src.dao.GuardDao;
import src.dao.HomeTownDao;
import src.model.Engineer;
import src.model.Guard;
import src.model.GuardShift;
import src.model.HomeTown;

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
    private final String[] shiftList = {"Sáng", "Chiều", "Tối"};
    private JComboBox shiftIdField;
    private JComboBox guardIdField;
    // Table
    private JTable guardShiftTable;
    private final String[] columnNames = new String[]{"Guard", "Ca trực"};
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
        JLabel guardLabel = new JLabel("Guard");
        panel.add(shiftLabel);
        panel.add(guardLabel);
        layout.putConstraint(SpringLayout.WEST, shiftLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, shiftLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, guardLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, guardLabel, 40, SpringLayout.NORTH, panel);

        // khởi tạo các input
        shiftIdField = new JComboBox(shiftList);
        GuardDao guardDao = new GuardDao();
        guardIdField = new JComboBox();
        ArrayList<Guard> guardsList = guardDao.getGuardList();
        for (Guard Guard : guardsList) {
            guardIdField.addItem(Guard.getName());
        }
        panel.add(shiftIdField);
        panel.add(guardIdField);
        layout.putConstraint(SpringLayout.WEST, shiftIdField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, shiftIdField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, guardIdField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, guardIdField, 40, SpringLayout.NORTH, panel);

        // khởi tạo Table worker
        JScrollPane jScrollPaneGuardShiftTable = new JScrollPane();
        guardShiftTable = new JTable();
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
        GuardDao guardDao = new GuardDao();
        int size = guardShiftList.size();
        String shiftName = "Sáng";
        
        String[][] guardShifts = new String[size][10];
        for (int i = 0; i < size; i++) {
            Integer shiftId = guardShiftList.get(i).getShiftId();
            if (shiftId.equals(0)) {
                shiftName = "Sáng";
            }
            if (shiftId.equals(1)) {
                shiftName = "Chiều";
            }
            if (shiftId.equals(2)) {
                shiftName = "Tối";
            }
            guardShifts[i][0] = guardDao.getNameGuard(guardShiftList.get(i).getGuardId());
            guardShifts[i][1] = shiftName;
        }
        guardShiftTable.setModel(new DefaultTableModel(guardShifts, columnNames));
    }

    public GuardShift getGuardShiftInfo() {
        GuardDao guardDao = new GuardDao();
        ArrayList<Guard> guardList = guardDao.getGuardList();
        try {
            return new GuardShift(
                    guardList.get(guardIdField.getSelectedIndex()).getId(),
                    shiftIdField.getSelectedIndex()
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
        GuardDao guardDao = new GuardDao();
        // lấy chỉ số của hàng được chọn
        int row = guardShiftTable.getSelectedRow();
        Integer shiftId = 0;
        if (row >= 0) {
            String shiftName = guardShiftTable.getModel().getValueAt(row, 1).toString();
            if (shiftName.equals("Sáng")) {
                shiftId = 0;
            }
            if (shiftName.equals("Chiều")) {
                shiftId = 1;
            }
            if (shiftName.equals("Tối")) {
                shiftId = 2;
            }
            shiftIdField.setSelectedIndex(shiftId);
            guardIdField.setSelectedIndex(guardDao.getIndexGuard(guardShiftTable.getModel().getValueAt(row, 0).toString()));
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
