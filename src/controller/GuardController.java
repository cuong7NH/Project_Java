package src.controller;

import src.dao.GuardDao;
import src.model.Guard;
import src.view.GuardView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardController {
    private final GuardDao guardDao;
    private final GuardView guardView;

    public GuardController(GuardView guardView) {
        this.guardView = guardView;
        guardDao = new GuardDao();
        guardView.handleAddGuardListener(new GuardController.AddGuardListener());
        guardView.handleEditGuardListener(new GuardController.EditGuardListener());
        guardView.handleDeleteGuardListener(new GuardController.DeleteGuardListener());
        guardView.handleClickRowGuardList(new GuardController.ListGuardSelectionListener());
    }

    class AddGuardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Guard guard = guardView.getGuardInfo();
            guard.setId(guardDao.getNewGuardId());
            if (guardDao.addGuard(guard)) {
                guardView.showGuardList(guardDao.getGuardList());
                guardView.showMessage("Thêm mới bảo vệ thành công!");
            } else {
                guardView.showMessage("Error!");
            }
        }
    }

    class EditGuardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Guard guard = guardView.getGuardInfo();
            if (guardDao.editGuard(guard)) {
                guardView.showGuardList(guardDao.getGuardList());
                guardView.showMessage("Chỉnh sửa thành công!");
            } else {
                guardView.showMessage("Error!");
            }
        }
    }
    class DeleteGuardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Guard guard = guardView.getGuardInfo();
            if (guard != null) {
                if (guardDao.deleteGuard(guard.getId())) {
                    guardView.showGuardList(guardDao.getGuardList());
                    guardView.showMessage("Xóa thành công!");
                } else {
                    guardView.showMessage("Error!");
                }
            }
        }
    }
    class ListGuardSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            guardView.fillWorkerFromSelectedRow();
        }
    }
    public void showGuardMangerView() {
        guardView.setVisible(true);
        guardView.showGuardList(guardDao.getGuardList());
    }
}
