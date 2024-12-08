package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);

    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, id, category);
    }

    public DigitalVideoDisc(int id, String title, String category, String directory, float cost) {
        super(id, title, id, directory);
    }

    @Override
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

    public void play() {

        System.out.println("Playing DVD: " + this.getTitle());

        System.out.println("DVD length: " + this.getLength());

    }

}