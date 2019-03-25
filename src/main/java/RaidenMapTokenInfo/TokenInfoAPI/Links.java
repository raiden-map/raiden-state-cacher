
package RaidenMapTokenInfo.TokenInfoAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links {

    @SerializedName("homepage")
    @Expose
    private List<String> homepage = null;
    @SerializedName("blockchain_site")
    @Expose
    private List<String> blockchainSite = null;
    @SerializedName("official_forum_url")
    @Expose
    private List<String> officialForumUrl = null;
    @SerializedName("chat_url")
    @Expose
    private List<String> chatUrl = null;
    @SerializedName("announcement_url")
    @Expose
    private List<String> announcementUrl = null;
    @SerializedName("twitter_screen_name")
    @Expose
    private String twitterScreenName;
    @SerializedName("facebook_username")
    @Expose
    private String facebookUsername;
    @SerializedName("bitcointalk_thread_identifier")
    @Expose
    private Object bitcointalkThreadIdentifier;
    @SerializedName("telegram_channel_identifier")
    @Expose
    private String telegramChannelIdentifier;
    @SerializedName("subreddit_url")
    @Expose
    private String subredditUrl;
    @SerializedName("repos_url")
    @Expose
    private ReposUrl reposUrl;

    public List<String> getHomepage() {
        return homepage;
    }

    public void setHomepage(List<String> homepage) {
        this.homepage = homepage;
    }

    public List<String> getBlockchainSite() {
        return blockchainSite;
    }

    public void setBlockchainSite(List<String> blockchainSite) {
        this.blockchainSite = blockchainSite;
    }

    public List<String> getOfficialForumUrl() {
        return officialForumUrl;
    }

    public void setOfficialForumUrl(List<String> officialForumUrl) {
        this.officialForumUrl = officialForumUrl;
    }

    public List<String> getChatUrl() {
        return chatUrl;
    }

    public void setChatUrl(List<String> chatUrl) {
        this.chatUrl = chatUrl;
    }

    public List<String> getAnnouncementUrl() {
        return announcementUrl;
    }

    public void setAnnouncementUrl(List<String> announcementUrl) {
        this.announcementUrl = announcementUrl;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public Object getBitcointalkThreadIdentifier() {
        return bitcointalkThreadIdentifier;
    }

    public void setBitcointalkThreadIdentifier(Object bitcointalkThreadIdentifier) {
        this.bitcointalkThreadIdentifier = bitcointalkThreadIdentifier;
    }

    public String getTelegramChannelIdentifier() {
        return telegramChannelIdentifier;
    }

    public void setTelegramChannelIdentifier(String telegramChannelIdentifier) {
        this.telegramChannelIdentifier = telegramChannelIdentifier;
    }

    public String getSubredditUrl() {
        return subredditUrl;
    }

    public void setSubredditUrl(String subredditUrl) {
        this.subredditUrl = subredditUrl;
    }

    public ReposUrl getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(ReposUrl reposUrl) {
        this.reposUrl = reposUrl;
    }

}
