package mvc_2_67.Model;

public class ConcealSuit extends SuperheroSuit {
    public ConcealSuit(String id, int durability) {
        super(id, "ชุดปกปิดตัวตน", durability);
    }
    
    @Override
    public boolean checkIfNeedRepair() {
        return this.getDurability() % 10 == 3 || this.getDurability() % 10 == 7;
    }
}
