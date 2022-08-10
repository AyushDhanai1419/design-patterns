
public class FiftyNoteINR implements Chain{

private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.FIFTY)) {
			int notesOfRs50 = curr.getAmount() / Integer.parseInt(StringConstant.FIFTY);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.FIFTY);
			
			System.out.println(" Dispensing " +notesOfRs50+" notes of 50 ");
			
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
