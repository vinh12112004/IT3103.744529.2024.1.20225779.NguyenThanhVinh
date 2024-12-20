package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Disc(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Disc(String title) {
        super(title);
    }

    public Disc(int id, String title, int length) {
        super(id, title);
        this.length = length;
    }

    public Disc(int id, String title, int length, String director) {
        super(id, title);
        this.length = length;
        this.director = director;
    }

    public Disc(String title, float cost) {
        super(title, cost);
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
