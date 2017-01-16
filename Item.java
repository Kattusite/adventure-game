public class Item {
    static final int MAX_DURABILITY = 100;
    static final int BASE_DAMAGE = 1;
    private String name;
    private int durability;
    private int damage;
    private String[] ascii;
    
    public Item(String name) {
        this.name = name;
        this.durability = MAX_DURABILITY;
        this.damage = BASE_DAMAGE;
        ascii = ASCIIManager.get(name);
    }
    
    public String name() {
        return name;
    }
    
    public int durability() {
        return durability;
    }
    
    public int damage() {
        return damage;
    }
    
    public String[] ascii() {
        return ascii;
    }
}