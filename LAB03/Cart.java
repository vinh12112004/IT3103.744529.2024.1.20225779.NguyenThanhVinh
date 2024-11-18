    // Nguyen Thanh Vinh - 20225779
    public class Cart {
        public static final int MAX_NUMBER_ORDERED = 20;
        private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
        int qtyOrdered = 0;

        public void addDigitalVideoDisc(DigitalVideoDisc disc) {
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("them thanh cong");
            } else
                System.out.println("gio hang day ko them duoc");
        }
        public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
            for(int i=0; i<dvdList.length; i++){
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                qtyOrdered++;
                System.out.println("them thanh cong " + dvdList[i].getTitle());
            } else
                System.out.println("gio hang day ko them duoc");
        }}
        public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd1;
                qtyOrdered++;
                System.out.println("them thanh cong " + dvd1.getTitle());
            } else
                System.out.println("gio hang day ko them duoc");
            
            if (qtyOrdered < MAX_NUMBER_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd2;
                qtyOrdered++;
                System.out.println("them thanh cong " + dvd2.getTitle());
            } else
                System.out.println("gio hang day ko them duoc");
        }
        public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i].equals(disc)) {
                    for (int j = i; j < qtyOrdered - 1; j++) {
                        itemsOrdered[j] = itemsOrdered[j + 1];
                    }
                    itemsOrdered[qtyOrdered-1] = null;
                    qtyOrdered--;
                    System.out.println("xoa thanh cong");
                    return;
                }
            }
            System.out.println("dia ko co de xoa");
        }

        public float totalCost() {
            float total = 0;
            for (int i = 0; i < qtyOrdered; i++) {
                total += itemsOrdered[i].getCost();
            }
            return total;
        }
    }