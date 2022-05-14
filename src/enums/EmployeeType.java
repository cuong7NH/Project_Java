package src.enums;

import java.util.Arrays;
import java.util.List;

public enum EmployeeType {
    NORMAL("NORMAL", "Thường"),
    DEPUTY("DEPUTY", "Phó phòng"),
    MANAGER("MANAGER", "Trưởng phòng");
    private String code;
    private String text;

    private EmployeeType(String code, String text) {
        this.code = code;
        this.text = text;
    }

    // Có thể viết một static method lấy ra EmployeeType theo code.
    public static EmployeeType getEmployeeTypeByCode(String code) {
        for (EmployeeType employeeType : EmployeeType.values()) {
            if (employeeType.code.equals(code)) {
                return employeeType;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static boolean checkEmployeeType(String type) {
        boolean isEmployeeType = false;
        for (EmployeeType employeeType : EmployeeType.values()) {
            System.out.println(employeeType);
            if(type.equals(employeeType.getCode())) {
                isEmployeeType = true;
            }
        }
        return isEmployeeType;
    }
    public static int getIndexEmployeeType(String type) {
        List<EmployeeType> enumList = Arrays.asList(EmployeeType.class.getEnumConstants());
        int index = 0;
        for (int i = 0; i < enumList.size(); i++) {
            if (enumList.get(i).getCode().equals(type)) {
                index = i;
            }
        }
        return  index;
    }

}