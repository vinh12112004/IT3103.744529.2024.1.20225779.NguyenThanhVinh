package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, int length, String director) {
		super(id, title, length, director);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title, int length) {
		super(id, title, length);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, float cost) {
        super(title, cost);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in the list.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found in the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() throws PlayerException {
    	if(this.getLength() > 0 ) {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            track.play();
        }
        
        java.util.Iterator iter = tracks.iterator();
        Trach nextTrack;
        while(iter.hasNext()) {
        	nextTrack = (Track) iter.next();
        	try {
        		nextTrack.play();
        		
        	}catch(PlayerException e) {
        		throw e;
        	}
        }
        
    	}else {
    		throw new PlayerException("ERROR: CD length is non-positive");
    	}
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompactDisc{");
        sb.append("artist=").append(artist);
        sb.append(", tracks=").append(tracks);
        sb.append('}');
        return sb.toString();
    }


    
}
