package luca;

public class MoleculeSame implements Weightable {
    private Element element;
    private int count;
    
    public void saveMolecule(Element element, int count) {
        this.element = element;
        this.count = count;
    }

    @Override
    public double getWeight() {
        return count * element.getWeight();
    }
}
