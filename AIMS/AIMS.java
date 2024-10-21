public class AIMS {
    public static void main(String[] args) {
      Cart anOrder = new Cart();
      
      DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);

      DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

      DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

      anOrder.addDigitalVideoDisc(dvd3);

      System.out.println("total cost is :" + anOrder.totalCost());
    }
}
