package cn.harlan.entity;

import java.util.Date;

public class ItemRecords {
    private int id;
    private int item_id;
    private String whobuy;
    private String whosell;
    private int number;
    private double allprice;
    private String phone;
    private Integer type;
    private Date time;

    @Override
    public String toString() {
        return "ItemRecords{" +
                "id=" + id +
                ", item_id=" + item_id +
                ", whobuy='" + whobuy + '\'' +
                ", whosell='" + whosell + '\'' +
                ", number=" + number +
                ", allprice=" + allprice +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", time=" + time +
                '}';
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
