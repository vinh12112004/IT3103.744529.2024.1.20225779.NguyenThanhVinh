package src.hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc {

    private String directory;
    private int length;

    private static int nbDigitalVideoDiscs = 0;

    public String getDirectory() {
        return directory;
    }

    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String directory, float cost) {
        this.title = title;
        this.category = category;
        this.directory = directory;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        this.title = title;
        this.category = category;
        this.directory = directory;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public String toString() {
        return "DVD - " + title + " - " + category + " - " + directory + " - " + length + " - " + cost + " $";
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

}