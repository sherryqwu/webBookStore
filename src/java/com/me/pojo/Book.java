package com.me.pojo;

import java.util.ArrayList;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Book {
	private int id;
        private int typeid;
//	private ArrayList<TypeInfo> types;
       // private int category
	private String name;
	private float price;
//	private float saleprice;
	private String descript;
	private String contents;
        
        private CommonsMultipartFile image;
        private String imagefile;
//	private String fileName;
//	private String leavetime;
//	private int storage;
//	private String provider;
//	private String marque;
//	private String unit;
     
      /* 
        public Book(int id, int typeid, String name, float price, String descript, String contents) {
		this.id = id;
		this.typeid = typeid;
		this.name = name;
		this.price = price;	
		this.descript = descript;
		this.contents = contents;
	}
        /*
	public Book(int id, int typeid, String name, float price, float saleprice, String descript, String contents, String fileName, String leavetime, int storage, String provider, String marque, String unit) {
		this.id = id;
		this.typeid = typeid;
		this.name = name;
		this.price = price;
		this.saleprice = saleprice;
		this.descript = descript;
		this.contents = contents;
		this.fileName = fileName;
		this.leavetime = leavetime;
		this.storage = storage;
		this.provider = provider;
		this.marque = marque;
		this.unit = unit;
	}
        */
	public Book() {
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public CommonsMultipartFile getImage() {
        return image;
    }

    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile;
    }
	
}
