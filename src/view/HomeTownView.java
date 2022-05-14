package src.view;

import src.model.HomeTown;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeTownView extends JFrame implements ActionListener {

    // Button
    private JButton addHomeTownBtn;
    private JButton editHomeTownBtn;
    private JButton deleteHomeTownBtn;
    // Field
    private JTextField idField;
    private JTextField nameField;
    // Table
    private JTable homeTownTable;
    private final String[] columnNames = new String[]{"ID", "Name"};
    private final Object homeTownData = new Object[][]{};


    public HomeTownView() {
        initComponents();
    }
    private void initComponents() {
        // Tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        // khởi tạo các phím chức năng
        addHomeTownBtn = new JButton("Add");
        editHomeTownBtn = new JButton("Edit");
        deleteHomeTownBtn = new JButton("Delete");
        addHomeTownBtn.setBounds(50, 100, 70, 30);
        editHomeTownBtn.setBounds(50, 100, 70, 30);
        deleteHomeTownBtn.setBounds(50, 100, 70, 30);
        panel.add(addHomeTownBtn);
        panel.add(editHomeTownBtn);
        panel.add(deleteHomeTownBtn);
        layout.putConstraint(SpringLayout.WEST, addHomeTownBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addHomeTownBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editHomeTownBtn, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, editHomeTownBtn, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteHomeTownBtn, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteHomeTownBtn, 90, SpringLayout.NORTH, panel);

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
        JScrollPane jScrollPaneHomeTownTable = new JScrollPane();
        homeTownTable= new JTable();
        homeTownTable.setModel(new DefaultTableModel((Object[][]) homeTownData, columnNames));
        jScrollPaneHomeTownTable.setViewportView(homeTownTable);
        jScrollPaneHomeTownTable.setPreferredSize(new Dimension(300, 300));
        panel.add(jScrollPaneHomeTownTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneHomeTownTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneHomeTownTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Home Town Manager");
        this.setSize(670, 360);
    }

    public void showHomeTownList(ArrayList<HomeTown> homeTownList) {
        int size = homeTownList.size();
        String[][] homeTowns = new String[size][10];
        for (int i = 0; i < size; i++) {
            homeTowns[i][0] = String.valueOf(homeTownList.get(i).getId());
            homeTowns[i][1] = homeTownList.get(i).getName();
        }
        homeTownTable.setModel(new DefaultTableModel(homeTowns, columnNames));
    }

    public HomeTown getHomeTownInfo() {
        try {
            return new HomeTown(
                    idField.getText() != null && !"".equals(idField.getText()) ? Integer.parseInt(idField.getText().trim()) : 0,
                    nameField.getText().trim()
            );
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void handleAddHomeTownListener(ActionListener listener) {
        addHomeTownBtn.addActionListener(listener);
    }
    public void handleEditHomeTownListener(ActionListener listener) {
        editHomeTownBtn.addActionListener(listener);
    }
    public void handleDeleteHomeTownListener(ActionListener listener) {
        deleteHomeTownBtn.addActionListener(listener);
    }
    public void handleClickRowHomeTownList(ListSelectionListener listener) {
        homeTownTable.getSelectionModel().addListSelectionListener(listener);
    }
    public void fillHomeTownFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = homeTownTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(homeTownTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(homeTownTable.getModel().getValueAt(row, 1).toString());
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
