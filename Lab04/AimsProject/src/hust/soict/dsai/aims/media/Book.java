package src.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = new ArrayList<>();
    }

    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.out.println("da co tac gia trong list");
            return;
        }
        authors.add(authorName);
        System.out.println("them tac gia thanh cong");
    }

    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)){
            System.out.println("ten ko ton tai");
            return;
        }
        authors.remove(authorName);
        System.out.println("xoa thanh cong");
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    
    

}
