package src.dao;
import src.interfaces.SalaryCadreInterface;
import src.model.Cadre;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SalaryCadreDao implements SalaryCadreInterface {
    public SalaryCadreDao() {
    }
    public ArrayList<Cadre> getSalaryCadreList() {
        ArrayList<Cadre> salaryCadreList = new ArrayList<>();
        EngineerDao engineerDao = new EngineerDao();
        WorkerDao workerDao = new WorkerDao();
        GuardDao guardDao = new GuardDao();
        salaryCadreList.addAll(engineerDao.getEngineerList());
        salaryCadreList.addAll(workerDao.getWorkerList());
        salaryCadreList.addAll(guardDao.getGuardList());
        return salaryCadreList;
    }
    public ArrayList<Cadre> filterCadreByName(ArrayList<Cadre> salaryCadreList, String name) {
        return  salaryCadreList.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }
}
