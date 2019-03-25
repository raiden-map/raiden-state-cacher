
package RaidenMapTokenInfo.TokenInfoAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReposUrl {

    @SerializedName("github")
    @Expose
    private List<String> github = null;
    @SerializedName("bitbucket")
    @Expose
    private List<Object> bitbucket = null;

    public List<String> getGithub() {
        return github;
    }

    public void setGithub(List<String> github) {
        this.github = github;
    }

    public List<Object> getBitbucket() {
        return bitbucket;
    }

    public void setBitbucket(List<Object> bitbucket) {
        this.bitbucket = bitbucket;
    }

}
