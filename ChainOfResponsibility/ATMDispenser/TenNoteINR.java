
public class TenNoteINR implements Chain{

private Chain nextInChain;
	
	@Override
	public void nextInChain(Chain chain) {
		this.nextInChain = chain;
	}

	@Override
	public void fetchNotes(Currency curr) {
		
		if(curr.getAmount()>=Integer.parseInt(StringConstant.TEN)) {
			int notesOfRs10 = curr.getAmount() / Integer.parseInt(StringConstant.TEN);
			int remainder = curr.getAmount() % Integer.parseInt(StringConstant.TEN);
			
			System.out.println(" Dispensing " +notesOfRs10+" notes of 10 ");
			
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
