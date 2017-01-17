import java.util.*;

public class EntityMonster{
  private String name;
  private int maxHealth;
  private int health;
  private Item[] drops;
  
public EntityMonster(String name, int maxHealth, Item[] drops){
  this.name = name;
  this.maxHealth = maxHealth;
  this.health= maxHealth;
  this.drops=drops;
  
}
//getter 
public String name(){
  return name;
}
public int health(){
  return health;
}
public Item[] drops(){
  double[] probability = {.1,.2,.4,.7};
  Item[] possibleDrops = new Item[probability.length];
  ArrayList<Item> output = new ArrayList<Item>();
  double probabilitySelector;
  
  for (int i = 0; i < possibleDrops.length; i++){
    probabilitySelector = Math.random();
    if (probabilitySelector < probability[i]){
      output.add(possibleDrops[i]);
    }            
  }
  Item[] out = output.toArray(new Item[output.size()]);
  return out;
}

}

