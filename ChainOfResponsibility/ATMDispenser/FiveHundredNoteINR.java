
public class FiveHundredNoteINR implements Chain{

private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.FIVE_HUNDRED)) {
			int notesOfRs500 = curr.getAmount() / Integer.parseInt(StringConstant.FIVE_HUNDRED);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.FIVE_HUNDRED);
			
			System.out.println(" Dispensing " +notesOfRs500+" notes of 500 ");
			
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
