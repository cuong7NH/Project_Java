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

    public boolean validateCoefficientsSalary(int coefficients_salary) {
        return coefficients_salary >= 1 && coefficients_salary <= 10;
    }

    public boolean validateHomeTown(Integer home_town_id) {
        System.out.println("home_town_id" + home_town_id);
        HomeTownDao homeTownDao = new HomeTownDao();
        return homeTownDao.checkHomeTown(home_town_id);
    }

    public boolean validateGuard(String guard_id) {
        GuardDao guardDao = new GuardDao();
        return guardDao.checkGuard(guard_id);
    }

    public boolean validateShift(Integer shift_id) {
        return shift_id.equals(1) || shift_id.equals(2) || shift_id.equals(3);
    }
}
