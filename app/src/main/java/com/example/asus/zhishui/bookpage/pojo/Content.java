package com.example.asus.zhishui.bookpage.pojo;

public class Content {
    private String textSubtitle;
    private Integer textBody;


    public Content(String textSubtitle, Integer textBody) {
        this.textSubtitle = textSubtitle;
        this.textBody = textBody;

    }

    public String getTextSubtitle(){return textSubtitle;}
    public Integer getTextBody() {
        return textBody;
    }


    public void setTextSubtitle(String textSubtitle){this.textSubtitle = textSubtitle;}
    public void setTextBody(Integer textBody) {
        this.textBody = textBody;
    }

}
