package src.controller;

import src.dao.SalaryCadreDao;
import src.model.Cadre;
import src.model.Engineer;
import src.model.Worker;
import src.sort.QuickSort;
import src.sort.SalaryDTO;
import src.util.QuicksortGeneric;
import src.view.SalaryCadreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SalaryCadreController {
    private final SalaryCadreView salaryCadreView;
    private final SalaryCadreDao salaryCadreDao;


    public SalaryCadreController(SalaryCadreView salaryCadreView) {
        this.salaryCadreView = salaryCadreView;
        salaryCadreDao = new SalaryCadreDao();
        salaryCadreView.handleSortSalaryUpListener(new SalaryCadreController.SortSalaryListener("ASC"));
        salaryCadreView.handleSortSalaryDownListener(new SalaryCadreController.SortSalaryListener("DESC"));
        salaryCadreView.handleFilterCadreByNameListener(new SalaryCadreController.FilterCadreByNameListener());
    }

    class SortSalaryListener implements ActionListener {
        private final String typeSort;

        public SortSalaryListener(String typeSort) {
            this.typeSort = typeSort;
        }

        public void actionPerformed(ActionEvent e) {
            ArrayList<SalaryDTO> unsortedArray = new ArrayList<SalaryDTO>();
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
                SalaryDTO salaryDTO = new SalaryDTO(
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
                unsortedArray.add(salaryDTO);
            }
            System.out.println(unsortedArray);
            QuicksortGeneric<SalaryDTO> salaryDTOSorter   = new QuicksortGeneric<>();
            salaryDTOSorter.quicksort(unsortedArray, 0, unsortedArray.size() - 1);
            ArrayList<SalaryDTO> sorted =  unsortedArray;
            if (typeSort.equals("DESC")) {
                Collections.reverse(unsortedArray);
            }
            salaryCadreView.showSalaryCadreListSort(sorted);
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
