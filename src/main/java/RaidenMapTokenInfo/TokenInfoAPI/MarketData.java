
package RaidenMapTokenInfo.TokenInfoAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketData {

    @SerializedName("current_price")
    @Expose
    private CurrentPrice currentPrice;
    @SerializedName("roi")
    @Expose
    private Object roi;
    @SerializedName("ath")
    @Expose
    private Ath ath;
    @SerializedName("ath_change_percentage")
    @Expose
    private AthChangePercentage athChangePercentage;
    @SerializedName("ath_date")
    @Expose
    private AthDate athDate;
    @SerializedName("market_cap")
    @Expose
    private MarketCap marketCap;
    @SerializedName("market_cap_rank")
    @Expose
    private Integer marketCapRank;
    @SerializedName("total_volume")
    @Expose
    private TotalVolume totalVolume;
    @SerializedName("high_24h")
    @Expose
    private High24h high24h;
    @SerializedName("low_24h")
    @Expose
    private Low24h low24h;
    @SerializedName("price_change_24h")
    @Expose
    private String priceChange24h;
    @SerializedName("price_change_percentage_24h")
    @Expose
    private String priceChangePercentage24h;
    @SerializedName("price_change_percentage_7d")
    @Expose
    private String priceChangePercentage7d;
    @SerializedName("price_change_percentage_14d")
    @Expose
    private String priceChangePercentage14d;
    @SerializedName("price_change_percentage_30d")
    @Expose
    private String priceChangePercentage30d;
    @SerializedName("price_change_percentage_60d")
    @Expose
    private String priceChangePercentage60d;
    @SerializedName("price_change_percentage_200d")
    @Expose
    private String priceChangePercentage200d;
    @SerializedName("price_change_percentage_1y")
    @Expose
    private String priceChangePercentage1y;
    @SerializedName("market_cap_change_24h")
    @Expose
    private String marketCapChange24h;
    @SerializedName("market_cap_change_percentage_24h")
    @Expose
    private String marketCapChangePercentage24h;
    @SerializedName("price_change_24h_in_currency")
    @Expose
    private PriceChange24hInCurrency priceChange24hInCurrency;
    @SerializedName("price_change_percentage_1h_in_currency")
    @Expose
    private PriceChangePercentage1hInCurrency priceChangePercentage1hInCurrency;
    @SerializedName("price_change_percentage_24h_in_currency")
    @Expose
    private PriceChangePercentage24hInCurrency priceChangePercentage24hInCurrency;
    @SerializedName("price_change_percentage_7d_in_currency")
    @Expose
    private PriceChangePercentage7dInCurrency priceChangePercentage7dInCurrency;
    @SerializedName("price_change_percentage_14d_in_currency")
    @Expose
    private PriceChangePercentage14dInCurrency priceChangePercentage14dInCurrency;
    @SerializedName("price_change_percentage_30d_in_currency")
    @Expose
    private PriceChangePercentage30dInCurrency priceChangePercentage30dInCurrency;
    @SerializedName("price_change_percentage_60d_in_currency")
    @Expose
    private PriceChangePercentage60dInCurrency priceChangePercentage60dInCurrency;
    @SerializedName("price_change_percentage_200d_in_currency")
    @Expose
    private PriceChangePercentage200dInCurrency priceChangePercentage200dInCurrency;
    @SerializedName("price_change_percentage_1y_in_currency")
    @Expose
    private PriceChangePercentage1yInCurrency priceChangePercentage1yInCurrency;
    @SerializedName("market_cap_change_24h_in_currency")
    @Expose
    private MarketCapChange24hInCurrency marketCapChange24hInCurrency;
    @SerializedName("market_cap_change_percentage_24h_in_currency")
    @Expose
    private MarketCapChangePercentage24hInCurrency marketCapChangePercentage24hInCurrency;
    @SerializedName("total_supply")
    @Expose
    private Integer totalSupply;
    @SerializedName("circulating_supply")
    @Expose
    private String circulatingSupply;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Object getRoi() {
        return roi;
    }

    public void setRoi(Object roi) {
        this.roi = roi;
    }

    public Ath getAth() {
        return ath;
    }

    public void setAth(Ath ath) {
        this.ath = ath;
    }

    public AthChangePercentage getAthChangePercentage() {
        return athChangePercentage;
    }

    public void setAthChangePercentage(AthChangePercentage athChangePercentage) {
        this.athChangePercentage = athChangePercentage;
    }

    public AthDate getAthDate() {
        return athDate;
    }

    public void setAthDate(AthDate athDate) {
        this.athDate = athDate;
    }

    public MarketCap getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(MarketCap marketCap) {
        this.marketCap = marketCap;
    }

    public Integer getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(Integer marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public TotalVolume getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(TotalVolume totalVolume) {
        this.totalVolume = totalVolume;
    }

    public High24h getHigh24h() {
        return high24h;
    }

    public void setHigh24h(High24h high24h) {
        this.high24h = high24h;
    }

    public Low24h getLow24h() {
        return low24h;
    }

    public void setLow24h(Low24h low24h) {
        this.low24h = low24h;
    }

    public String getPriceChange24h() {
        return priceChange24h;
    }

    public void setPriceChange24h(String priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    public String getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public void setPriceChangePercentage24h(String priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }

    public String getPriceChangePercentage7d() {
        return priceChangePercentage7d;
    }

    public void setPriceChangePercentage7d(String priceChangePercentage7d) {
        this.priceChangePercentage7d = priceChangePercentage7d;
    }

    public String getPriceChangePercentage14d() {
        return priceChangePercentage14d;
    }

    public void setPriceChangePercentage14d(String priceChangePercentage14d) {
        this.priceChangePercentage14d = priceChangePercentage14d;
    }

    public String getPriceChangePercentage30d() {
        return priceChangePercentage30d;
    }

    public void setPriceChangePercentage30d(String priceChangePercentage30d) {
        this.priceChangePercentage30d = priceChangePercentage30d;
    }

    public String getPriceChangePercentage60d() {
        return priceChangePercentage60d;
    }

    public void setPriceChangePercentage60d(String priceChangePercentage60d) {
        this.priceChangePercentage60d = priceChangePercentage60d;
    }

    public String getPriceChangePercentage200d() {
        return priceChangePercentage200d;
    }

    public void setPriceChangePercentage200d(String priceChangePercentage200d) {
        this.priceChangePercentage200d = priceChangePercentage200d;
    }

    public String getPriceChangePercentage1y() {
        return priceChangePercentage1y;
    }

    public void setPriceChangePercentage1y(String priceChangePercentage1y) {
        this.priceChangePercentage1y = priceChangePercentage1y;
    }

    public String getMarketCapChange24h() {
        return marketCapChange24h;
    }

    public void setMarketCapChange24h(String marketCapChange24h) {
        this.marketCapChange24h = marketCapChange24h;
    }

    public String getMarketCapChangePercentage24h() {
        return marketCapChangePercentage24h;
    }

    public void setMarketCapChangePercentage24h(String marketCapChangePercentage24h) {
        this.marketCapChangePercentage24h = marketCapChangePercentage24h;
    }

    public PriceChange24hInCurrency getPriceChange24hInCurrency() {
        return priceChange24hInCurrency;
    }

    public void setPriceChange24hInCurrency(PriceChange24hInCurrency priceChange24hInCurrency) {
        this.priceChange24hInCurrency = priceChange24hInCurrency;
    }

    public PriceChangePercentage1hInCurrency getPriceChangePercentage1hInCurrency() {
        return priceChangePercentage1hInCurrency;
    }

    public void setPriceChangePercentage1hInCurrency(PriceChangePercentage1hInCurrency priceChangePercentage1hInCurrency) {
        this.priceChangePercentage1hInCurrency = priceChangePercentage1hInCurrency;
    }

    public PriceChangePercentage24hInCurrency getPriceChangePercentage24hInCurrency() {
        return priceChangePercentage24hInCurrency;
    }

    public void setPriceChangePercentage24hInCurrency(PriceChangePercentage24hInCurrency priceChangePercentage24hInCurrency) {
        this.priceChangePercentage24hInCurrency = priceChangePercentage24hInCurrency;
    }

    public PriceChangePercentage7dInCurrency getPriceChangePercentage7dInCurrency() {
        return priceChangePercentage7dInCurrency;
    }

    public void setPriceChangePercentage7dInCurrency(PriceChangePercentage7dInCurrency priceChangePercentage7dInCurrency) {
        this.priceChangePercentage7dInCurrency = priceChangePercentage7dInCurrency;
    }

    public PriceChangePercentage14dInCurrency getPriceChangePercentage14dInCurrency() {
        return priceChangePercentage14dInCurrency;
    }

    public void setPriceChangePercentage14dInCurrency(PriceChangePercentage14dInCurrency priceChangePercentage14dInCurrency) {
        this.priceChangePercentage14dInCurrency = priceChangePercentage14dInCurrency;
    }

    public PriceChangePercentage30dInCurrency getPriceChangePercentage30dInCurrency() {
        return priceChangePercentage30dInCurrency;
    }

    public void setPriceChangePercentage30dInCurrency(PriceChangePercentage30dInCurrency priceChangePercentage30dInCurrency) {
        this.priceChangePercentage30dInCurrency = priceChangePercentage30dInCurrency;
    }

    public PriceChangePercentage60dInCurrency getPriceChangePercentage60dInCurrency() {
        return priceChangePercentage60dInCurrency;
    }

    public void setPriceChangePercentage60dInCurrency(PriceChangePercentage60dInCurrency priceChangePercentage60dInCurrency) {
        this.priceChangePercentage60dInCurrency = priceChangePercentage60dInCurrency;
    }

    public PriceChangePercentage200dInCurrency getPriceChangePercentage200dInCurrency() {
        return priceChangePercentage200dInCurrency;
    }

    public void setPriceChangePercentage200dInCurrency(PriceChangePercentage200dInCurrency priceChangePercentage200dInCurrency) {
        this.priceChangePercentage200dInCurrency = priceChangePercentage200dInCurrency;
    }

    public PriceChangePercentage1yInCurrency getPriceChangePercentage1yInCurrency() {
        return priceChangePercentage1yInCurrency;
    }

    public void setPriceChangePercentage1yInCurrency(PriceChangePercentage1yInCurrency priceChangePercentage1yInCurrency) {
        this.priceChangePercentage1yInCurrency = priceChangePercentage1yInCurrency;
    }

    public MarketCapChange24hInCurrency getMarketCapChange24hInCurrency() {
        return marketCapChange24hInCurrency;
    }

    public void setMarketCapChange24hInCurrency(MarketCapChange24hInCurrency marketCapChange24hInCurrency) {
        this.marketCapChange24hInCurrency = marketCapChange24hInCurrency;
    }

    public MarketCapChangePercentage24hInCurrency getMarketCapChangePercentage24hInCurrency() {
        return marketCapChangePercentage24hInCurrency;
    }

    public void setMarketCapChangePercentage24hInCurrency(MarketCapChangePercentage24hInCurrency marketCapChangePercentage24hInCurrency) {
        this.marketCapChangePercentage24hInCurrency = marketCapChangePercentage24hInCurrency;
    }

    public Integer getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Integer totalSupply) {
        this.totalSupply = totalSupply;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(String circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
