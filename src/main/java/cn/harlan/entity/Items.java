package cn.harlan.entity;


import java.util.Arrays;
import java.util.Date;

public class Items {
    private Integer id;
    private String itemname;
    private Double itemprice;
    private int number;
    private Date createtime;
    private String createuser;

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", itemname='" + itemname + '\'' +
                ", itemprice=" + itemprice +
                ", number=" + number +
                ", createtime=" + createtime +
                ", createuser='" + createuser + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Double getItemprice() {
        return itemprice;
    }

    public void setItemprice(Double itemprice) {
        this.itemprice = itemprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }
}

