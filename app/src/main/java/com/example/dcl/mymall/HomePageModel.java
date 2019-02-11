package com.example.dcl.mymall;

import java.util.List;

public class HomePageModel {
    public static final int BANNER_SLIDER = 0;
    public static final int STRIP_AD_BANNER = 1;

    private int type;


    //////////////////Banner Slider Model List

    private List<SliderModel> sliderModelList;
    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }
    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    //////////////////Banner Slider Model List

    ////////////Strip Ad
    private int resoure;
    private String backgroundColor;

    public HomePageModel(int type, int resoure, String backgroundColor) {
        this.type = type;
        this.resoure = resoure;
        this.backgroundColor = backgroundColor;
    }
    public int getResoure() {
        return resoure;
    }
    public void setResoure(int resoure) {
        this.resoure = resoure;
    }
    public String getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    ////////////Strip Ad

}
