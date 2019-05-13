package RaidenMapTokenInfo;

import RaidenMapTokenInfo.TokenInfoAPI.MarketData;
import RaidenMapTokenInfo.TokenInfoAPI.TokenInfo;
import RaidenMapTokenInfo.TokenNameAPI.TokenName;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import io.raidenmap.statecacher.Token;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;

public class TokenInfoBuilder {
    private static final String tokenNotRegistered = "tokenNotRegistered";
    private static Token.Builder tokenBuilder = Token.newBuilder(new Token(tokenNotRegistered, "", "", 0d, 0d, 0d, 0f, 0f, 0f, 0f, 0f, 0f, 0d, 0d, 0l));

    public static Token createToken(){
        return  tokenBuilder.build();
    }

    public static Token buildToken(String ethAddress) {
        String ID = getTokenID(ethAddress);
        if (ID.equals(tokenNotRegistered))
            return buildDefaultToken();
        else
            return buildDefaultToken(); //return buildRegisteredToken(ethAddress);
    }

    public static Token buildTokenByTag(String tag) {

        if (tag.equals(tokenNotRegistered))
            return buildDefaultToken();
        else
            return buildDefaultToken();//return buildRegisteredToken(tag);
    }

    private static Token buildDefaultToken() {
        tokenBuilder.setName(tokenNotRegistered);
        Token token = tokenBuilder.build();
        token.setName(tokenNotRegistered);
        return token;
    }

    public static Token buildRegisteredToken(String ethAddress) {
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
        TokenName t;
        try {
            HttpResponse<JsonNode> response = Unirest.
                    get("https://api.etherscan.io/api?module=account&action=tokentx&contractaddress={ethAddress}&page=1&offset=1")
                    .routeParam("ethAddress", ethAddress)
                    .asJson();
            responseBody = response.getBody().getObject();
        } catch (Exception e) {
        }
        try {
            t = gson.fromJson(((JSONObject) responseBody).toString(), TokenName.class);
        } catch (JsonSyntaxException e) {
            return tokenNotRegistered;
        }
        return tokenNotRegistered;
        //return t.getResult().get(0).getTokenName().toLowerCase();
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
        if (((JSONArray) responseBody.get("result")).length() == 0)
            return new TokenInfo("Unregistered ERC20");
        else
            return tokenInfo;
    }

    public static Double getPrice(String coinName, String symbolValue) {
        JSONObject responseBody = new JSONObject();
        try {
            HttpResponse<JsonNode> response = Unirest.
                    get("https://api.coingecko.com/api/v3/simple/price?ids={coinName}&vs_currencies={symbolValue}")
                    .routeParam("coinName", coinName)
                    .routeParam("symbolValue", symbolValue)
                    .asJson();
            responseBody = response.getBody().getObject();

        } catch (Exception e) {
            System.out.println("NOT FOUND");

        }
        responseBody = (JSONObject) responseBody.get(coinName);
        return (Double)responseBody.get(symbolValue);
    }

    private static Gson gson = new Gson();
}