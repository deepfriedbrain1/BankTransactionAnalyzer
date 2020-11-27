
/**
 * A domain object storing statistical information
 */
public class SummaryStatistics {
    private final double sum,
                         max,
                         min,
                         average;

    public SummaryStatistics(final double sum, final double max, final double min, final double average){
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    public double getSum(){return sum;}
    public double getMax(){return max;}
    public double getMin(){return min;}
    public double getAverage(){return average;}


}
