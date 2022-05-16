package src.interfaces;

import src.model.Worker;

import java.sql.Connection;
import java.util.ArrayList;

public interface WorkerInterface {
    ArrayList<Worker> getWorkerList();
    boolean addWorker(Worker worker);
    boolean editWorker(Worker worker);
    boolean deleteWorker(String id);

    String getNewWorkerId();

}
