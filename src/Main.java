package src;

import src.controller.*;
import src.view.*;

import java.awt.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                WorkerView workerView = new WorkerView();
                WorkerController workerController = new WorkerController(workerView);

                EngineerView engineerView = new EngineerView();
                EngineerController engineerController = new EngineerController(engineerView);

                SpecializationView specializationView = new SpecializationView();
                SpecializationController specializationController = new SpecializationController(specializationView);

                GuardView guardView = new GuardView();
                GuardController guardController = new GuardController(guardView);

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
                        workerController,
                        engineerController,
                        specializationController,
                        guardController,
                        workPlaceController,
                        guardShiftController,
                        homeTownController,
                        salaryCadreController
                );
            }
        });
    }
}
