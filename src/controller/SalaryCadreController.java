package src.controller;

import src.dao.SalaryCadreDao;
import src.model.Cadre;
import src.model.Engineer;
import src.model.Worker;
import src.sort.QuickSort;
import src.sort.Salary;
import src.view.SalaryCadreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class SalaryCadreController {
    private final SalaryCadreView salaryCadreView;
    private final SalaryCadreDao salaryCadreDao;


    public SalaryCadreController(SalaryCadreView salaryCadreView) {
        this.salaryCadreView = salaryCadreView;
        salaryCadreDao = new SalaryCadreDao();
        salaryCadreView.handleSortSalaryUpListener(new SalaryCadreController.SortSalaryUpListener());
        salaryCadreView.handleSortSalaryDownListener(new SalaryCadreController.SortSalaryDownListener());
        salaryCadreView.handleFilterCadreByNameListener(new SalaryCadreController.FilterCadreByNameListener());
    }

    class SortSalaryUpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Salary> unsortedArray = new ArrayList<Salary>();
            ArrayList<Cadre> salaryCadreList = salaryCadreDao.getSalaryCadreList();
            int size = salaryCadreList.size();
            for (int i = 0; i < size; i++) {
                Integer level = 1;
                Integer experience = 1;
                if (salaryCadreList.get(i) instanceof Engineer) {
                    experience = ((Engineer) salaryCadreList.get(i)).getYearsOfExperience();
                }
                if (salaryCadreList.get(i) instanceof Worker) {
                    level = ((Worker) salaryCadreList.get(i)).getLevel();
                }
                Integer workDay = salaryCadreList.get(i).getWorkDay();
                Integer coefficientsSalary = salaryCadreList.get(i).getCoefficientsSalary();
                Integer  salaryCadre = experience * level * workDay * coefficientsSalary;
                Salary salary = new Salary(
                        salaryCadreList.get(i).getId(),
                        salaryCadreList.get(i).getName(),
                        salaryCadreList.get(i).getAge(),
                        salaryCadreList.get(i).getGender(),
                        salaryCadreList.get(i).getAddress(),
                        salaryCadreList.get(i).getPhone(),
                        salaryCadreList.get(i).getCoefficientsSalary(),
                        salaryCadreList.get(i).getWorkDay(),
                        salaryCadreList.get(i).getHomeTownId(),
                        salaryCadre,
                        experience,
                        level);
                unsortedArray.add(salary);
            }
            QuickSort qsu = new QuickSort(unsortedArray);
            qsu.startQuickStart(0, unsortedArray.size()-1);
            salaryCadreView.showSalaryCadreListSort(qsu.getSortedArray());
        }
    }
    class SortSalaryDownListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<Salary> unsortedArray = new ArrayList<Salary>();
            ArrayList<Cadre> salaryCadreList = salaryCadreDao.getSalaryCadreList();
            int size = salaryCadreList.size();
            for (int i = 0; i < size; i++) {
                Integer level = 1;
                Integer experience = 1;
                if (salaryCadreList.get(i) instanceof Engineer) {
                    experience = ((Engineer) salaryCadreList.get(i)).getYearsOfExperience();
                }
                if (salaryCadreList.get(i) instanceof Worker) {
                    level = ((Worker) salaryCadreList.get(i)).getLevel();
                }
                Integer workDay = salaryCadreList.get(i).getWorkDay();
                Integer coefficients = salaryCadreList.get(i).getCoefficientsSalary();
                Integer salaryCadre = experience * level * workDay * coefficients;
                Salary salary = new Salary(
                        salaryCadreList.get(i).getId(),
                        salaryCadreList.get(i).getName(),
                        salaryCadreList.get(i).getAge(),
                        salaryCadreList.get(i).getGender(),
                        salaryCadreList.get(i).getAddress(),
                        salaryCadreList.get(i).getPhone(),
                        salaryCadreList.get(i).getCoefficientsSalary(),
                        salaryCadreList.get(i).getWorkDay(),
                        salaryCadreList.get(i).getHomeTownId(),
                        salaryCadre,
                        experience,
                        level);
                unsortedArray.add(salary);
            }
            QuickSort qsu = new QuickSort(unsortedArray);
            qsu.startQuickStart(0, unsortedArray.size()-1);
            Collections.reverse(qsu.getSortedArray());
            salaryCadreView.showSalaryCadreListSort(qsu.getSortedArray());
        }
    }
    class FilterCadreByNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = salaryCadreView.getInputName();
            salaryCadreView.showSalaryCadreList(salaryCadreDao.filterCadreByName(salaryCadreDao.getSalaryCadreList(), name));

        }
    }
    public void showSalaryCadreMangerView() {
        salaryCadreView.setVisible(true);
        salaryCadreView.showSalaryCadreList(salaryCadreDao.getSalaryCadreList());
    }
}
