package src;

import src.controller.*;
import src.model.Employee;
import src.model.GuardShift;
import src.model.HomeTown;
import src.view.*;

import java.awt.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
//                LoginController loginController = new LoginController(loginView);
//                loginController.showLoginView();
//                EmployeeView employeeView = new EmployeeView();
//                EmployeeController employeeController = new EmployeeController(employeeView);
//                employeeController.showEmployeeView();
                WorkerView workerView = new WorkerView();
                WorkerController workerController = new WorkerController(workerView);
//                workerController.showWorkerMangerView();

                EngineerView engineerView = new EngineerView();
                EngineerController engineerController = new EngineerController(engineerView);

                SpecializationView specializationView = new SpecializationView();
                SpecializationController specializationController = new SpecializationController(specializationView);

                GuardView guardView = new GuardView();
                GuardController guardController = new GuardController(guardView);
//                guardController.showGuardMangerView();

                WorkPlaceView workPlaceView = new WorkPlaceView();
                WorkPlaceController workPlaceController = new WorkPlaceController(workPlaceView);

                GuardShiftView guardShiftView = new GuardShiftView();
                GuardShiftController guardShiftController = new GuardShiftController(guardShiftView);

                HomeTownView homeTownView = new HomeTownView();
                HomeTownController homeTownController = new HomeTownController(homeTownView);

                SalaryCadreView salaryCadreView = new SalaryCadreView();
                SalaryCadreController salaryCadreController = new SalaryCadreController(salaryCadreView);

                MenuManagerView menuManagerView = new MenuManagerView();
                menuManagerView.setVisible(true);
                MenuManagerController menuManagerController = new MenuManagerController(
                        menuManagerView,
                        workerView,
                        engineerView,
                        specializationView,
                        guardView,
                        workPlaceView,
                        guardShiftView,
                        homeTownView,
                        salaryCadreView
                );

            }
        });
    }
}
