package com.codeup.adlister.models;

public class AdCategory {
    private int ad_id;
    private int cat_id;

    public AdCategory(int ad_id, int cat_id){
        super ();
        this.ad_id = ad_id;
        this.cat_id = cat_id;
    }
        public int getAd_id(){return ad_id; }

        public int getCat_id(){return cat_id; }

        public void setAd_id(int ad_id){this.ad_id = ad_id;}

        public void setCat_id(int cat_id){this.cat_id = cat_id;}

}
