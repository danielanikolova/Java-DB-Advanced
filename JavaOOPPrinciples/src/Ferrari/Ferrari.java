package Ferrari;


public class Ferrari implements Car{

    String model;
    String driver;

    public Ferrari(String model, String driver) {
        this.model = model;
        this.driver = driver;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Ferrari() {
        super();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        String brakes = "Brakes!";
        return brakes;
    }

    @Override
    public String pushTheGas() {
        String gas = "Zadu6avam sA!";
        return gas;
    }
}
