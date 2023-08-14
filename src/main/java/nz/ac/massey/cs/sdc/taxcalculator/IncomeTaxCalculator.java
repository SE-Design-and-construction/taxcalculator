package nz.ac.massey.cs.sdc.taxcalculator;
/**
 * A simple tax calculator implementing the NZ tax rules accourding to 
 * http://www.ird.govt.nz/how-to/taxrates-codes/itaxsalaryandwage-incometaxrates.html
 * accessed on 9 August 12
 * @author jens dietrich
 */
public class IncomeTaxCalculator {

	public double calculateIncomeTax(double income) {
		// disable the next line to introduce an artificial delay - this will cause test cases with timeouts to fail
		// try {Thread.sleep(200);} catch (Exception x){}
		if (income<0) throw new IllegalArgumentException("the income must be positive");
        TaxBracket[] brackets = MasterDataReader.getTaxBrackets();
		double tax = 0.0;
		for (TaxBracket bracket:brackets) {
			if (income>bracket.getStart()) {
				double taxableInThisBracket = income>bracket.getEnd()?bracket.getEnd()- bracket.getStart():income-bracket.getStart();
				tax = tax + taxableInThisBracket*bracket.getTaxRate()/100;
			}
		}
		return tax;
	}

}
