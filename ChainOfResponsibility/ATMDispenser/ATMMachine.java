import java.util.Scanner;

public class ATMMachine {

	public static void main(String[] args) {
		
		
		Chain chain2000 = new TwoThousandNoteINR();
		Chain chain500 = new FiveHundredNoteINR();
		Chain chain200 = new TwoHundredNoteINR();
		Chain chain100 = new OneHundredNoteINR();
		Chain chain50 = new FiftyNoteINR();
		Chain chain20 = new TwentyNoteINR();
		Chain chain10 = new TenNoteINR();
		
		chain2000.nextInChain(chain500);
		chain500.nextInChain(chain200);
		chain200.nextInChain(chain100);
		chain100.nextInChain(chain50);
		chain50.nextInChain(chain20);
		chain20.nextInChain(chain10);
		
		System.out.println("...Welcome To ATM...");
		Scanner sc = new Scanner(System.in);
		System.out.println("...Enter Amount in Multiples of 10s...");
		int amount = sc.nextInt();
		
		try {
			chain2000.fetchNotes(new Currency(amount));
		}
		catch(NullPointerException e) {
			System.out.println("Please enter amount in multiples of 10s");
		}
	}

}
