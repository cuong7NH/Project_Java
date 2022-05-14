package src.interfaces;

import src.model.HomeTown;

import java.util.ArrayList;

public interface HomeTownInterface {
    ArrayList<HomeTown> getHomeTownList();
    boolean addHomeTown(HomeTown homeTown);
    boolean editHomeTown(HomeTown homeTown);
    boolean deleteHomeTown(Integer id);
    Integer getIndexHomeTown(String name);
    String getNameHomeTown(Integer home_town_id);
    boolean checkHomeTown(Integer id);
}
