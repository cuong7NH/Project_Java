package src.controller;

import src.dao.GuardShiftDao;
import src.model.GuardShift;
import src.model.Worker;
import src.validate.Validate;
import src.view.GuardShiftView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuardShiftController {
    private final GuardShiftDao guardShiftDao;
    private final GuardShiftView guardShiftView;


    public GuardShiftController(GuardShiftView guardShiftView) {
        this.guardShiftView = guardShiftView;
        guardShiftDao = new GuardShiftDao();
        guardShiftView.handleAddGuardShiftListener(new GuardShiftController.AddGuardShiftListener());
//        guardShiftView.handleEditGuardShiftListener(new GuardShiftController.EditGuardShiftListener());
        guardShiftView.handleDeleteGuardShiftListener(new GuardShiftController.DeleteGuardShiftListener());
        guardShiftView.handleClickRowGuardShiftList(new GuardShiftController.ListGuardShiftSelectionListener());
    }

    class AddGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuardShift guardShift = guardShiftView.getGuardShiftInfo();
            Validate Validate = new Validate();
            if (!Validate.validateGuard(guardShift.getGuard_id())) {
                guardShiftView.showMessage("Bảo vệ không tồn tại!");
                return;
            }
            if (!Validate.validateShift(guardShift.getShift_id())) {
                guardShiftView.showMessage("Ca trực không tồn tại!");
                return;
            }
            System.out.println("guardShift" + guardShift);
            if (guardShiftDao.addGuardShift(guardShift)) {
                guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
                guardShiftView.showMessage("Thêm mới nơi bảo vệ  thành công!");
            } else {
                guardShiftView.showMessage("Error!");
            }
        }
    }

//    class EditGuardShiftListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            GuardShift guardShift = guardShiftView.getGuardShiftInfo();
//            if (guardShiftDao.editGuardShift(guardShift)) {
//                guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
//                guardShiftView.showMessage("Chỉnh sửa thành công!");
//            }
//        }
//    }
    class DeleteGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuardShift guardShift = guardShiftView.getGuardShiftInfo();
            if (guardShift != null) {
                if (guardShiftDao.deleteGuardShift(guardShift.getGuard_id(), guardShift.getShift_id())){
                    guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
                    guardShiftView.showMessage("Xóa thành công!");
                }
            }
        }
    }
    class ListGuardShiftSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            guardShiftView.fillGuardShiftFromSelectedRow();
        }
    }
    public void showGuardShiftMangerView() {
        guardShiftView.setVisible(true);
        guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
    }
}
