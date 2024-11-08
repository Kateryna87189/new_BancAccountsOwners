/*
BankAccount {Person owner, String IBAN, double balance).
 */
public class BankAccount {
    private Person owner;
    private String IBAN;
    private double balans;

    public BankAccount(Person owner, String IBAN, double balans) {
        this.owner = owner;
        this.IBAN = IBAN;
        this.balans = balans;
    }

    public Person getOwner() {
        return owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalans() {
        return balans;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f Euro", owner, IBAN, balans);
    }
}
