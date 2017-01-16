public class Player {
    final static int MAX_ITEMS = 5; // inventory class depends on this
    private String name;
    private int currentHealth;
    private int maxHealth;
    private Inventory inventory;
    private GUIFrame gui;
    
    // Creates a new player with given name, full health, and access to the gui.
    public Player(String name, int maxHealth, GUIFrame gui) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.inventory = new Inventory(gui.inv);
        this.gui = gui;
    }
    
    // Getter methods
    public String name() {
        return name;
    }
    public int health() {
        return currentHealth;
    }
    public Inventory inventory() {
        return inventory;
    }
    
    
    public String toString() {
        return name + ": " + currentHealth + " / " + maxHealth + " HP";
    }
    
    public static void main(String[] args) {
        Player p = new Player("fred", 100, new GUIFrame());
        p.gui.out.println(p);
        p.inventory.add(new Item("steel sword"));
        p.inventory.add(new Item("wood sword"));
        p.inventory.add(new Item("lol doesn't exist"));
        
        
        
    }
    
}