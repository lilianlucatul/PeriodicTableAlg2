package luca;

import java.time.LocalDate;

public class PeriodicTableApp {

    public static void main(String[] args) {
        PeriodicTable periodicTable = new PeriodicTable();
        FileTools.readFromElements(periodicTable);
        periodicTable.setYears(FileTools.readFromYearsFounded());
        System.out.println(periodicTable.getFirstTen());
        System.out.println("The oldest element: " + periodicTable.getTheOldestElement().getName() + ", " + periodicTable.getTheOldestElement().getYearFounded());
        int diff = LocalDate.now().getYear() - periodicTable.getTheOldestElement().getYearFounded();
        System.out.println("Byl objeven pred: " + diff + " lety");
    }

}
