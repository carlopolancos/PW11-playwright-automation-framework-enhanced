package context;

public class PersonContext {

    private final ThreadLocal<String> randomFirstName = new ThreadLocal<>();
    private final ThreadLocal<String> randomLastName = new ThreadLocal<>();
    private final ThreadLocal<String> randomEmailAddress = new ThreadLocal<>();

    public String getRandomFirstName() {
        return randomFirstName.get();
    }

    public void setRandomFirstName(String randomFirstName) {
        this.randomFirstName.set(randomFirstName);
    }

    public String getRandomLastName() {
        return randomLastName.get();
    }

    public void setRandomLastName(String randomLastName) {
        this.randomLastName.set(randomLastName);
    }

    public String getRandomEmailAddress() {
        return randomEmailAddress.get();
    }

    public void setRandomEmailAddress(String randomEmailAddress) {
        this.randomEmailAddress.set(randomEmailAddress);
    }
}
