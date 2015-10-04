// R10 Assignment
// Author: Connor Shea
// Date:   10/7/2015
// Class:  CS160
// Email:  coshea@cs.colostate.edu
// http://www.cs.colostate.edu/~cs160/.Fall15/recitations/R10.html

public class McDonalds {

  // Enumerations
  public enum SodaFlavor { Nothing, Coke, Pepsi, Sprite };
  public enum SodaSize { Nothing, Small, Medium, Large };
  public enum Sandwich { Nothing, BigMac, QuarterPounder, FiletOfFish };
  public enum SideOrder { Nothing, FrenchFries, OnionRings };
  
  private SodaFlavor sodaFlavor;
  private SodaSize sodaSize;
  private Sandwich sandwich;
  private SideOrder side;

  // Constructor
  public McDonalds() {
    sodaFlavor = SodaFlavor.Nothing;
    sodaSize = SodaSize.Nothing;
    sandwich = Sandwich.Nothing;
    side = SideOrder.Nothing;
  }

  // Entry point with test code
  public static void main(String[] args) {

    McDonalds myMeal = new McDonalds();
    myMeal.chooseDrink(SodaFlavor.Coke, SodaSize.Medium);
    myMeal.chooseMeal(Sandwich.QuarterPounder, SideOrder.OnionRings);
    System.out.println(myMeal.toString());

    McDonalds specialMeal = new McDonalds();
    specialMeal.chooseDrink(SodaFlavor.Coke, SodaSize.Medium);
    specialMeal.chooseMeal(Sandwich.BigMac, SideOrder.FrenchFries);
    System.out.println(specialMeal.toString());

    McDonalds noDrink = new McDonalds();
    noDrink.chooseDrink(SodaFlavor.Nothing, SodaSize.Nothing);
    noDrink.chooseMeal(Sandwich.FiletOfFish, SideOrder.FrenchFries);
    System.out.println(noDrink.toString());
  }

  // Setters
  public void chooseDrink(SodaFlavor flavor, SodaSize size) {
    sodaFlavor = flavor;
    sodaSize = size;
  }
  public void chooseMeal(Sandwich type, SideOrder order) {
    sandwich = type;
    side = order;
  }
  
  // Print order
  public String toString() {
    
    // Compute cost
    double cost = calculateCost();
    
    // Create output
    String s = "";

    s += "Drink Flavor: " + sodaFlavor + "\n";
    s += "Drink Size: " + sodaSize + "\n";
    s += "Sandwich Type: " + sandwich + "\n";
    s += "Side Order: " + side + "\n";
    s += "Cost of Order: $" + cost + "\n";

    return s;
  }
  
  // Calculate cost
  public double calculateCost() {
    double cost = 0.0;

    if (sodaSize == SodaSize.Medium && sandwich == Sandwich.BigMac && side == SideOrder.FrenchFries) {
      cost = 4.39;
      return cost;
    }

    // Compute soda cost
    switch (sodaSize) {
      case Small:
        cost += 0.79;
        break;
      case Medium:
        cost += 0.99;
        break;
      case Large:
        cost += 1.19;
        break;
      default:
        break;
    }
    
    // Compute sandwich cost
    switch (sandwich) {
      case BigMac:
        cost += 3.79;
        break;
      case QuarterPounder:
        cost += 4.09;
        break;
      case FiletOfFish:
        cost += 2.89;
        break;
      default:
        break;
    }

    // Compute side cost
    if (side != SideOrder.Nothing) {
        cost += 1.59;
    }

    return cost;
  }
}
