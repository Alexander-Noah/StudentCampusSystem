import java.util.Date;

public class Device {
    private int id;
    private String code;
    private String name;
    private Date productionDate;
    private double price;

    public Device(String code, String name, Date productionDate, double price) {
        this.code = code;
        this.name = name;
        this.productionDate = productionDate;
        this.price = price;
    }

    public Device() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getProductionDate() { return productionDate; }
    public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}