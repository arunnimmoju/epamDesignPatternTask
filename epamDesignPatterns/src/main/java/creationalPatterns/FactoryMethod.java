package creationalPatterns;

import java.io.*;

abstract class Plan {
	protected double rate;

	abstract void getRate();

	public void calculateBill(int units) {
		System.out.println(units * rate);
	}
}

class DomesticPlan extends Plan {

	public void getRate() {
		rate = 2.50;
	}
}

class CommercialPlan extends Plan {

	public void getRate() {
		rate = 9.50;
	}

}

class InstitutionalPlan extends Plan {

	public void getRate() {
		rate = 6.50;
	}

}

class Plandetails {

	public Plan getPlan(int plan) {

		if (plan == 1) {
			return new DomesticPlan();
		} else if (plan == 2) {
			return new CommercialPlan();
		} else if (plan == 3) {
			return new InstitutionalPlan();
		} else {
			System.out.println("Enter valid option");
		}
		return null;
	}
}

class FactoryMethod {
	public static void main(String args[]) throws IOException {
		Plandetails planFactory = new Plandetails();

		System.out.print("Choose your Plan \n1.DomesticPlan\n2.CommercialPlan\n3.InstitutionalPlan\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int plan = Integer.parseInt(br.readLine());

		System.out.print("Enter the number of units for bill will be calculated: ");
		int units = Integer.parseInt(br.readLine());

		Plan p = planFactory.getPlan(plan);

		System.out.print("Total Bill" + units + " units is: ");
		p.getRate();
		p.calculateBill(units);
	}

}
