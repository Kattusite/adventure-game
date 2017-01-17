/*
 * This class controls inventory management.
 * It consists of an array of items and an invPanel in which
 * to display them to the user. These two objects should be kept in sync.
 * 
 */
public class Inventory {
    
    private static String sep = "\u2502"; // LIGHT VERTICAL 
    private static String nullPlaceholder = "    "; // 4 spaces for no item
    private Item[] items;
    private GamePanel invPanel;
    private String[] ascii;
    private int capacity;
    private int size;
    
    public Inventory(GamePanel gp) {
        items = new Item[Player.MAX_ITEMS];
        invPanel = gp;
        ascii = new String[GameConstants.GUI_CHAR_HEIGHTS[GameConstants.INV]];
        capacity = Player.MAX_ITEMS;
        size = 0;
    }  
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    // Remove an item by index. 
    public void remove(int index) {
        items[index] = null;
        size--;
        updateGUI();
    }
    
    // takes linear time! this is not ideal
    public void remove(Item item) {
        for (int k = 0; k < items.length; k++) {
            if (items[k] == item) {
                items[k] = null;
                size--;
                updateGUI();
                return;
            }
        }
        // item not found
        return;
    }
    
    // takes linear time! this is not ideal
    // Adds an item to the items array and updates the ascii image.
    // Does nothing if all available slots are full.
    public void add(Item item) {
        if (isFull()) {
            return; // no space available.
        }
        for (int k = 0; k < items.length; k++) {
            if (items[k] == null) {
                size++;
                items[k] = item;
                updateGUI();
                return; // if item was successfully added
            }
        }
        // this should never be reached
    }
    
    // Given two indices, swap the items at those indices.
    public void swapItems(int indA, int indB) {
        Item temp = items[indA];
        items[indA] = items[indB];
        items[indB] = temp;
        updateGUI();
    }
    
    // EXTREMELY BUGGY FIRST DRAFT
    
    // Clears the invPanel, and reprints the 
    private void updateGUI() {
        updateASCII(); // sync the item array with the ascii representation
        clearGUI();   // clear the old ascii art out of the box
        printASCII(); // print the new ascii art into the box
    }
    
    // Updates the value of the ascii array based on the items in the item array
    // NOTE: Does not update the GUI output!
    private void updateASCII() {
        // Generate output row by row
        for (int k = 0; k < ascii.length; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < items.length; i++) {
                // If the itemslot is empty append a placeholder
                if (items[i] != null) {
                    sb.append(items[i].ascii()[k]);
                }
                else {
                    sb.append(nullPlaceholder);
                }
                // Add a vertical separator for all but the last item.
                if (i != items.length - 1) {
                    sb.append(sep);
                }
            }
            // Store the newly generated text in ascii.
            ascii[k] = sb.toString();
        }
    }
    
    // Prints the ascii array to the GamePanel. 
    // Assumes it has already been cleared 
    private void printASCII() {
        for (int k = 0; k < ascii.length; k++) {
            invPanel.print(ascii[k]);
            // Print line separators for all but the last row of output
            if (k != ascii.length - 1) {
                invPanel.println();
            }
        }
    }
    
    private void clearGUI() {
        invPanel.clear();
    }
    
}