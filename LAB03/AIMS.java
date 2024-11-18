// Nguyen Thanh Vinh 20225779
public class AIMS {
  public static void main(String[] args) {
    Cart anOrder = new Cart();

    DigitalVideoDisc[] dvdList = new DigitalVideoDisc[3];
    dvdList[0] = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);

    dvdList[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

    dvdList[2] = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    anOrder.addDigitalVideoDisc(dvd1, dvd2);
    System.out.println("total cost is :" + anOrder.totalCost());

  }
}
