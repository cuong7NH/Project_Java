package src.interfaces;

import src.model.Engineer;

import java.util.ArrayList;

public interface EngineerInterface {
    ArrayList<Engineer> getEngineerList();
    boolean addEngineer(Engineer engineer);
    boolean editEngineer(Engineer engineer);
    boolean deleteEngineer(String id);
    String getNewEngineerId();

}
