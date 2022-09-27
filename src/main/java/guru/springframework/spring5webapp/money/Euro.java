package guru.springframework.spring5webapp.money;

public class Euro {

    int amount;

    public Euro(int amount) {
        this.amount = amount;
    }
    Euro times(int multiplier) {
        return new Euro(amount * multiplier);
    }
}
