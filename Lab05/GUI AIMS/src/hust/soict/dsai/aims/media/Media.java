package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Media {
    private static final AtomicInteger idCounter = new AtomicInteger(0); // Tự động tạo ID

    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructor 1: Dùng title, gán ID tự động
    public Media(String title) {
        this.id = idCounter.incrementAndGet(); // Gán ID tự động
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.id = idCounter.incrementAndGet();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public Media(String title, float cost) {
        this.title = title;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return title != null && title.equals(media.title);
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    
    @Override
    public String toString() {
        return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
    }
}

