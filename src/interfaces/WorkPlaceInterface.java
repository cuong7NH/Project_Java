package src.interfaces;

import src.model.WorkPlace;

import java.util.ArrayList;

public interface WorkPlaceInterface {
    ArrayList<WorkPlace> getWorkPlaceList();
    boolean addWorkPlace(WorkPlace workPlace);
    boolean editWorkPlace(WorkPlace workPlace);
    boolean deleteWorkPlace(Integer id);
    boolean checkWorkPlace(Integer id);
}
