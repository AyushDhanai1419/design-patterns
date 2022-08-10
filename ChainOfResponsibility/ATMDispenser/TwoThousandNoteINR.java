
public class TwoThousandNoteINR implements Chain{
	
	private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.TWO_THOUSAND)) {
			
			int notesOfRs2000 = curr.getAmount() / Integer.parseInt(StringConstant.TWO_THOUSAND);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.TWO_THOUSAND);
			
			System.out.println(" Dispensing " +notesOfRs2000+" notes of 2000 ");
			
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
