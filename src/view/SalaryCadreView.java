package src.view;

import src.model.Cadre;
import src.model.Engineer;
import src.model.Worker;
import src.sort.Salary;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SalaryCadreView extends JFrame implements ActionListener {
    // Khởi tạo Button
    private JButton sortUpBtn;
    private JButton sortDownBtn;
    private JButton filterByNameBtn;
    // Khởi tạo Field
    private JTextField filterByNameField;


    // Khởi tạo Table
    private JTable salaryCadreTable;
    private final String[] columnNames = new String[]{
            "ID", "Name", "CS", "Work Day", "Experience", "Level", "Salary"};
    private final Object salaryCadreData = new Object[][]{};

    public SalaryCadreView() {
        initComponents();
    }

    private void initComponents() {
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        // Field
        filterByNameField = new JTextField(15);
        filterByNameBtn = new JButton("Search By Name");
        panel.add(filterByNameField);
        panel.add(filterByNameBtn);
        layout.putConstraint(SpringLayout.WEST, filterByNameField, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, filterByNameField, 380, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, filterByNameBtn, 180, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, filterByNameBtn, 375, SpringLayout.NORTH, panel);
        // Button
        sortUpBtn = new JButton("Sort Lương tăng dần");
        sortDownBtn = new JButton("Sort Lương giảm dần");
        panel.add(sortUpBtn);
        panel.add(sortDownBtn);
        layout.putConstraint(SpringLayout.WEST, sortUpBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortUpBtn, 320, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortDownBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortDownBtn, 350, SpringLayout.NORTH, panel);
        // khởi tạo Table worker
        JScrollPane jScrollPaneEngineerTable = new JScrollPane();
        salaryCadreTable = new JTable();
        salaryCadreTable.setModel(new DefaultTableModel((Object[][]) salaryCadreData, columnNames));
        jScrollPaneEngineerTable.setViewportView(salaryCadreTable);
        jScrollPaneEngineerTable.setPreferredSize(new Dimension(780, 300));
        panel.add(jScrollPaneEngineerTable);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneEngineerTable, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneEngineerTable, 10, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Lương");
        this.setSize(800, 520);
    }

    public void showSalaryCadreList(ArrayList<Cadre> salaryCadreList) {
        int size = salaryCadreList.size();
        String[][] salaryCadres = new String[size][7];

        for (int i = 0; i < size; i++) {
            Integer level = 1;
            Integer experience = 1;
            if (salaryCadreList.get(i) instanceof Engineer) {
                experience = ((Engineer) salaryCadreList.get(i)).getYearsOfExperience();
            }
            if (salaryCadreList.get(i) instanceof Worker) {
                level = ((Worker) salaryCadreList.get(i)).getLevel();
            }
            Integer workDay = salaryCadreList.get(i).getWorkDay();
            Integer CS = salaryCadreList.get(i).getCoefficientsSalary();
            int salary = experience * level * workDay * CS;
            salaryCadres[i][0] = salaryCadreList.get(i).getId();
            salaryCadres[i][1] = salaryCadreList.get(i).getName();
            salaryCadres[i][2] = String.valueOf(salaryCadreList.get(i).getCoefficientsSalary());
            salaryCadres[i][3] = String.valueOf(salaryCadreList.get(i).getWorkDay());
            salaryCadres[i][4] = String.valueOf(experience);
            salaryCadres[i][5] = String.valueOf(level);
            salaryCadres[i][6] = String.valueOf(salary);
        }
        salaryCadreTable.setModel(new DefaultTableModel(salaryCadres, columnNames));
    }
    public void showSalaryCadreListSort(ArrayList<Salary> salaryCadreList) {
        int size = salaryCadreList.size();
        String[][] salaryCadres = new String[size][7];

        for (int i = 0; i < size; i++) {
            salaryCadres[i][0] = salaryCadreList.get(i).getId();
            salaryCadres[i][1] = salaryCadreList.get(i).getName();
            salaryCadres[i][2] = String.valueOf(salaryCadreList.get(i).getCoefficientsSalary());
            salaryCadres[i][3] = String.valueOf(salaryCadreList.get(i).getWorkDay());
            salaryCadres[i][4] = String.valueOf(salaryCadreList.get(i).getYears_of_experience());
            salaryCadres[i][5] = String.valueOf(salaryCadreList.get(i).getLevel());
            salaryCadres[i][6] = String.valueOf(salaryCadreList.get(i).getSalary());
        }
        salaryCadreTable.setModel(new DefaultTableModel(salaryCadres, columnNames));
    }
    public void handleSortSalaryUpListener(ActionListener listener) {
        sortUpBtn.addActionListener(listener);
    }

    public void handleSortSalaryDownListener(ActionListener listener) {
        sortDownBtn.addActionListener(listener);
    }

    public void handleFilterCadreByNameListener(ActionListener listener) {
        filterByNameBtn.addActionListener(listener);
    }


    public String getInputName() {
        return filterByNameField.getText().trim();

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
