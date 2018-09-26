package com.example.myRetail.model.entity;

public class Price {

    private Double value;
    private String currency_code;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    @Override
    public int hashCode() {
        int result = 1;
        long valueLong = Double.doubleToLongBits(value);
        result = 31 * result + (int) (valueLong ^ (valueLong >>> 32));
        result = 31 * result + currency_code.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Price)) {
            return false;
        }

        Price p = (Price) obj;
        return this.currency_code.equals(p.currency_code)
                && this.value == p.value;
    }

    @Override
    public String toString() {
        return "currency_code: '" + this.currency_code + "', value: '" + this.value + "'";
    }

}
