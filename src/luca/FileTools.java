package luca;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileTools {

    public static ArrayList<Element> readFromElements(PeriodicTable periodicTable) {
        ArrayList<Element> elements = new ArrayList<>();
        String separator = File.separator;
        try (BufferedReader br = new BufferedReader(new FileReader("data" + separator + "prvky.csv"))) { //JV try with resources
            String description = br.readLine();
            String str;
            while ((str = br.readLine()) != null) {
                String[] strData = str.split(",");
                String name = strData[0];
                int protonNumber = Integer.parseInt(strData[1]);
                String symbol = strData[2];
                double relativeAtomWeight = Double.parseDouble(strData[3]);
                if (!periodicTable.checkIfElementExists(symbol)) {
                    periodicTable.addElement(name, symbol, protonNumber, relativeAtomWeight);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();//JV nevypisovat mimo UI
        }
        return elements;
    }

    public static ArrayList<String> readFromYearsFounded() {
        String separator = File.separator;
        Scanner scanner;
        ArrayList<String> yearsData = new ArrayList<>();
        try {
            scanner = new Scanner(new File("data" + separator + "rokObjeveni.txt"));
            String description = scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                yearsData.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Soubor nenalezen");
        }
        return yearsData;
    }

    public static void saveElementToBinaryFile(String nameOfFile, ArrayList<Element> elements, ArrayList<Integer> numOfAtoms) {
        String separator = File.separator;
        try (DataOutputStream dataInputStream = new DataOutputStream(new FileOutputStream("data" + separator + nameOfFile))) {
            dataInputStream.writeInt(elements.size());
            for (int i = 0; i < elements.size(); i++) {
                dataInputStream.writeUTF(elements.get(i).getSymbol());
                dataInputStream.writeInt(numOfAtoms.get(i));
                dataInputStream.writeDouble(elements.get(i).getRelativeAtomWeight());
                //JV chybi zapis
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static boolean checkIfFileExists(String nameOfFile) {
        String separator = File.separator;
        File file = new File("data"+separator + nameOfFile);
        return file.exists();
    }

}
