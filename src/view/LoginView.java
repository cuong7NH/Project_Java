package src.view;

import src.model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

import javax.swing.*;

public class  LoginView extends JFrame implements ActionListener {
    @Serial
    private static final long serialVersionUID = 1L;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel userNameLabel = new JLabel("UserName");
        JLabel passwordLabel = new JLabel("Password");
        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.addActionListener(this);
        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(400, 300);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordLabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginBtn);
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 80, SpringLayout.WEST, userNameLabel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 80, SpringLayout.WEST, passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginBtn, 80, SpringLayout.WEST, passwordLabel);
        layout.putConstraint(SpringLayout.NORTH, loginBtn, 130, SpringLayout.NORTH, panel);
        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Đăng nhập hệ thống!");
        this.setSize(400, 300);
        this.setResizable(false);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        return new User(userNameField.getText(),
                String.copyValueOf(passwordField.getPassword()));
    }

    public void addLoginListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}