package cn.harlan.entity;

import java.util.List;

public class End {
    List<ItemRecords> recordsList;
    Double cost;
    Double sell;

    @Override
    public String toString() {
        return "End{" +
                "recordsList=" + recordsList +
                ", cost=" + cost +
                ", sell=" + sell +
                '}';
    }

    public List<ItemRecords> getRecordsList() {
        return recordsList;
    }

    public void setRecordsList(List<ItemRecords> recordsList) {
        this.recordsList = recordsList;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }
}
