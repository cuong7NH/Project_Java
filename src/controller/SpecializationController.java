package src.controller;

import src.dao.SpecializationDao;
import src.model.Specialization;
import src.view.SpecializationView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecializationController {
    private final SpecializationDao specializationDao;
    private final SpecializationView specializationView;
    public SpecializationController(SpecializationView specializationView) {
        this.specializationView = specializationView;
        specializationDao = new SpecializationDao();
        specializationView.handleAddSpecializationListener(new SpecializationController.AddSpecializationListener());
        specializationView.handleEditSpecializationListener(new SpecializationController.EditSpecializationListener());
        specializationView.handleDeleteSpecializationListener(new SpecializationController.DeleteSpecializationListener());
        specializationView.handleClickRowSpecializationList(new SpecializationController.ListSpecializationSelectionListener());
    }
    class AddSpecializationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Specialization specialization = specializationView.getSpecializationInfo();
            if (specializationDao.addSpecialization(specialization)) {
                specializationView.showSpecializationList(specializationDao.getSpecializationList());
                specializationView.showMessage("Thêm mới chuyên ngành thành công!");
            } else {
                specializationView.showMessage("Error!");
            }
        }
    }

    class EditSpecializationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Specialization specialization = specializationView.getSpecializationInfo();
            if (specializationDao.editSpecialization(specialization)) {
                specializationView.showSpecializationList(specializationDao.getSpecializationList());
                specializationView.showMessage("Chỉnh sửa thành công!");
            }
        }
    }
    class DeleteSpecializationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Specialization specialization = specializationView.getSpecializationInfo();
            if (specialization != null) {
                if (specializationDao.deleteSpecialization(specialization.getId())) {
                    specializationView.showSpecializationList(specializationDao.getSpecializationList());
                    specializationView.showMessage("Xóa thành công!");
                }
            }
        }
    }
    class ListSpecializationSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            specializationView.fillSpecializationFromSelectedRow();
        }
    }
    public void showSpecializationMangerView() {
        specializationView.setVisible(true);
        specializationView.showSpecializationList(specializationDao.getSpecializationList());
    }
}
