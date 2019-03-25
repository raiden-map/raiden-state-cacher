package RaidenMapTokenInfo;

import RaidenMapTokenInfo.TokenInfoAPI.MarketData;
import RaidenMapTokenInfo.TokenInfoAPI.TokenInfo;
import RaidenMapTokenInfo.TokenNameAPI.TokenName;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import io.raidenmap.statecacher.Token;
import org.json.JSONObject;

import java.time.Instant;

public class TokenInfoBuilder {

    public static Token buildToken(String ethAddress) {
        String ID = getTokenID(ethAddress);
        TokenInfo tokenInfo = getTokenInfo(ID);
        MarketData md = tokenInfo.getMarketData();

        Token token = new Token();
        token.setName(ID);
        token.setTag(tokenInfo.getSymbol());
        token.setImageUrl(tokenInfo.getImage().getLarge());

        token.setValueBtc(md.getCurrentPrice().getBtc());
        token.setValueEth(md.getCurrentPrice().getEth());
        token.setValueUsd(md.getCurrentPrice().getUsd());

        token.setPriceChangeDayBtc(md.getPriceChangePercentage24hInCurrency().getBtc().floatValue());
        token.setPriceChangeDayEth(md.getPriceChangePercentage24hInCurrency().getEth().floatValue());
        token.setPriceChangeDayUsd(md.getPriceChangePercentage24hInCurrency().getUsd().floatValue());

        token.setPriceChangeWeekBtc(md.getPriceChangePercentage7dInCurrency().getBtc().floatValue());
        token.setPriceChangeWeekEth(md.getPriceChangePercentage7dInCurrency().getEth().floatValue());
        token.setPriceChangeWeekUsd(md.getPriceChangePercentage7dInCurrency().getUsd().floatValue());

        token.setMarketCap(md.getMarketCap().getUsd());
        token.setVolume(md.getMarketCap().getUsd());
        token.setTimestamp(Instant.now().toEpochMilli());

        return token;
    }

    public static String getTokenID(String ethAddress) {
        JSONObject responseBody = new JSONObject();
        try {
            HttpResponse<JsonNode> response = Unirest.
                    get("https://api.etherscan.io/api?module=account&action=tokentx&contractaddress={ethAddress}&page=1&offset=1")
                    .routeParam("ethAddress", ethAddress)
                    .asJson();
            responseBody = response.getBody().getObject();
        } catch (Exception e) {
        }
        TokenName t = gson.fromJson(((JSONObject) responseBody).toString(), TokenName.class);
        String ID = t.getResult().get(0).getTokenName().toLowerCase();
        return ID;
    }

    protected static TokenInfo getTokenInfo(String tokenID) {
        JSONObject responseBody = new JSONObject();
        try {
            HttpResponse<JsonNode> response = Unirest.
                    get("https://api.coingecko.com/api/v3/coins/{tokenID}")
                    .routeParam("tokenID", tokenID)
                    .asJson();
            responseBody = response.getBody().getObject();
        } catch (Exception e) {
        }

        TokenInfo tokenInfo = gson.fromJson(((JSONObject) responseBody).toString(), TokenInfo.class);
        return tokenInfo;
    }

    private static Gson gson = new Gson();
}