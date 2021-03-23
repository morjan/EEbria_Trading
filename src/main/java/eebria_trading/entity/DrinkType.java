package eebria_trading.entity;

public enum DrinkType {
    beer("beer"),
    cider("cider");

    private String label;

    public String getLabel() {
        return this.label;
    }

    private DrinkType(String label) {
        this.label = label;
    }
}
