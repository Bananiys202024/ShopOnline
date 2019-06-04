package com.sawforgarden.myapp.entity;
 
import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product implements Serializable {
 
    private static final long serialVersionUID = -1000119078147252957L;
 
    @javax.persistence.Id
    @GeneratedValue
    private Long Id;    
    
    @Column(name = "code", nullable = false)
    private String code;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "price", nullable = false)
    private double price;
    
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;
    
    @Column(name = "description", nullable = false,length=2100)
    private String description;
    
    @Column(name = "quantity", nullable = false)
    private String quantity;
    
    @Column(name = "rating", nullable = false)
    private double rating;
    
    @Column(name = "Category", nullable = false, length=1000)
    private String Category;

	@Column(name = "Brand", nullable = false, length=1000)
    private String Brand;
	
	@Column(name = "Section", length=1000)
    private String section;
	
	@Column(name="WeShouldDeleteIt")
	private String WeShouldDeleteIt;
    
	@Column(name="createDate")
    private Date createDate;
	
	@Column(name="lastViewed")
    private Date lastViewed;
	
	@Column(name="CheckingSecond", nullable=true)
    private String CheckingSecond;

	
    public Product() {
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
  
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public Date getCreateDate() {
        return createDate;
    }
    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "Create_Date", nullable = false)
//    public int getCreateDateInt() {
//        return Integer.parseInt(String.valueOf(createDate));
//    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
    public byte[] getImage() {
        return image;
    }
 
    public void setImage(byte[] image) {
        this.image = image;
    }

 	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public void setQuantity(int i) {
		this.quantity=String.valueOf(i);
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

    public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public Date getLastViewed() {
		return lastViewed;
	}

	public void setLastViewed(Date lastViewed) {
		this.lastViewed = lastViewed;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	




 
}