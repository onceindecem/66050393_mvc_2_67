package mvc_2_67.Model;

public class StealthSuit extends SuperheroSuit {
    public StealthSuit(String id, int durability) {
        super(id, "ชุดลอบเร้น", durability);
    }
    
    @Override
    public boolean checkIfNeedRepair() {
        return this.getDurability() < 50;
    }
}
