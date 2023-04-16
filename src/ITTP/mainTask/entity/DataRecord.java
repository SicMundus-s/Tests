package ITTP.mainTask.entity;

import java.util.Objects;

public class DataRecord {
    private long account;
    private String name;
    private double value;

    public DataRecord(long account, String name, double value) {
        this.account = account;
        this.name = name;
        this.value = value;
    }

    public long getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataRecord that = (DataRecord) o;

        if (account != that.account) return false;
        if (Double.compare(that.value, value) != 0) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (account ^ (account >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DataRecord{" +
               "account=" + account +
               ", name='" + name + '\'' +
               ", value=" + value +
               '}';
    }
}
