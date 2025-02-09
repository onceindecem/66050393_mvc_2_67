package mvc_2_67.Model;

public class PowerSuit extends SuperheroSuit {
    public PowerSuit(String id, int durability) {
        super(id, "ชุดทรงพลัง", durability);
    }
    
    @Override
    public boolean checkIfNeedRepair() {
        return this.getDurability() < 70;
    }
}
