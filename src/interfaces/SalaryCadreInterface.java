package src.interfaces;

import src.model.Cadre;

import java.util.ArrayList;

public interface SalaryCadreInterface {

    ArrayList<Cadre> getSalaryCadreList();
    ArrayList<Cadre> filterCadreByName(ArrayList<Cadre> salaryCadreList, String name);

}
