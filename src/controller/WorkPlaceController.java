package src.controller;

import src.dao.WorkPlaceDao;
import src.model.WorkPlace;
import src.view.WorkPlaceView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorkPlaceController {
    private final WorkPlaceDao workPlaceDao;
    private final WorkPlaceView workPlaceView;

    public WorkPlaceController(WorkPlaceView workPlaceView) {
        this.workPlaceView = workPlaceView;
        workPlaceDao = new WorkPlaceDao();
        workPlaceView.handleAddWorkPlaceListener(new WorkPlaceController.AddWorkPlaceListener());
        workPlaceView.handleEditWorkPlaceListener(new WorkPlaceController.EditWorkPlaceListener());
        workPlaceView.handleDeleteWorkPlaceListener(new WorkPlaceController.DeleteWorkPlaceListener());
        workPlaceView.handleClickRowWorkPlaceList(new WorkPlaceController.ListWorkPlaceSelectionListener());
    }

    class AddWorkPlaceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            WorkPlace workPlace = workPlaceView.getWorkPlaceInfo();
            if (workPlaceDao.addWorkPlace(workPlace)) {
                workPlaceView.showWorkPlaceList(workPlaceDao.getWorkPlaceList());
                workPlaceView.showMessage("Thêm mới nơi bảo vệ  thành công!");
            } else {
                workPlaceView.showMessage("Error!");
            }
        }
    }

    class EditWorkPlaceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            WorkPlace workPlace = workPlaceView.getWorkPlaceInfo();
            if (workPlaceDao.editWorkPlace(workPlace)) {
                workPlaceView.showWorkPlaceList(workPlaceDao.getWorkPlaceList());
                workPlaceView.showMessage("Chỉnh sửa thành công!");
            } else {
                workPlaceView.showMessage("Error!");
            }
        }
    }
    class DeleteWorkPlaceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            WorkPlace workPlace = workPlaceView.getWorkPlaceInfo();
            if (workPlace != null) {
                if (workPlaceDao.deleteWorkPlace(workPlace.getId())) {
                    workPlaceView.showWorkPlaceList(workPlaceDao.getWorkPlaceList());
                    workPlaceView.showMessage("Xóa thành công!");
                } else {
                    workPlaceView.showMessage("Error!");
                }
            }
        }
    }
    class ListWorkPlaceSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            workPlaceView.fillWorkPlaceFromSelectedRow();
        }
    }
    public void showWorkPlaceMangerView() {
        workPlaceView.setVisible(true);
        workPlaceView.showWorkPlaceList(workPlaceDao.getWorkPlaceList());
    }
}
