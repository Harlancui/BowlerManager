package cn.harlan.entity;

public class ItemRecords {
    private int id;
    private int item_id;
    private String whobuy;
    private String whosell;
    private int year;
    private int month;
    private int day;
    private int number;
    private double allprice;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getWhobuy() {
        return whobuy;
    }

    public void setWhobuy(String whobuy) {
        this.whobuy = whobuy;
    }

    public String getWhosell() {
        return whosell;
    }

    public void setWhosell(String whosell) {
        this.whosell = whosell;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAllprice() {
        return allprice;
    }

    public void setAllprice(double allprice) {
        this.allprice = allprice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ItemRecords{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", whobuy='" + whobuy + '\'' +
                ", whosell='" + whosell + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", number=" + number +
                ", allprice=" + allprice +
                ", phone='" + phone + '\'' +
                '}';
    }
}
