package com.example.asus.zhishui.bookpage.pojo;

import com.ramotion.expandingcollection.ECCardData;

import java.util.List;

public class CardData implements ECCardData<Content> {

    private String headTitle;
    private Integer headBackgroundResource;
    private Integer mainBackgroundResource;

    private String personName;
    private String personMessage;
    private List<Content> listItems;

    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    public Integer getHeadBackgroundResource() {
        return headBackgroundResource;
    }

    public void setHeadBackgroundResource(Integer headBackgroundResource) {
        this.headBackgroundResource = headBackgroundResource;
    }

    public Integer getMainBackgroundResource() {
        return mainBackgroundResource;
    }

    public void setMainBackgroundResource(Integer mainBackgroundResource) {
        this.mainBackgroundResource = mainBackgroundResource;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonMessage() {
        return personMessage;
    }

    public void setPersonMessage(String personMessage) {
        this.personMessage = personMessage;
    }


    @Override
    public List<Content> getListItems() {
        return listItems;
    }

    public void setListItems(List<Content> listItems) {
        this.listItems = listItems;
    }
}
