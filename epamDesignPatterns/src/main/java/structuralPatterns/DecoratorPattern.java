package structuralPatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Food {
	public String prepareFood();

	public double foodPrice();
}

abstract class FoodDecorator implements Food {
	private Food newFood;

	public FoodDecorator(Food newFood) {
		this.newFood = newFood;
	}

	public String prepareFood() {
		return newFood.prepareFood();
	}

	public double foodPrice() {
		return newFood.foodPrice();
	}
}

class VegFood implements Food {
	public String prepareFood() {
		return "Vegetarian Food";
	}

	public double foodPrice() {
		return 100.0;
	}
}

class NonVegFood extends FoodDecorator {
	public NonVegFood(Food newFood) {
		super(newFood);
	}

	public String prepareFood() {
		return super.prepareFood() + " With Chiken Curry  ";
	}

	public double foodPrice() {
		return super.foodPrice() + 200.0;
	}
}

class ChineeseFood extends FoodDecorator {
	public ChineeseFood(Food newFood) {
		super(newFood);
	}

	public String prepareFood() {
		return super.prepareFood() + " With Manchurian  ";
	}

	public double foodPrice() {
		return super.foodPrice() + 150.0;
	}
}

public class DecoratorPattern {
	private static int choice;

	public static void main(String args[]) throws NumberFormatException, IOException {
		do {
			System.out.print("========= Food Menu ============ \n");
			System.out.print("            1. Vegetarian Food.   \n");
			System.out.print("            2. Non-Vegetarian Food.\n");
			System.out.print("            3. Chineese Food.         \n");
			System.out.print("            4. Exit                        \n");
			System.out.print("Enter your choice: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1: {
				VegFood vf = new VegFood();
				System.out.println(vf.prepareFood());
				System.out.println(vf.foodPrice() + " Rupees\n");
			}
				break;

			case 2: {
				Food f1 = new NonVegFood((Food) new VegFood());
				System.out.println(f1.prepareFood());
				System.out.println(f1.foodPrice() + " Rupees\n");
			}
				break;
			case 3: {
				Food f2 = new ChineeseFood((Food) new VegFood());
				System.out.println(f2.prepareFood());
				System.out.println(f2.foodPrice() + " Rupees\n");
			}
				break;

			default: {
				System.out.println("These are the only items available in our restaurent");
			}
				return;
			}

		} while (choice != 4);
	}
}
