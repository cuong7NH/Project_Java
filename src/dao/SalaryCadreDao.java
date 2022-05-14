package src.dao;

import src.connection.ConnectionFactory;
import src.model.Cadre;
import src.model.Engineer;
import src.model.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SalaryCadreDao {


    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public SalaryCadreDao() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
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
    public ArrayList<Cadre> sortSalaryUp(ArrayList<Cadre> salaryCadreList) {



        return salaryCadreList;
    }
    public ArrayList<Cadre> filterCadreByName(ArrayList<Cadre> salaryCadreList, String name) {
        return  salaryCadreList.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toCollection(ArrayList::new));
    }
}
