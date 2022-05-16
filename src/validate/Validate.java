package src.validate;

import src.controller.WorkPlaceController;
import src.dao.GuardDao;
import src.dao.HomeTownDao;
import src.dao.WorkPlaceDao;
import src.model.WorkPlace;
import src.view.WorkPlaceView;

public class Validate {


    public boolean validateRequire() {
        return false;
    }

    public boolean validateAge(int age) {
        return age > 0 && age < 120;
    }

    public boolean validateWorkDay(int workDay) {
        return workDay >= 0 && workDay <= 31;
    }

    public boolean validateLevel(int level) {
        return level >= 1 && level <= 10;
    }

    public boolean validateCoefficientsSalary(int coefficientsSalary) {
        return coefficientsSalary >= 1 && coefficientsSalary <= 10;
    }

    public boolean validateHomeTown(Integer homeTownId) {
        HomeTownDao homeTownDao = new HomeTownDao();
        return homeTownDao.checkHomeTown(homeTownId);
    }

    public boolean validateGuard(String guardId) {
        GuardDao guardDao = new GuardDao();
        return guardDao.checkGuard(guardId);
    }

    public boolean validateShift(Integer shiftId) {
        return shiftId.equals(0) || shiftId.equals(1) || shiftId.equals(2);
    }
}
