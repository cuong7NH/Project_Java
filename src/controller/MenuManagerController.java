package src.controller;
import src.dao.*;
import src.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuManagerController {
    // View
    private final MenuManagerView menuManagerView;
    private final WorkerView workerView;
    private final EngineerView engineerView;
    private final SpecializationView specializationView;

    private final GuardView guardView;
    private final WorkPlaceView workPlaceView;
    private final GuardShiftView guardShiftView;
    private final HomeTownView homeTownView;
    private final SalaryCadreView salaryCadreView;

    // DAO
    private final WorkerDao workerDao;
    private final EngineerDao engineerDao;
    private final SpecializationDao specializationDao;
    private final GuardDao guardDao;
    private final WorkPlaceDao workPlaceDao;
    private final GuardShiftDao guardShiftDao;
    private final HomeTownDao homeTownDao;
    private final SalaryCadreDao salaryCadreDao;

    public MenuManagerController(
            MenuManagerView menuManagerView,
            WorkerView workerView,
            EngineerView engineerView,
            SpecializationView specializationView,
            GuardView guardView,
            WorkPlaceView workPlaceView,
            GuardShiftView guardShiftView,
            HomeTownView homeTownView,
            SalaryCadreView salaryCadreView
    ) {
        this.menuManagerView = menuManagerView;
        this.workerView = workerView;
        this.engineerView = engineerView;
        this.specializationView = specializationView;
        this.guardView = guardView;
        this.workPlaceView = workPlaceView;
        this.guardShiftView = guardShiftView;
        this.homeTownView = homeTownView;
        this.salaryCadreView = salaryCadreView;
        workerDao = new WorkerDao();
        engineerDao = new EngineerDao();
        specializationDao = new SpecializationDao();
        guardDao = new GuardDao();
        workPlaceDao = new WorkPlaceDao();
        guardShiftDao = new GuardShiftDao();
        homeTownDao = new HomeTownDao();
        salaryCadreDao = new SalaryCadreDao();
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
            workerView.setVisible(true);
            engineerView.setVisible(false);
            guardView.setVisible(false);
            workerView.showWorkerList(workerDao.getWorkerList());
        }
    }
    class OpenEngineerViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            workerView.setVisible(false);
            engineerView.setVisible(true);
            guardView.setVisible(false);
            engineerView.showEngineerList(engineerDao.getEngineerList());
        }
    }
    class OpenSpecializationViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            specializationView.setVisible(true);
            specializationView.showSpecializationList(specializationDao.getSpecializationList());
        }
    }

    class OpenGuardViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            workerView.setVisible(false);
            engineerView.setVisible(false);
            guardView.setVisible(true);
            guardView.showGuardList(guardDao.getGuardList());
        }
    }
    class OpenWorkPlaceViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            workPlaceView.setVisible(true);
            workPlaceView.showWorkPlaceList(workPlaceDao.getWorkPlaceList());
        }
    }
    class OpenWorkGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            guardShiftView.setVisible(true);
            guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
        }
    }
    class OpenHomeTownViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            homeTownView.setVisible(true);
            homeTownView.showHomeTownList(homeTownDao.getHomeTownList());
        }
    }
    class OpenSalaryCadreViewListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            salaryCadreView.setVisible(true);
            salaryCadreView.showSalaryCadreList(salaryCadreDao.getSalaryCadreList());
        }
    }
}
