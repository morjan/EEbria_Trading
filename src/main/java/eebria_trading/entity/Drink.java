package eebria_trading.entity;


public class Drink {
    private String name;
    private String image;
    private DrinkType type;
    private double price;


    public Drink() {}

    public Drink(String name, String image, DrinkType style, double price) {
        this.name = name;
        this.image = image;
        this.type = style;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", style=" + type +
                ", price=" + price +
                '}';
    }
}
