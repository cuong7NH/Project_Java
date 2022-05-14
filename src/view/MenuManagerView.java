package src.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManagerView extends JFrame implements ActionListener {
    private JButton workerButton;
    private JButton engineerButton;
    private JButton specializationButton;
    private JButton guardButton;
    private JButton workPlaceButton;
    private JButton guardShiftButton;
    private JButton homeTownButton;

    private JButton salaryCadreButton;

    public MenuManagerView() {
        initComponents();
    }

    private void initComponents() {

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        workerButton = new JButton("Worker");
        engineerButton = new JButton("Engineer");
        specializationButton = new JButton("Chuyên ngành");
        guardButton = new JButton("Guard");
        workPlaceButton = new JButton("Work Place");
        guardShiftButton = new JButton("Guard Shift");
        homeTownButton = new JButton("Home Town");
        salaryCadreButton = new JButton("Salary Cadre");
        workerButton.setBounds(50, 100, 70, 30);
        engineerButton.setBounds(50, 100, 70, 30);
        specializationButton.setBounds(50, 100, 70, 30);
        guardButton.setBounds(50, 100, 70, 30);
        workPlaceButton.setBounds(50, 100, 70, 30);
        guardShiftButton.setBounds(50, 100, 70, 30);
        homeTownButton.setBounds(50, 100, 70, 30);
        salaryCadreButton.setBounds(50, 100, 70, 30);
        panel.add(workerButton);
        panel.add(workPlaceButton);
        panel.add(guardShiftButton);
        panel.add(engineerButton);
        panel.add(specializationButton);
        panel.add(guardButton);
        panel.add(homeTownButton);
        panel.add(salaryCadreButton);
        layout.putConstraint(SpringLayout.WEST, workerButton, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, workerButton, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, engineerButton, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, engineerButton, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, specializationButton, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, specializationButton, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, guardButton, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, guardButton, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, workPlaceButton, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, workPlaceButton, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, guardShiftButton, 240, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, guardShiftButton, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, homeTownButton, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, homeTownButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, salaryCadreButton, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, salaryCadreButton, 170, SpringLayout.NORTH, panel);
        this.add(panel);
        this.pack();
        this.setTitle("Menu Manager");
        this.setSize(400, 300);
    }

        @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void openWorkerViewListener(ActionListener listener) {
        workerButton.addActionListener(listener);
    }
    public void openEngineerViewListener(ActionListener listener) {
        engineerButton.addActionListener(listener);
    }
    public void openSpecializationViewListener(ActionListener listener) {
        specializationButton.addActionListener(listener);
    }

    public void openGuardViewListener(ActionListener listener) {
        guardButton.addActionListener(listener);
    }
    public void openWorkPlaceViewListener(ActionListener listener) {
        workPlaceButton.addActionListener(listener);
    }
    public void openWorkGuardShiftListener(ActionListener listener) {
        guardShiftButton.addActionListener(listener);
    }
    public void openHomeTownViewListener(ActionListener listener) {
        homeTownButton.addActionListener(listener);
    }
    public void openSalaryCadreViewListener(ActionListener listener) {
        salaryCadreButton.addActionListener(listener);
    }

}