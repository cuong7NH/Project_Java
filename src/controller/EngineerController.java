package src.controller;

import src.dao.EngineerDao;
import src.model.Engineer;
import src.view.EngineerView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EngineerController {
    private final EngineerDao engineerDao;
    private final EngineerView engineerView;


    public EngineerController(EngineerView engineerView) {
        this.engineerView = engineerView;
        engineerDao = new EngineerDao();
        engineerView.handleAddEngineerListener(new EngineerController.AddEngineerListener());
        engineerView.handleEditEngineerListener(new EngineerController.EditEngineerListener());
        engineerView.handleDeleteEngineerListener(new EngineerController.DeleteEngineerListener());
        engineerView.handleClickRowEngineerList(new EngineerController.ListEngineerSelectionListener());
    }

    class AddEngineerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Engineer engineer = engineerView.getEngineerInfo();
            engineer.setId(engineerDao.getNewEngineerId());
            if (engineerDao.addEngineer(engineer)) {
                engineerView.showEngineerList(engineerDao.getEngineerList());
                engineerView.showMessage("Thêm mới công nhân thành công!");
            } else {
                engineerView.showMessage("Error!");
            }
        }
    }

    class EditEngineerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Engineer engineer = engineerView.getEngineerInfo();
            if (engineerDao.editEngineer(engineer)) {
                engineerView.showEngineerList(engineerDao.getEngineerList());
                engineerView.showMessage("Chỉnh sửa thành công!");
            } else {
                engineerView.showMessage("Error!");
            }
        }
    }
    class DeleteEngineerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Engineer engineer = engineerView.getEngineerInfo();
            if (engineer != null) {
                if (engineerDao.deleteEngineer(engineer.getId())) {
                    engineerView.showEngineerList(engineerDao.getEngineerList());
                    engineerView.showMessage("Xóa thành công!");
                } else {
                    engineerView.showMessage("Error!");
                }
            }
        }
    }
    class ListEngineerSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            engineerView.fillWorkerFromSelectedRow();
        }
    }
    public void showEngineerMangerView() {
        engineerView.setVisible(true);
        engineerView.showEngineerList(engineerDao.getEngineerList());
    }
}
