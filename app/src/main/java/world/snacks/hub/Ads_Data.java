package world.snacks.hub;

public class Ads_Data {

    public String ad_tiltle;
    public String ad_sub_tiltle;
    public String ad_icon_link;
    public String ad_banner_link;
    public String ad_native_link;
    public String ad_inter_link;
    public String ad_btn_text;
    public String ad_link;
    public Ads_Data(String tiltle, String sub_tiltle, String icon_link, String banner_link, String native_link, String inter_link,String btn_text,  String link) {
        this.ad_tiltle = tiltle;
        this.ad_sub_tiltle = sub_tiltle;
        this.ad_icon_link = icon_link;
        this.ad_banner_link = banner_link;
        this.ad_native_link = native_link;
        this.ad_inter_link = inter_link;
        this.ad_btn_text = btn_text;
        this.ad_link = link;
    }

    public String getAd_tiltle() {
        return ad_tiltle;
    }

    public void setAd_tiltle(String tiltle) {
        this.ad_tiltle = tiltle;
    }

    public String getAd_sub_tiltle() {
        return ad_sub_tiltle;
    }

    public void setAd_sub_tiltle(String sub_tiltle) {
        this.ad_sub_tiltle = sub_tiltle;
    }
    public String getAd_icon_link() {
        return ad_icon_link;
    }

    public void setAd_icon_link(String icon_link) {
        this.ad_icon_link = icon_link;
    }
    public String getAd_banner_link() {
        return ad_banner_link;
    }

    public void setAd_banner_link(String banner_link) {
        this.ad_banner_link = banner_link;
    }

    public String getAd_native_link() {
        return ad_native_link;
    }

    public void setAd_native_link(String native_link) {
        this.ad_native_link = native_link;
    }

    public String getAd_inter_link() {
        return ad_inter_link;
    }

    public void setAd_inter_link(String inter_link) {
        this.ad_inter_link = inter_link;
    }
    public String getAd_link() {
        return ad_link;
    }

    public void setAd_link(String link) {
        this.ad_link = link;
    }

}