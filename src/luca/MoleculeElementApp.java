package luca;

import java.util.ArrayList;
import java.util.Scanner;

public class MoleculeElementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PeriodicTable periodicTable = new PeriodicTable();
        FileTools.readFromElements(periodicTable);
        periodicTable.setYears(FileTools.readFromYearsFounded());
        String choice = "";
        ArrayList<Element> elements = new ArrayList<>();
        ArrayList<Integer> numOfAtoms = new ArrayList<>();
        while (!choice.equals("konec")) {
            System.out.println("Zadejte nazev prvku/molekuly/konec");
            choice = scanner.nextLine();
            if (!choice.equals("konec")) {
                String[] strArr = choice.split(" ");
                double relativeWeight;
                if (strArr.length == 1) {
                    relativeWeight = periodicTable.getRelativeWeightOfElement(choice);
                    numOfAtoms.add(1);
                } else {
                    relativeWeight = periodicTable.getRelativeWeightOfElement(strArr[0], Integer.parseInt(strArr[1]));
                    numOfAtoms.add(Integer.valueOf(strArr[1]));
                }
                System.out.println("Relativni hmotnost: " + relativeWeight);
                elements.add(periodicTable.getElementBySymbol(choice));
            }
        }

        System.out.println("Zadejte nazev vystupniho binarniho souboru");
        String nameOfBinaryFile = scanner.nextLine();
        if (FileTools.checkIfFileExists(nameOfBinaryFile)) {
            System.out.print("Chcete prepsat soubor?: ");
            String choiceRewrite = scanner.nextLine();
            if (choiceRewrite.equals("ano")) {
                FileTools.saveElementToBinaryFile(nameOfBinaryFile, elements, numOfAtoms);
            } else {
                String[] str = nameOfBinaryFile.split("\\.");
                FileTools.saveElementToBinaryFile(str[0] + "_copy" + "." + str[1], elements, numOfAtoms);
            }
        }
    }
}
