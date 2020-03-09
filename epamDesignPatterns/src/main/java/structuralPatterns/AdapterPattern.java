package structuralPatterns;

import java.io.BufferedReader;
import java.io.InputStreamReader;

interface CreditCard {
	public void giveBankDetails();

	public String getCreditCard();
}

class BankDetails {
	private String bankName;
	private String accHolderName;
	private long accNumber;

	public void setBankName(String bName) {
		this.bankName = bName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setAccHolderName(String acName) {
		this.accHolderName = acName;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}

	public long getAccNumber() {
		return accNumber;
	}

}

class BCustomer extends BankDetails implements CreditCard {
	public void giveBankDetails() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Enter the bank name :");
			String bankname = br.readLine();

			System.out.print("Enter the account holder name :");
			String customername = br.readLine();
			System.out.print("Enter the account number:");
			long accno = Long.parseLong(br.readLine());

			setAccHolderName(customername);
			setAccNumber(accno);
			setBankName(bankname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCreditCard() {
		long accno = getAccNumber();
		String accholdername = getAccHolderName();
		String bname = getBankName();
        String accname= accholdername.toUpperCase(); 
		return ("The Account Number ( " + accno + " ) is valid in *** " + bname
				+ " bank ***\nThe Account is authenticated for issuing Credit Card for *** " + accname +" ***");
	}
}

public class AdapterPattern {
	public static void main(String args[]) {
		CreditCard targetInterface = new BCustomer();
		targetInterface.giveBankDetails();
		System.out.print(targetInterface.getCreditCard());
	}
}
