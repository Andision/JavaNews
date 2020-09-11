package com.example.CONVID19News.background.bean;

public class timedata {
    private String confirmed;
    private String suspected;
    private String cured;
    private String dead;

    public String getConfirmed() {
        if(confirmed=="null")
            return "0";

        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getCured() {

        if(cured=="null")
            return "0";
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getDead() {
        if(dead=="null")
            return "0";

        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getSuspected() {
        if(suspected=="null")
            return "0";

        return suspected;
    }

    public void setSuspected(String suspected) {
        this.suspected = suspected;
    }
}
