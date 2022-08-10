
public class OneHundredNoteINR implements Chain{

private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.ONE_HUNDRED)) {
			int notesOfRs100 = curr.getAmount() / Integer.parseInt(StringConstant.ONE_HUNDRED);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.ONE_HUNDRED);
			
			System.out.println(" Dispensing " +notesOfRs100+" notes of 100 ");
			
			if(remainder!=0) {
				Currency ncurr = new Currency(remainder);
				this.nextInChain.fetchNotes(ncurr);
			}
		}
		else {
			this.nextInChain.fetchNotes(curr);
		}
	}
}
