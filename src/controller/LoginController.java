package src.controller;

import src.dao.UserDao;
import src.model.User;
import src.view.EmployeeView;
import src.view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private final UserDao userDao;
    private final LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userDao = new UserDao();
        loginView.addLoginListener(new LoginListener());
    }
    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                loginView.setVisible(false);
                EmployeeView employeeView = new EmployeeView();
                EmployeeController employeeController = new EmployeeController(employeeView);
                employeeController.showEmployeeView();
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}