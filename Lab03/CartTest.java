public class cartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        System.out.println("Search by ID:");
        cart.displaySearchResultById(1);
        cart.displaySearchResultById(4);

        System.out.println("\nSearch by Title:");
        cart.displaySearchResultByTitle("The Lion King");
        cart.displaySearchResultByTitle("Frozen");
    }
}
