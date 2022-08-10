
public class TwoHundredNoteINR implements Chain{

private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.TWO_HUNDRED)) {
			int notesOfRs200 = curr.getAmount() / Integer.parseInt(StringConstant.TWO_HUNDRED);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.TWO_HUNDRED);
			
			System.out.println(" Dispensing " +notesOfRs200+" notes of 200 ");
			
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
