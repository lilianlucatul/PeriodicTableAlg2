package luca;

public class Element implements Weightable, Comparable<Element> {

    private String name;
    private String symbol;
    private int protonNumber;
    private double relativeAtomWeight;
    // yearFouded = -1 - neexistuje
    private int yearFounded = -1;

    public Element(String name, String symbol, int protonNumber, double relativeAtomWeight) {
        this.name = name;
        this.symbol = symbol;
        this.protonNumber = protonNumber;
        this.relativeAtomWeight = relativeAtomWeight;
    }

    public boolean setYearFounded(int yearFounded) {
        if (this.yearFounded == -1) {
            this.yearFounded = yearFounded;
            return false;
        }else{
            return true;
        }//JV bylo by dobre vracet alespon boolean, aby se vedelo, ze se to nepovedlo/povedlo
    }

    @Override
    public double getWeight() {
        return relativeAtomWeight;
    }

    @Override
    public String toString() {
        String info = name + ", " + symbol + ", " + protonNumber + ", " + relativeAtomWeight + ", " + yearFounded;
        return info;
    }

    public String getName() {
        return name;
    }

    public double getRelativeAtomWeight() {
        return relativeAtomWeight;
    }

    public int getYearFounded() {
        return yearFounded;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public int getProtonNumber() {
        return protonNumber;
    }

    @Override
    public int compareTo(Element e2) { //JV musi vracet i 0 pokud budou stejne
        if (this.relativeAtomWeight > e2.relativeAtomWeight) {
            return 1;
        }else if(this.relativeAtomWeight == e2.relativeAtomWeight){
            return 0;
        } else {
            return -1;
        }
    }

}
