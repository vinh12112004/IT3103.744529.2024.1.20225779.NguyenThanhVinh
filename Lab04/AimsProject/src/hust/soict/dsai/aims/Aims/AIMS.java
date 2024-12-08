package hust.soict.dsai.aims.Aims;
// Nguyen Thanh Vinh 20225779


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;
import java.text.BreakIterator;
import java.util.Collections;
import java.util.Scanner;

public class AIMS {
  private static Scanner sc = new Scanner(System.in);

  private static Cart cart = new Cart();
  public static Store store = new Store();
  public static void main(String[] args) {

    
    Media dvd = new DigitalVideoDisc(1, "The Matrix", "Action", 19.99f, 136, "Lana Wachowski");
    Media book = new Book(2, "Java Programming", "Education", 29.99f, "Herbert Schildt");
    Media cd = new CompactDisc(3, "The Best of The Beatles", "Music", 15.99f, 70, "George Martin", "The Beatles");

    store.addMedia(dvd);
    store.addMedia(book);
    store.addMedia(cd);
    
    int choice;
        do {
            showMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:   
                          viewStore();
                          break;
                case 2 : updateStore();
                        break;
                case 3 : SeeTheCurrentCart();
                        break;
                case 0 :  System.out.println("Thank you!");
                        break;
                default : System.out.println("Invalid option! Please try again.");
                        break;
            }
        } while (choice != 0);

  }
  public static void showMenu() {
    System.out.println("AIMS: ");
    System.out.println("--------------------------------");
    System.out.println("1. View store");
    System.out.println("2. Update store");
    System.out.println("3. See current cart");
    System.out.println("0. Exit");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2-3");
    }

  public static void storeMenu() {
    System.out.println("Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. See a media's details");
    System.out.println("2. Add a media to cart");
    System.out.println("3. Play a media");
    System.out.println("4. See current cart");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2-3-4");
    }
  
  public static void mediaDetailsMenu() {
    System.out.println("Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Add to cart");
    System.out.println("2. Play");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2");
      }
  
  public static void cartMenu() {
    System.out.println("Options: ");
    System.out.println("--------------------------------");
    System.out.println("1. Filter medias in cart");
    System.out.println("2. Sort medias in cart"); 
    System.out.println("3. Remove media from cart");
    System.out.println("4. Play a media");
    System.out.println("5. Place order");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.println("Please choose a number: 0-1-2-3-4-5");
        }

  private static void viewStore(){
    int choice;
    store.printStore();
    do{
      storeMenu();
      choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
          case 1 :
              seeMediaDetails();
              break;
          case 2 :
              addMediatoCard();
              break;
          case 3 :
              PlayMedia();
              break;
          case 4 :
              SeeTheCurrentCart();
              break;
          case 0 :
              break;
          default:
              System.out.print("Invalid option! Please try again.");
              break;
      }
    }while(choice!=0);
  }
      
  private static void seeMediaDetails() {
        System.out.println("Please enter the media's title: ");
        String title = sc.nextLine();
        
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 : cart.addMedia(media);
                        break;
                case 2 : 
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media can't play.");
                    }
                    break;
                case 0 : 
                        break;
                default : System.out.print("Invalid option! Please try again.");
                        break;
            }
        } else {
            System.out.println("Can not find the media!");
        }
    }

    private static void addMediatoCard(){
      System.out.println("Please enter the media's title: ");
      String title = sc.nextLine();
      Media media = store.searchByTitle(title);
      if(media != null){
        cart.addMedia(media);
        System.out.println("Media added to cart.");
      } else{
        System.out.println("Can not find the media!");
      }
    }

    private static void PlayMedia(){
      System.out.println("Please enter the media's title: ");
      String title = sc.nextLine();
      Media media = store.searchByTitle(title);
      if (media != null && media instanceof Playable){
        ((Playable) media).play();
      }
    }

    private static void SeeTheCurrentCart(){
      cart.print();
      int choice;
      do {
        cartMenu();
        choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
          case 1: filterCart();
                  break;
          case 2: sortCart();
                  break;
          case 3: removeMediaFromCart();
                  break;
          case 4: PlayMedia();
                  break;
          case 5: placeOrder();
                  break;
          case 0: 
            break;
        
          default: System.out.print("Invalid option! Please try again.");
            break;
        }
        
      } while (choice != 0);
    }

    private static void filterCart(){
      System.out.print("Choose an option to filter Media: ");
		  System.out.println("1: By title, 2: By id: ");
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
          case 1 :
              System.out.print("Please enter the title: ");
              String title = sc.nextLine();
              for (Media media : cart.ItemsInCart()) {
                if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                  System.out.println(media.toString());
                }
              }
              break;
          case 2 :
              System.out.print("Please enter the id: ");
              int id = sc.nextInt();
              for (Media media : cart.ItemsInCart()) {
                if (media.getId() == id) {
                System.out.println(media.toString());
                }
              }
          default:
              System.out.println("please enter a valid option");
      }
    }

    private static void sortCart(){
      System.out.println("Please choose if you'd like to sort by title or cost: 0 - title, 1 - cost");
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
		    case 0:
			    Collections.sort(cart.ItemsInCart(), media.COMPARE_BY_TITLE_COST);
			    System.out.println("cart is sorted by title successfully");
			    for (Media media : cart.ItemsInCart()) {
				    System.out.println(media.toString());
			    }
			break;
		    case 1:
			    Collections.sort(cart.ItemsInCart(), media.COMPARE_BY_COST_TITLE);
			    System.out.println("cart is sorted by cost successfully");
			    for (Media media : cart.ItemsInCart()) {
				    System.out.println(media.toString());
			    }
			break;
		  }
    }
  
    private static void removeMediaFromCart() {
      System.out.println("Enter the media's title: ");
      String title = sc.nextLine();
      Media media = cart.searchByTitle(title);
      if (media != null) {
          cart.removeMedia(media);
          System.out.println("The media has been removed from the cart.");
      } else {
          System.out.println("Can not find the media!");
      }
  }

  private static void placeOrder(){
    System.out.println("An order is created!");
		cart.ItemsInCart().clear();
  }

  private static void updateStore(){
    System.out.println("Option: ");
        System.out.println("1. add media to store");
        System.out.println("2. delete media to store");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1 : addMediaToStore();
                    break;
            case 2 : removeMediaFromStore();
                    break;
            default : System.out.println("Invalid option! Please try again.");
                    break;
        }
  }

  private static void addMediaToStore(){
      System.out.println("Enter the media's title: ");
      String title = sc.nextLine();
      Media media = store.searchByTitle(title);
      if(media != null){
        store.addMedia(media);
        System.out.println("added media to store.");
      } else{
        System.out.println("Can not find the media!");
      }
  }

  private static void removeMediaFromStore(){
    System.out.println("Enter the media's title: ");
    String title = sc.nextLine();
    Media media = store.searchByTitle(title);
    if (media != null) {
        store.removeMedia(media.getTitle());
        System.out.println("deleted media to store.");
    } else {
        System.out.println("Can not find the media!");
    }
  }
}