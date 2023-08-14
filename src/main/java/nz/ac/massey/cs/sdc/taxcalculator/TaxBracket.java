package nz.ac.massey.cs.sdc.taxcalculator;

/**
 * Class representing a tax bracket.
 * @author jens dietrich
 */


public class TaxBracket {
    private double start = 0;
    private double end = 0;
    private double taxRate = 0;

    public TaxBracket(double start, double end, double taxRate) {
        this.start = start;
        this.end = end;
        this.taxRate = taxRate;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getEnd() {
        return end;
    }

    public void setEnd(double end) {
        this.end = end;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxBracket that = (TaxBracket) o;

        if (Double.compare(that.start, start) != 0) return false;
        if (Double.compare(that.end, end) != 0) return false;
        return Double.compare(that.taxRate, taxRate) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(start);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(end);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(taxRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
