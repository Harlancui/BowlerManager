package cn.harlan.entity;

import java.util.Date;

public class RealyUtil {
    private Date date;
    private Integer type;

    @Override
    public String toString() {
        return "RealyUtil{" +
                "date=" + date +
                ", type=" + type +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
