package com.quantumhiggs.bluedoll;

public class Dolls {

    private String id;
    private String name;
    private String desc;
    private int image;

    public Dolls (String id, String name, String desc, int image)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
