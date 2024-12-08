package hust.soict.dsai.test.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class mediaTest {
    public static void main(String[] args) {

        Media dvd = new DigitalVideoDisc(1, "The Matrix", "Action", 19.99f, 136, "Lana Wachowski");
        Media book = new Book(2, "Java Programming", "Education", 29.99f, "Herbert Schildt");
        Media cd = new CompactDisc(3, "The Best of The Beatles", "Music", 15.99f, 70, "George Martin", "The Beatles");

        ArrayList<Media> mediaList = new ArrayList<>();
        mediaList.add(dvd);
        mediaList.add(book);
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
