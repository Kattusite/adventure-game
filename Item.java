public class Item {
    static final int MAX_DURABILITY = 100;
    static final int BASE_DAMAGE = 1;
    String name;
    int durability;
    int damage;
    
    public Item(String name) {
        this.name = name;
        this.durability = MAX_DURABILITY;
        this.damage = BASE_DAMAGE;
    }
    
}