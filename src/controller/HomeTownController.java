package src.controller;

import src.dao.HomeTownDao;
import src.model.HomeTown;
import src.view.HomeTownView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTownController {
    private final HomeTownDao homeTownDao;
    private final HomeTownView homeTownView;


    public HomeTownController(HomeTownView homeTownView) {
        this.homeTownView = homeTownView;
        homeTownDao = new HomeTownDao();
        homeTownView.handleAddHomeTownListener(new HomeTownController.AddHomeTownListener());
        homeTownView.handleEditHomeTownListener(new HomeTownController.EditHomeTownListener());
        homeTownView.handleDeleteHomeTownListener(new HomeTownController.DeleteHomeTownListener());
        homeTownView.handleClickRowHomeTownList(new HomeTownController.ListHomeTownSelectionListener());
    }

    class AddHomeTownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeTown homeTown = homeTownView.getHomeTownInfo();
            if (homeTownDao.addHomeTown(homeTown)) {
                homeTownView.showHomeTownList(homeTownDao.getHomeTownList());
                homeTownView.showMessage("Thêm mới quê hương thành công!");
            } else {
                homeTownView.showMessage("Error!");
            }
        }
    }

    class EditHomeTownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeTown homeTown = homeTownView.getHomeTownInfo();
            if (homeTownDao.editHomeTown(homeTown)) {
                homeTownView.showHomeTownList(homeTownDao.getHomeTownList());
                homeTownView.showMessage("Chỉnh sửa thành công!");
            }
        }
    }
    class DeleteHomeTownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            HomeTown homeTown = homeTownView.getHomeTownInfo();
            if (homeTown != null) {
                if (homeTownDao.deleteHomeTown(homeTown.getId())) {
                    homeTownView.showHomeTownList(homeTownDao.getHomeTownList());
                    homeTownView.showMessage("Xóa thành công!");
                }
            }
        }
    }
    class ListHomeTownSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            homeTownView.fillHomeTownFromSelectedRow();
        }
    }
    public void showHomeTownMangerView() {
        homeTownView.setVisible(true);
        homeTownView.showHomeTownList(homeTownDao.getHomeTownList());
    }
}
