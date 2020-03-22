package de.mapaco.pstdigger.model;

public class ParseResponse {

    private int emailCount;
    private String lastEmailId;

    public ParseResponse(int emailCount, String lastEmailId) {
        this.emailCount = emailCount;
        this.lastEmailId = lastEmailId;
    }

    public int getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(int emailCount) {
        this.emailCount = emailCount;
    }

    public String getLastEmailId() {
        return lastEmailId;
    }

    public void setLastEmailId(String lastEmailId) {
        this.lastEmailId = lastEmailId;
    }
}
