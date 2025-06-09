import java.util.Date;

public class Device {
    private int id;
    private String deviceNo;
    private String name;
    private Date productionDate;
    private double price;

    public Device() {}

    public Device(String deviceNo, String name, Date productionDate, double price) {
        this.deviceNo = deviceNo;
        this.name = name;
        this.productionDate = productionDate;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDeviceNo() { return deviceNo; }
    public void setDeviceNo(String deviceNo) { this.deviceNo = deviceNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getProductionDate() { return productionDate; }
    public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}