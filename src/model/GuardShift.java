package src.model;

public class GuardShift {

    private String guardId;
    private Integer shiftId;

    public GuardShift(String guardId, Integer shiftId) {
        this.guardId = guardId;
        this.shiftId = shiftId;
    }

    public String getGuardId() {
        return guardId;
    }

    public void setGuardId(String guardId) {
        this.guardId = guardId;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    @Override
    public String toString() {
        return "GuardShift{" +
                "guardId='" + guardId + '\'' +
                ", shiftId=" + shiftId +
                '}';
    }
}
