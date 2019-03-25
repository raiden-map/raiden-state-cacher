
package RaidenMapTokenInfo.TokenInfoAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TokenInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("country_origin")
    @Expose
    private String countryOrigin;
    @SerializedName("genesis_date")
    @Expose
    private String genesisDate;
    @SerializedName("contract_address")
    @Expose
    private String contractAddress;
    @SerializedName("ico_data")
    @Expose
    private IcoData icoData;
    @SerializedName("market_cap_rank")
    @Expose
    private Integer marketCapRank;
    @SerializedName("coingecko_rank")
    @Expose
    private Integer coingeckoRank;
    @SerializedName("coingecko_score")
    @Expose
    private Double coingeckoScore;
    @SerializedName("developer_score")
    @Expose
    private Double developerScore;
    @SerializedName("community_score")
    @Expose
    private Double communityScore;
    @SerializedName("liquidity_score")
    @Expose
    private Double liquidityScore;
    @SerializedName("public_interest_score")
    @Expose
    private Double publicInterestScore;
    @SerializedName("market_data")
    @Expose
    private MarketData marketData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getGenesisDate() {
        return genesisDate;
    }

    public void setGenesisDate(String genesisDate) {
        this.genesisDate = genesisDate;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public IcoData getIcoData() {
        return icoData;
    }

    public void setIcoData(IcoData icoData) {
        this.icoData = icoData;
    }

    public Integer getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(Integer marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public Integer getCoingeckoRank() {
        return coingeckoRank;
    }

    public void setCoingeckoRank(Integer coingeckoRank) {
        this.coingeckoRank = coingeckoRank;
    }

    public Double getCoingeckoScore() {
        return coingeckoScore;
    }

    public void setCoingeckoScore(Double coingeckoScore) {
        this.coingeckoScore = coingeckoScore;
    }

    public Double getDeveloperScore() {
        return developerScore;
    }

    public void setDeveloperScore(Double developerScore) {
        this.developerScore = developerScore;
    }

    public Double getCommunityScore() {
        return communityScore;
    }

    public void setCommunityScore(Double communityScore) {
        this.communityScore = communityScore;
    }

    public Double getLiquidityScore() {
        return liquidityScore;
    }

    public void setLiquidityScore(Double liquidityScore) {
        this.liquidityScore = liquidityScore;
    }

    public Double getPublicInterestScore() {
        return publicInterestScore;
    }

    public void setPublicInterestScore(Double publicInterestScore) {
        this.publicInterestScore = publicInterestScore;
    }

    public MarketData getMarketData() {
        return marketData;
    }

    public void setMarketData(MarketData marketData) {
        this.marketData = marketData;
    }

}
