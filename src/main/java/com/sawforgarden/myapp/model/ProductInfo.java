	package com.sawforgarden.myapp.model;
 
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sawforgarden.myapp.entity.Product;

@Transactional
public class ProductInfo {
	
    private String code;

    private String maxAmountOfCartItem;
    
    private String name;
    
    private String price;
    private byte[] image;
    private String description;
    private String quantity;
    private double rating;
    
    private String section;
    private String category;
    private String brand;
    
    private long id;
 
    private Date createDate;
    
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public ProductInfo() {
    }
    
    
 
    public ProductInfo(Product product) {
        this.setCode(product.getCode());
        this.name = product.getName();
        this.price = String.valueOf(product.getPrice());
        this.quantity=product.getQuantity();
        this.description=product.getDescription();
    
    }
    
    
//    for view page
    public ProductInfo(String code, String name, double price,byte[] image, String description,double rating) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.description=description;
        this.rating=rating;
        this.image=image;
    }
    
//    for recently viewed
    public ProductInfo(String code, String name, double price, String quantity, double rating) {
        this.setCode(code);
        this.name = name;
        this.quantity = quantity;
        this.rating=rating;
        this.price=String.valueOf(price);
    }
    

    // Không thay đổi Constructor này,
    // nó được sử dụng trong Hibernate query.
    public ProductInfo(String code, String name, double price) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
    }
    
    public ProductInfo(String code, String name, double price,Date createDate) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.createDate=createDate;
    }
    
//    That constructor for output on CatalogOfItems
    public ProductInfo(String code, String name, double price,Date createDate, String quantity) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.createDate=createDate;
        this.quantity=quantity;

    }
    
//  That constructor for output on CatalogOfItems
  public ProductInfo(String code, String name, double price,Date createDate, String quantity, double rating) {
      this.setCode(code);
      this.name = name;
      this.price = String.valueOf(price);
      this.createDate=createDate;
      this.quantity=quantity;
      this.rating=rating;
      
  }
  
  
public ProductInfo(String code, String name, double price,Date createDate, String quantity, double rating, String category) {
    this.setCode(code);
    this.name = name;
    this.price = String.valueOf(price);
    this.createDate=createDate;
    this.quantity=quantity;
    this.rating=rating;
    this.category=category;
}

//That constructor for output on CatalogOfItems
public ProductInfo(long id,String code, String name, double price,Date createDate, String quantity, double rating, String category, String brand) {
  this.id= id;
  this.setCode(code);
  this.name = name;
  this.price = String.valueOf(price);
  this.createDate=createDate;
  this.quantity=quantity;
  this.rating=rating;
  this.category=category;
  this.brand=brand;
}
    
    public ProductInfo(String code, String name, double price, byte[] image) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.setImage(image);
    }
    
    public ProductInfo(String code, String name, double price, byte[] image, String description) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.setImage(image);
        this.description=description;
    }
    
    public ProductInfo(String code, String name, double price, byte[] image, String description, String quantity) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.setImage(image);
        this.description=description;
        this.quantity=quantity;
    }
    
    public ProductInfo(String code, String name, double price, String description) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.description=description;
    }
    
    public ProductInfo(String code, String name, double price, String description, String quantity) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.description=description;
        this.quantity=quantity;
        
    }
    
    public ProductInfo(String code, String name, double price, String description, String quantity,double rating) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.description=description;
        this.quantity=quantity;
        this.rating=rating;
        
    }
    
 
    public ProductInfo(String code, String name, double price, byte[] image, String description, String quantity, String category) {
        this.setCode(code);
        this.name = name;
        this.price = String.valueOf(price);
        this.setImage(image);
        this.description=description;
        this.quantity=quantity;
        this.category=category;
    }
  
//	public ProductInfo(String category2, String brand2, String section2, String code2, String name2, double price2,
//			byte[] image2, String description2, String quantity2, String category3) {
//		
//	}



	
 
    public ProductInfo(String brand, String section, String code, String name, double price, byte[] image,
			String description, String quantity, String category, Date createDate, double rating) {
//		super();
		this.setCode(code);
		this.name = name;
		this.price = String.valueOf(price);
		this.image = image;
		this.description = description;
		this.quantity = quantity;
		this.rating = rating;
		this.section = section;
		this.category = category;
		this.brand = brand;
		this.createDate = createDate;
	}


	



 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getPrice() {
        return price;
    }
 
    public void setPrice(String price) {
        this.price = price;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMaxAmountOfCartItem() {
		return maxAmountOfCartItem;
	}



	public void setMaxAmountOfCartItem(String maxAmountOfCartItem) {
		this.maxAmountOfCartItem = maxAmountOfCartItem;
	}


 
}