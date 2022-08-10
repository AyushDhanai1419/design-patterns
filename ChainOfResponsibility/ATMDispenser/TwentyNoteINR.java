
public class TwentyNoteINR implements Chain{

private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.TWENTY)) {
			int notesOfRs20 = curr.getAmount() / Integer.parseInt(StringConstant.TWENTY);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.TWENTY);
			
			System.out.println(" Dispensing " +notesOfRs20+" notes of 20 ");
			
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
