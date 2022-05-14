package src.interfaces;

import src.model.GuardShift;

import java.util.ArrayList;

public interface GuardShiftInterface {
    ArrayList<GuardShift> getGuardShiftList();
    boolean addGuardShift(GuardShift guardShift);
    boolean deleteGuardShift(String guard_id, Integer shift_id);

}
