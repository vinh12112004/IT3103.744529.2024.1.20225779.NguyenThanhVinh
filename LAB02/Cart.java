public class Cart{
    public static final int MAX_NUMBER_ORDERED=20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBER_ORDERED ){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("them thanh cong");
        } else System.out.println("gio hang day ko them duoc");
    }
    public void deleteDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i=0; i < qtyOrdered; i++){
            if (itemsOrdered[i].equals(disc)){
                for (int j=i; j<qtyOrdered; j++){
                    itemsOrdered[j]=itemsOrdered[j+1];
                }
            }
            itemsOrdered[qtyOrdered]=null;
            qtyOrdered--;
            System.out.println("xoa thanh cong");
        }
        System.out.println("dia ko co de xoa");
    }
    public float totalCost(){
        float total=0;
        for(int i=0; i<qtyOrdered; i++){
            total+=itemsOrdered[i].getCost();
        }
        return total;
    }
}