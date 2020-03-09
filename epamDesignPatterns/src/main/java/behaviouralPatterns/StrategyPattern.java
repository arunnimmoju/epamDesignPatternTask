package behaviouralPatterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Strategy {

	public float calculation(float a, float b);

}

class Addition implements Strategy {

	public float calculation(float a, float b) {
		return a + b;
	}

}

class Subtraction implements Strategy {

	public float calculation(float a, float b) {
		return a - b;
	}

}

class Multiplication implements Strategy {

	public float calculation(float a, float b) {
		return a * b;
	}
}

class Context {

	private Strategy st;

	public Context(Strategy strategy) {
		this.st = strategy;
	}

	public float executeStrategy(float num1, float num2) {
		return st.calculation(num1, num2);
	}
}

public class StrategyPattern {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the first value: ");
		float value1 = Float.parseFloat(br.readLine());

		System.out.print("Enter the second value: ");
		float value2 = Float.parseFloat(br.readLine());

		Context context = new Context(new Addition());
		System.out.println("Addition : " + context.executeStrategy(value1, value2));

		context = new Context(new Subtraction());
		System.out.println("Subtraction : " + context.executeStrategy(value1, value2));

		context = new Context(new Multiplication());
		System.out.println("Multiplication : " + context.executeStrategy(value1, value2));
	}

}
