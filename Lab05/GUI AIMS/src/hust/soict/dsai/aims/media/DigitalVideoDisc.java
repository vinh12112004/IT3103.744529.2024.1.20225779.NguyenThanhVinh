package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);

    }

    public DigitalVideoDisc(int id, String title, int length, String director) {
		super(id, title, length, director);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(int id, String title, int length) {
		super(id, title, length);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String directory, float cost) {
        super(id, title, id, directory);
    }

    @Override
    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

    public void play() throws PlayerException {
    	if(this.getLength()>0) {
        System.out.println("Playing DVD: " + this.getTitle());

        System.out.println("DVD length: " + this.getLength());
    	}else {
    		throw new PlayerException("ERROR: DVD Length is non-positive!");
    	}
    }

    public DigitalVideoDisc(String title, float cost) {
        super(title, cost);
    }
}