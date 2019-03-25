
package RaidenMapTokenInfo.TokenInfoAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IcoData {

    @SerializedName("ico_start_date")
    @Expose
    private String icoStartDate;
    @SerializedName("ico_end_date")
    @Expose
    private String icoEndDate;
    @SerializedName("short_desc")
    @Expose
    private String shortDesc;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("links")
    @Expose
    private Links_ links;
    @SerializedName("softcap_currency")
    @Expose
    private String softcapCurrency;
    @SerializedName("hardcap_currency")
    @Expose
    private String hardcapCurrency;
    @SerializedName("total_raised_currency")
    @Expose
    private String totalRaisedCurrency;
    @SerializedName("softcap_amount")
    @Expose
    private Object softcapAmount;
    @SerializedName("hardcap_amount")
    @Expose
    private Object hardcapAmount;
    @SerializedName("total_raised")
    @Expose
    private String totalRaised;
    @SerializedName("quote_pre_sale_currency")
    @Expose
    private String quotePreSaleCurrency;
    @SerializedName("base_pre_sale_amount")
    @Expose
    private Object basePreSaleAmount;
    @SerializedName("quote_pre_sale_amount")
    @Expose
    private Object quotePreSaleAmount;
    @SerializedName("quote_public_sale_currency")
    @Expose
    private String quotePublicSaleCurrency;
    @SerializedName("base_public_sale_amount")
    @Expose
    private Object basePublicSaleAmount;
    @SerializedName("quote_public_sale_amount")
    @Expose
    private String quotePublicSaleAmount;
    @SerializedName("accepting_currencies")
    @Expose
    private String acceptingCurrencies;
    @SerializedName("country_origin")
    @Expose
    private String countryOrigin;
    @SerializedName("pre_sale_start_date")
    @Expose
    private Object preSaleStartDate;
    @SerializedName("pre_sale_end_date")
    @Expose
    private Object preSaleEndDate;
    @SerializedName("whitelist_url")
    @Expose
    private String whitelistUrl;
    @SerializedName("whitelist_start_date")
    @Expose
    private Object whitelistStartDate;
    @SerializedName("whitelist_end_date")
    @Expose
    private Object whitelistEndDate;
    @SerializedName("bounty_detail_url")
    @Expose
    private String bountyDetailUrl;
    @SerializedName("amount_for_sale")
    @Expose
    private Object amountForSale;
    @SerializedName("kyc_required")
    @Expose
    private Boolean kycRequired;
    @SerializedName("whitelist_available")
    @Expose
    private Object whitelistAvailable;
    @SerializedName("pre_sale_available")
    @Expose
    private Object preSaleAvailable;
    @SerializedName("pre_sale_ended")
    @Expose
    private Boolean preSaleEnded;

    public String getIcoStartDate() {
        return icoStartDate;
    }

    public void setIcoStartDate(String icoStartDate) {
        this.icoStartDate = icoStartDate;
    }

    public String getIcoEndDate() {
        return icoEndDate;
    }

    public void setIcoEndDate(String icoEndDate) {
        this.icoEndDate = icoEndDate;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public String getSoftcapCurrency() {
        return softcapCurrency;
    }

    public void setSoftcapCurrency(String softcapCurrency) {
        this.softcapCurrency = softcapCurrency;
    }

    public String getHardcapCurrency() {
        return hardcapCurrency;
    }

    public void setHardcapCurrency(String hardcapCurrency) {
        this.hardcapCurrency = hardcapCurrency;
    }

    public String getTotalRaisedCurrency() {
        return totalRaisedCurrency;
    }

    public void setTotalRaisedCurrency(String totalRaisedCurrency) {
        this.totalRaisedCurrency = totalRaisedCurrency;
    }

    public Object getSoftcapAmount() {
        return softcapAmount;
    }

    public void setSoftcapAmount(Object softcapAmount) {
        this.softcapAmount = softcapAmount;
    }

    public Object getHardcapAmount() {
        return hardcapAmount;
    }

    public void setHardcapAmount(Object hardcapAmount) {
        this.hardcapAmount = hardcapAmount;
    }

    public String getTotalRaised() {
        return totalRaised;
    }

    public void setTotalRaised(String totalRaised) {
        this.totalRaised = totalRaised;
    }

    public String getQuotePreSaleCurrency() {
        return quotePreSaleCurrency;
    }

    public void setQuotePreSaleCurrency(String quotePreSaleCurrency) {
        this.quotePreSaleCurrency = quotePreSaleCurrency;
    }

    public Object getBasePreSaleAmount() {
        return basePreSaleAmount;
    }

    public void setBasePreSaleAmount(Object basePreSaleAmount) {
        this.basePreSaleAmount = basePreSaleAmount;
    }

    public Object getQuotePreSaleAmount() {
        return quotePreSaleAmount;
    }

    public void setQuotePreSaleAmount(Object quotePreSaleAmount) {
        this.quotePreSaleAmount = quotePreSaleAmount;
    }

    public String getQuotePublicSaleCurrency() {
        return quotePublicSaleCurrency;
    }

    public void setQuotePublicSaleCurrency(String quotePublicSaleCurrency) {
        this.quotePublicSaleCurrency = quotePublicSaleCurrency;
    }

    public Object getBasePublicSaleAmount() {
        return basePublicSaleAmount;
    }

    public void setBasePublicSaleAmount(Object basePublicSaleAmount) {
        this.basePublicSaleAmount = basePublicSaleAmount;
    }

    public String getQuotePublicSaleAmount() {
        return quotePublicSaleAmount;
    }

    public void setQuotePublicSaleAmount(String quotePublicSaleAmount) {
        this.quotePublicSaleAmount = quotePublicSaleAmount;
    }

    public String getAcceptingCurrencies() {
        return acceptingCurrencies;
    }

    public void setAcceptingCurrencies(String acceptingCurrencies) {
        this.acceptingCurrencies = acceptingCurrencies;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public Object getPreSaleStartDate() {
        return preSaleStartDate;
    }

    public void setPreSaleStartDate(Object preSaleStartDate) {
        this.preSaleStartDate = preSaleStartDate;
    }

    public Object getPreSaleEndDate() {
        return preSaleEndDate;
    }

    public void setPreSaleEndDate(Object preSaleEndDate) {
        this.preSaleEndDate = preSaleEndDate;
    }

    public String getWhitelistUrl() {
        return whitelistUrl;
    }

    public void setWhitelistUrl(String whitelistUrl) {
        this.whitelistUrl = whitelistUrl;
    }

    public Object getWhitelistStartDate() {
        return whitelistStartDate;
    }

    public void setWhitelistStartDate(Object whitelistStartDate) {
        this.whitelistStartDate = whitelistStartDate;
    }

    public Object getWhitelistEndDate() {
        return whitelistEndDate;
    }

    public void setWhitelistEndDate(Object whitelistEndDate) {
        this.whitelistEndDate = whitelistEndDate;
    }

    public String getBountyDetailUrl() {
        return bountyDetailUrl;
    }

    public void setBountyDetailUrl(String bountyDetailUrl) {
        this.bountyDetailUrl = bountyDetailUrl;
    }

    public Object getAmountForSale() {
        return amountForSale;
    }

    public void setAmountForSale(Object amountForSale) {
        this.amountForSale = amountForSale;
    }

    public Boolean getKycRequired() {
        return kycRequired;
    }

    public void setKycRequired(Boolean kycRequired) {
        this.kycRequired = kycRequired;
    }

    public Object getWhitelistAvailable() {
        return whitelistAvailable;
    }

    public void setWhitelistAvailable(Object whitelistAvailable) {
        this.whitelistAvailable = whitelistAvailable;
    }

    public Object getPreSaleAvailable() {
        return preSaleAvailable;
    }

    public void setPreSaleAvailable(Object preSaleAvailable) {
        this.preSaleAvailable = preSaleAvailable;
    }

    public Boolean getPreSaleEnded() {
        return preSaleEnded;
    }

    public void setPreSaleEnded(Boolean preSaleEnded) {
        this.preSaleEnded = preSaleEnded;
    }

}
