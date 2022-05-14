package src.controller;

import src.dao.*;
import src.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManagerController {
    // View
//    private MenuManagerView menuManagerView;
    private final WorkerController workerController;
    private final EngineerController engineerController;
    private final SpecializationController specializationController;
    private final GuardController guardController;
    private final WorkPlaceController workPlaceController;
    private final GuardShiftController guardShiftController;
    private final SalaryCadreController salaryCadreController;
    private final HomeTownController homeTownController;


    public MenuManagerController(
            MenuManagerView menuManagerView,
            WorkerController workerController,
            EngineerController engineerController,
            SpecializationController specializationController,
            GuardController guardController,
            WorkPlaceController workPlaceController,
            GuardShiftController guardShiftController,
            HomeTownController homeTownController,
            SalaryCadreController salaryCadreController
    ) {
//        this.menuManagerView = menuManagerView;
        this.workerController = workerController;
        this.engineerController = engineerController;
        this.specializationController = specializationController;
        this.guardController = guardController;
        this.workPlaceController = workPlaceController;
        this.guardShiftController = guardShiftController;
        this.salaryCadreController = salaryCadreController;
        this.homeTownController = homeTownController;

        menuManagerView.openWorkerViewListener(new MenuManagerController.OpenWorkerViewListener());
        menuManagerView.openEngineerViewListener(new MenuManagerController.OpenEngineerViewListener());
        menuManagerView.openSpecializationViewListener(new MenuManagerController.OpenSpecializationViewListener());
        menuManagerView.openGuardViewListener(new MenuManagerController.OpenGuardViewListener());
        menuManagerView.openWorkPlaceViewListener(new MenuManagerController.OpenWorkPlaceViewListener());
        menuManagerView.openWorkGuardShiftListener(new MenuManagerController.OpenWorkGuardShiftListener());
        menuManagerView.openHomeTownViewListener(new MenuManagerController.OpenHomeTownViewListener());
        menuManagerView.openSalaryCadreViewListener(new MenuManagerController.OpenSalaryCadreViewListener());
    }

    class OpenWorkerViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            workerController.showWorkerMangerView();
        }
    }

    class OpenEngineerViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            engineerController.showEngineerMangerView();
        }
    }

    class OpenSpecializationViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            specializationController.showSpecializationMangerView();
        }
    }

    class OpenGuardViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            guardController.showGuardMangerView();
        }
    }

    class OpenWorkPlaceViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            workPlaceController.showWorkPlaceMangerView();
        }
    }

    class OpenWorkGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            guardShiftController.showGuardShiftMangerView();
        }
    }

    class OpenHomeTownViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            homeTownController.showHomeTownMangerView();
        }
    }

    class OpenSalaryCadreViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            salaryCadreController.showSalaryCadreMangerView();
        }
    }
}
