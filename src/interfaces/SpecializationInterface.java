package src.interfaces;

import src.model.Specialization;

import java.util.ArrayList;

public interface SpecializationInterface {
    ArrayList<Specialization> getSpecializationList();
    boolean addSpecialization(Specialization specialization);
    boolean editSpecialization(Specialization specialization);
    boolean deleteSpecialization(Integer id);
    boolean checkSpecialization(Integer id);
}
