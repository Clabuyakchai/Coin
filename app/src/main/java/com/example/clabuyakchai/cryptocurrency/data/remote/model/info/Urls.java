
package com.example.clabuyakchai.cryptocurrency.data.remote.model.info;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("website")
    @Expose
    private List<String> website = null;
    @SerializedName("twitter")
    @Expose
    private List<String> twitter = null;
    @SerializedName("reddit")
    @Expose
    private List<String> reddit = null;
    @SerializedName("message_board")
    @Expose
    private List<String> messageBoard = null;
    @SerializedName("announcement")
    @Expose
    private List<String> announcement = null;
    @SerializedName("chat")
    @Expose
    private List<String> chat = null;
    @SerializedName("explorer")
    @Expose
    private List<String> explorer = null;
    @SerializedName("source_code")
    @Expose
    private List<String> sourceCode = null;

    public List<String> getWebsite() {
        return website;
    }

    public void setWebsite(List<String> website) {
        this.website = website;
    }

    public List<String> getTwitter() {
        return twitter;
    }

    public void setTwitter(List<String> twitter) {
        this.twitter = twitter;
    }

    public List<String> getReddit() {
        return reddit;
    }

    public void setReddit(List<String> reddit) {
        this.reddit = reddit;
    }

    public List<String> getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(List<String> messageBoard) {
        this.messageBoard = messageBoard;
    }

    public List<String> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<String> announcement) {
        this.announcement = announcement;
    }

    public List<String> getChat() {
        return chat;
    }

    public void setChat(List<String> chat) {
        this.chat = chat;
    }

    public List<String> getExplorer() {
        return explorer;
    }

    public void setExplorer(List<String> explorer) {
        this.explorer = explorer;
    }

    public List<String> getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(List<String> sourceCode) {
        this.sourceCode = sourceCode;
    }

}
