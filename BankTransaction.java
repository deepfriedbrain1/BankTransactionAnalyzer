import java.time.LocalDate;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + "'}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        BankTransaction otherBankTransaction = (BankTransaction) o;

        return Double.compare(otherBankTransaction.amount, amount) == 0 &&
                date.equals(otherBankTransaction.date) &&
                description.equals(otherBankTransaction.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(date, amount, description);
    }

}
