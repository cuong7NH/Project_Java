package src.interfaces;

import src.model.Guard;

import java.util.ArrayList;

public interface GuardInterface {
    ArrayList<Guard> getGuardList();
    boolean addGuard(Guard guard);
    boolean editGuard(Guard guard);
    boolean deleteGuard(String id);
    String getNewGuardId();
    boolean checkGuard(String id);

}
