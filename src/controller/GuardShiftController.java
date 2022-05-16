package src.controller;

import src.dao.GuardShiftDao;
import src.model.GuardShift;
import src.validate.Validate;
import src.view.GuardShiftView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuardShiftController {
    private final GuardShiftDao guardShiftDao;
    private final GuardShiftView guardShiftView;
    public GuardShiftController(GuardShiftView guardShiftView) {
        this.guardShiftView = guardShiftView;
        guardShiftDao = new GuardShiftDao();
        guardShiftView.handleAddGuardShiftListener(new GuardShiftController.AddGuardShiftListener());
        guardShiftView.handleDeleteGuardShiftListener(new GuardShiftController.DeleteGuardShiftListener());
        guardShiftView.handleClickRowGuardShiftList(new GuardShiftController.ListGuardShiftSelectionListener());
    }
    class AddGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuardShift guardShift = guardShiftView.getGuardShiftInfo();
            Validate Validate = new Validate();
            if (!Validate.validateGuard(guardShift.getGuardId())) {
                guardShiftView.showMessage("Bảo vệ không tồn tại!");
                return;
            }
            if (!Validate.validateShift(guardShift.getShiftId())) {
                guardShiftView.showMessage("Ca trực không tồn tại!");
                return;
            }
            ArrayList<GuardShift> guardShiftList = guardShiftDao.getGuardShiftList();
            int count = 0;
            int guardShiftListSize = guardShiftList.size();
            for (int i = 0; i < guardShiftListSize; i++) {
                if (guardShiftList.get(i).getShiftId().equals(guardShift.getShiftId())) {
                    count++;
                }
            }
            if (count >= 2) {
                guardShiftView.showMessage("1 ca trực có nhiều nhất 2 bảo vệ!");
                return;

            }
            if (guardShiftDao.addGuardShift(guardShift)) {
                guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
                guardShiftView.showMessage("Thêm mới nơi bảo vệ  thành công!");
            } else {
                guardShiftView.showMessage("Error!");
            }
        }
    }
    class DeleteGuardShiftListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            GuardShift guardShift = guardShiftView.getGuardShiftInfo();
            if (guardShift != null) {
                if (guardShiftDao.deleteGuardShift(guardShift.getGuardId(), guardShift.getShiftId())){
                    guardShiftView.showGuardShiftList(guardShiftDao.getGuardShiftList());
                    guardShiftView.showMessage("Xóa thành công!");
                } else {
                    guardShiftView.showMessage("Error!");
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
