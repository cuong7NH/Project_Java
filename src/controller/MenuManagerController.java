package src.controller;

import src.dao.*;
import src.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManagerController {

    public MenuManagerController(
            MenuManagerView menuManagerView
    ) {
        menuManagerView.openWorkerViewListener(new OpenWorkerViewListener());
        menuManagerView.openEngineerViewListener(new OpenEngineerViewListener());
        menuManagerView.openSpecializationViewListener(new OpenSpecializationViewListener());
        menuManagerView.openGuardViewListener(new OpenGuardViewListener());
        menuManagerView.openWorkPlaceViewListener(new OpenWorkPlaceViewListener());
        menuManagerView.openWorkGuardShiftListener(new OpenWorkGuardShiftListener());
        menuManagerView.openHomeTownViewListener(new OpenHomeTownViewListener());
        menuManagerView.openSalaryCadreViewListener(new OpenSalaryCadreViewListener());
    }

    static class OpenWorkerViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            WorkerView workerView = new WorkerView();
            WorkerController workerController = new WorkerController(workerView);
            workerController.showWorkerMangerView();
        }
    }

    static class OpenEngineerViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EngineerView engineerView = new EngineerView();
            EngineerController engineerController = new EngineerController(engineerView);
            engineerController.showEngineerMangerView();
        }
    }

    static class OpenSpecializationViewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SpecializationView specializationView = new SpecializationView();
            SpecializationController specializationController = new SpecializationController(specializationView);
            specializationController.showSpecializationMangerView();
        }
    }

    static class OpenGuardViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuardView guardView = new GuardView();
            GuardController guardController = new GuardController(guardView);
            guardController.showGuardMangerView();
        }
    }

    static class OpenWorkPlaceViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            WorkPlaceView workPlaceView = new WorkPlaceView();
            WorkPlaceController workPlaceController = new WorkPlaceController(workPlaceView);
            workPlaceController.showWorkPlaceMangerView();
        }
    }

     static class OpenWorkGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuardShiftView guardShiftView = new GuardShiftView();
            GuardShiftController guardShiftController = new GuardShiftController(guardShiftView);
            guardShiftController.showGuardShiftMangerView();
        }
    }

    static class OpenHomeTownViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeTownView homeTownView = new HomeTownView();
            HomeTownController homeTownController = new HomeTownController(homeTownView);
            homeTownController.showHomeTownMangerView();
        }
    }

    static class OpenSalaryCadreViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SalaryCadreView salaryCadreView = new SalaryCadreView();
            SalaryCadreController salaryCadreController = new SalaryCadreController(salaryCadreView);
            salaryCadreController.showSalaryCadreMangerView();
        }
    }
}
