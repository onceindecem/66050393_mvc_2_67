package mvc_2_67.Model;

public abstract class SuperheroSuit implements SuperheroSuitInterface {
    private String id;
    private String type;
    private int durability;

    public SuperheroSuit(String id, String type, int durability) {
        this.id = id;
        this.type = type;
        this.durability = durability;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public int getDurability() { return durability; }

    public void repair() {
        durability = Math.min(durability + 25, 100);
    }

}
