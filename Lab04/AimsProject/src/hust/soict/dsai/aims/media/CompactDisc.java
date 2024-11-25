package src.hust.soict.dsai.aims.media;

import java.util.List;

public class CompactDisc extends Disc {
    private String artist;

    private List<Track> tracks;

    public String getArtist() {
        return artist;
    }

    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist,
            List<Track> tracks) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("track da ton tai");
        }else{
            tracks.add(track);
            System.out.println("da them track thanh cong");
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("da xoa thanh cong track");
        }else{
            System.out.println("track ko ton tai");
        }
    }
    
}
