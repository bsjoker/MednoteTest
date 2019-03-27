
package bakay.stanislav.mednotetest.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stock {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("percent_change")
    @Expose
    private Float percentChange;
    @SerializedName("volume")
    @Expose
    private Integer volume;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Float getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(Float percentChange) {
        this.percentChange = percentChange;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
