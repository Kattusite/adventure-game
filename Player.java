public class Player {
    final static int MAX_ITEMS = 5;
    private String name;
    private int currentHealth;
    private int maxHealth;
    private Item[] inventory;
    
    public Player(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.inventory = new Item[MAX_ITEMS];
    }
    
    // Getter methods
    public String name() {
        return name;
    }
    public int health() {
        return currentHealth;
    }
    public Item[] inventory() {
        return inventory;
    }
    
    
    public String toString() {
        return name + ": " + currentHealth + " / " + maxHealth + " HP";
    }
    
    public static void main(String[] args) {
        Player p = new Player("fred", 100);
        System.out.println(p);
        System.out.println(p.name());
        
        
        
    }
    
}