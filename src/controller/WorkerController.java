package src.controller;

import src.dao.WorkerDao;
import src.model.Employee;
import src.model.Worker;
import src.validate.Validate;
import src.view.WorkerView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkerController {
    private final WorkerDao workerDao;
    private final WorkerView workerView;


    public WorkerController(WorkerView workerView) {
        this.workerView = workerView;
        workerDao = new WorkerDao();
        workerView.handleAddWorkerListener(new WorkerController.AddWorkerListener());
        workerView.handleEditWorkerListener(new WorkerController.EditWorkerListener());
        workerView.handleDeleteWorkerListener(new WorkerController.DeleteWorkerListener());
        workerView.handleClickRowWorkerList(new WorkerController.ListWorkerSelectionListener());
    }

    class AddWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Worker worker = workerView.getWorkerInfo();
            Validate Validate = new Validate();
            if (!Validate.validateAge(worker.getAge())) {
                workerView.showMessage("Tuổi không hợp lệ!");
                return;
            }
            if (!Validate.validateWorkDay(worker.getWorkDay())) {
                workerView.showMessage("Số ngày làm việc không hợp lệ!");
                return;
            }
            if (!Validate.validateLevel(worker.getLevel())) {
                workerView.showMessage("Level không hợp lệ! (1 - 10)");
                return;
            }
            if (!Validate.validateCoefficientsSalary(worker.getCoefficientsSalary())) {
                workerView.showMessage("Hệ số lương không hợp lệ! (1 - 10)");
                return;
            }
            if(!Validate.validateHomeTown(worker.getHomeTownId())) {
                workerView.showMessage("Home town không hợp lệ!");
                return;
            }
            worker.setId(workerDao.getNewWorkerId());
            if (workerDao.addWorker(worker)) {
                workerView.showWorkerList(workerDao.getWorkerList());
                workerView.showMessage("Thêm mới công nhân thành công!");
            } else {
                workerView.showMessage("Error!");
            }
        }
    }

    class EditWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Worker worker = workerView.getWorkerInfo();
            Validate Validate = new Validate();
            if (!Validate.validateAge(worker.getAge())) {
                workerView.showMessage("Tuổi không hợp lệ!");
                return;
            }
            if (!Validate.validateWorkDay(worker.getWorkDay())) {
                workerView.showMessage("Số ngày làm việc không hợp lệ!");
                return;
            }
            if (!Validate.validateLevel(worker.getLevel())) {
                workerView.showMessage("Level không hợp lệ! (1 - 10)");
                return;
            }
            if (!Validate.validateCoefficientsSalary(worker.getCoefficientsSalary())) {
                workerView.showMessage("Hệ số lương không hợp lệ! (1 - 10)");
                return;
            }
            if(!Validate.validateHomeTown(worker.getHomeTownId())) {
                workerView.showMessage("Home town không hợp lệ!");
                return;
            }
            if (workerDao.editWorker(worker)) {
                workerView.showWorkerList(workerDao.getWorkerList());
                workerView.showMessage("Chỉnh sửa thành công!");
            }
        }
    }

    class DeleteWorkerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Worker worker = workerView.getWorkerInfo();
            if (worker != null) {
                if (workerDao.deleteWorker(worker.getId())) {
                    workerView.showWorkerList(workerDao.getWorkerList());
                    workerView.showMessage("Xóa thành công!");
                }
            }
        }
    }

    class ListWorkerSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            workerView.fillWorkerFromSelectedRow();
        }
    }

    public void showWorkerMangerView() {
        workerView.setVisible(true);
        workerView.showWorkerList(workerDao.getWorkerList());
    }
}
