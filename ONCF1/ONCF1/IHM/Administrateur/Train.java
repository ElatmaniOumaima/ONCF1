package Administrateur;
class Train {
    private String train;
    private String type;
    private double price;
    private String classe;

    public Train(String train, String type, double price, String classe) {
        this.train = train;
        this.type = type;
        this.price = price;
        this.classe = classe;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getTrainInfo() {
        return train + ", " + type + ", " + price + ", " + classe;
    }
}
