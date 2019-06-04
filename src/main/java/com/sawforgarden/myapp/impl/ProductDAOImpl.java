package com.sawforgarden.myapp.impl;
 

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import com.sawforgarden.myapp.POJO.POJO;
import com.sawforgarden.myapp.POJO.VariableValidator;
import com.sawforgarden.myapp.controller.HomeController;
import com.sawforgarden.myapp.dao.ProductDAO;
import com.sawforgarden.myapp.entity.Comment;
import com.sawforgarden.myapp.entity.OrderDetails;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.jdbc.UpdateDataBase;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;
 
// Transactional for Hibernate
@Transactional
public class ProductDAOImpl implements ProductDAO {
 
	
	private static final Logger logger = Logger
			.getLogger(ProductDAOImpl.class);	
	
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Product findProduct(String code) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Product.class);
        crit.add(Restrictions.eq("code", code));
        return (Product) crit.uniqueResult();
    }
    
    @Override
    public OrderDetails findProductInOrderDetails(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(OrderDetails.class);
//        .createAlias("product", "a");
        crit.add(Restrictions.eq("product.id", id));
        return (OrderDetails) crit.uniqueResult();
    }
    
    @Override
    public void findProductForEditQuantity(String code,int OrderedQuantity) {
    	
    	Product product = null;
    	product = this.findProduct(code);
    	
    	String ReallyQuantity=product.getQuantity();
    	
    	product.setQuantity(String.valueOf(Integer.parseInt(ReallyQuantity) - OrderedQuantity));
    }
    
    
    
    @Override
    public Product findProductfORdATEOFcREATE(String code) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Product.class);
        crit.add(Restrictions.eq("code", code));
        return (Product) crit.uniqueResult();
    }
 
    @Override
    public ProductInfo findProductInfo(String code) {
        Product product = this.findProduct(code);
        if (product == null) {
            return null;
        }
        return new ProductInfo(product.getBrand(), product.getSection(), product.getCode(), product.getName(), product.getPrice(), product.getImage(), product.getDescription(), product.getQuantity(), product.getCategory(), product.getCreateDate(), product.getRating());
    }
 
    @Override
    public void save(ProductInfo productInfo) {
//        String code = productInfo.getCode();
    	String code = "24099949";
        Product product = null;
 
        boolean isNew = false;
        if (code != null) {
            product = this.findProduct(code);
        }
        if (product == null) {
            isNew = true;
            product = new Product();
            product.setCreateDate(new Date());
//            product.setCreate_DateForOutput(new Date());
        }
        product.setCode(code);
        product.setName(productInfo.getName());
        product.setPrice(Double.parseDouble(productInfo.getPrice()));
 
        if (productInfo.getFileData() != null) {
            byte[] image = productInfo.getFileData().getBytes();
            if (image != null && image.length > 0) {
                product.setImage(image);
            }
        }
        if (isNew) {
            this.sessionFactory.getCurrentSession().persist(product);
        }
        // If error in DB, Exceptions will be thrown out immediately
        // Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
        this.sessionFactory.getCurrentSession().flush();
    }
    
    @Override
    public void saveOwnMethod(ProductInfo productInfo, String code) {

        Product product = null;
 
        boolean isNew = false;
        if (code != null) {
            product = this.findProduct(code);
        }
        if (product == null) {
            isNew = true;
            product = new Product();
            product.setCreateDate(new Date());
        }
        
        
        product.setCode(code);
        product.setName(productInfo.getName());
        product.setPrice(Double.parseDouble(productInfo.getPrice()));	
        product.setDescription(productInfo.getDescription());
        product.setQuantity(productInfo.getQuantity());
        product.setRating(productInfo.getRating());
        product.setCategory(productInfo.getCategory().trim().replaceAll("///", "").replaceAll(" ", ""));
        product.setBrand(productInfo.getBrand().trim().replaceAll("///", "").replaceAll(" ", ""));
        product.setSection(productInfo.getSection().trim().replaceAll("///", "").replaceAll(" ", "").replaceAll(",", ""));
        
        
        if(productInfo.getFileData()==null)
        {       	
        	 byte[] image = productInfo.getFileData().getBytes();
        	 product.setImage(image);        	 
        }
        
        if (productInfo.getFileData() != null)
        {
            byte[] image = productInfo.getFileData().getBytes();
            if (image != null && image.length > 0)
            {
                product.setImage(image);
            }
        }
        if (isNew) {
            this.sessionFactory.getCurrentSession().persist(product);
        }
        // If error in DB, Exceptions will be thrown out immediately
        // Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
        this.sessionFactory.getCurrentSession().flush();
    }
    
    
    
    @Override
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
            String likeName) {
        String sql = "Select new " + ProductInfo.class.getName() //
                + "(p.code, p.name, p.price, p.createDate, p.quantity, p.rating) " + " from "//
                + Product.class.getName() + " p ";
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName ";
        }
        sql += " order by p.createDate desc ";
        //
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
//        
        
        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        

        
        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
    
    @Override
    public PaginationResult<ProductInfo> queryProducts(
    		int page, 
    		int maxResult, 
    		int maxNavigationPage,
            String searchName,
            String sortBy,
            String categorySort, 
            String brandSort, 
            String priceSort, 
            String ratingSort) {
    	
    	

        String sql = "Select new " + ProductInfo.class.getName() //
                + "(p.id, p.code, p.name, p.price, p.createDate, p.quantity, p.rating, p.Category, p.Brand) " + " from "//
                + Product.class.getName() + " p ";
        

        
        
        //sorting operations
        
        boolean ShouldIaddANDToQuaryOrNotThatIsQuestions=false;
        
        if(!categorySort.equals("")) 
        {    
        	if(categorySort.equals("Весьинструмент")) {}
        	else 
        	{
        	sql += " Where p.Category like :categorySearch ";
        	ShouldIaddANDToQuaryOrNotThatIsQuestions=true;
        	}
        	
        	
        }
        
        if(!searchName.equals("")) 
        {    
        	
        	if(ShouldIaddANDToQuaryOrNotThatIsQuestions) 
        	{
        	sql += " AND p.name like :searchName ";
        	}
        	else {
            	sql += " Where p.name like :searchName ";
        	}
     
        	ShouldIaddANDToQuaryOrNotThatIsQuestions=true;
        }
        
        
        
        if(!ratingSort.equals("")) 
        {    
        	
        	if(ShouldIaddANDToQuaryOrNotThatIsQuestions) 
        	{
        	sql += " AND "+VariableValidator.tofindKeyWordForRating(ratingSort);
        	}
        	else {
            	sql += " Where "+VariableValidator.tofindKeyWordForRating(ratingSort);
        	}
     
        	ShouldIaddANDToQuaryOrNotThatIsQuestions=true;
        }
        
        
        if(!priceSort.equals("")) 
        {    
        	
        	if(ShouldIaddANDToQuaryOrNotThatIsQuestions) 
        	{
        	sql += " AND "+VariableValidator.tofindKeyWordForPrice(priceSort);
        	}
        	else {
            	sql += " Where "+VariableValidator.tofindKeyWordForPrice(priceSort);
        	}
     
        	ShouldIaddANDToQuaryOrNotThatIsQuestions=true;
        }
        
        if(!brandSort.equals("")) 
        {    
        	
        	if(ShouldIaddANDToQuaryOrNotThatIsQuestions) 
        	{
        	sql += " AND p.Brand like :brandSort";
        	}
        	else {
            	sql += " Where p.Brand like :brandSort";
        	}
     
        	ShouldIaddANDToQuaryOrNotThatIsQuestions=true;
     
        }


        if(!sortBy.equals(""))
        {
        	sql += " order by "+VariableValidator.tofindKeyWordForSearchName(sortBy);
        	ShouldIaddANDToQuaryOrNotThatIsQuestions=true;
        }
        //........

     
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
 
      //set params to sorting operations
        if(!categorySort.equals("")) 
        {
        	    if(categorySort.equals("Весьинструмент")) {}
        	    else 
        	    {
        		query.setParameter("categorySearch", "%" +  categorySort + "%");   	
        	    }
         }

        if(!brandSort.equals("")) 
        {    
        		query.setParameter("brandSort", "%" +  brandSort + "%"); 
        }
        
        if(!searchName.equals("")) 
        {    
        		query.setParameter("searchName", "%" +  searchName + "%"); 
        }
        
      //.... 
        
        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
    
    
    
 
    
    
    
    @Override
    public PaginationResult<ProductInfo> queryProductsForSearching(int page, int maxResult, int maxNavigationPage,
            String likeName, String TransitedTypeOfSorting) {
    	
    	
        String sql = "Select new " + ProductInfo.class.getName() //
                + "(p.code, p.name, p.price, p.createDate, p.quantity) " + " from "//
                + Product.class.getName() + " p ";
        
        
        if (likeName != null && likeName.length() > 0) {
            sql += " Where lower(p.name) like :likeName ";
        }
   
        //
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);
        
      
        if (likeName != null && likeName.length() > 0) {
            query.setParameter("likeName", "%" + likeName.toLowerCase() + "%");
        }
        
        
   
        
        return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);
    }
 
   
    
    
    @Override
    @Transactional
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
        return queryProducts(page, maxResult, maxNavigationPage, null);
    }
    
  
    @Override
    public ProductInfo queryProductByCode(String code) {
        Product product = this.findProduct(code);
        if (product == null) {
	            return null;
	        }
        
        return new ProductInfo(product.getCode(), product.getName(), product.getPrice(), product.getImage(),product.getDescription(), product.getRating());
    }
    
    
    
    public void queryForAddRegisterDataToDataBase(String name,String p,String em) {

    	
    }
//    @Override
//    public ProductInfo queryProductByCodeWithDescription(String code) {
//        Product product = this.findProduct(code);
//        if (product == null) {
//            return null;
//        }
//        
//        return new ProductInfo(product.getCode(), product.getName(), product.getPrice(), product.getImage());
//    }

	@Override
	public PaginationResult<ProductInfo> queryProductsForSearching(int page, int maxResult, int maxNavigationPage,
			String likeName) {

		return null;
	}

	@Override
	public double queryRating(String code) {

		String sql = "Select"
                + " p.rating" + " from "//
                + Product.class.getName() + " p ";
       
            sql += " Where p.code="+code;
     
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);

       	List<?> rating = query.list();
//        Double rating = query.get
        
       	if(rating.size()==0)return 0.0;
		
       	return  (Double) rating.get(0);
	}
	
	
	public void updateRating(Double ratingNumber,String code) {
		
		
//		Get value of rating
		String sql = "Select"
                + " p.rating" + " from "//
                + Product.class.getName() + " p ";
       
            sql += " Where p.code="+code;
     
        Session session = sessionFactory.getCurrentSession();
 
        Query query = session.createQuery(sql);

       	List<?> rating = query.list();
       	Double ExtractedRatingValue= (Double) rating.get(0);
//		Get value of rating
       	
       	Double evaluatedBothRating =  (ExtractedRatingValue+ratingNumber)/2;
		
       	
//       	Product product= new Product();
       	
       	
       		
       	UpdateDataBase.UpdateRatingOfTableProduct(evaluatedBothRating,code);
       		

//        this.sessionFactory.getCurrentSession().save(product);
            
        // If error in DB, Exceptions will be thrown out immediately
        // Nếu có lỗi tại DB, ngoại lệ sẽ ném ra ngay lập tức
//        this.sessionFactory.getCurrentSession().flush();
   
		
	}

	@Override
	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName,
			String TransitedTypeOfSorting) {
		
		return null;
	}

	@Override
	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName,
			String TransitedTypeOfSorting, String categorySearch) {
		
		return null;
	}

	@Override
	public PaginationResult<ProductInfo> queryProducts(String id) {
		String sql = "Select new " + ProductInfo.class.getName() //
	            + "(p.code, p.name, p.price, p.quantity, p.rating) " + " from "//
	            + Product.class.getName() + " p "            
	            +"  WHERE p.code IN (:parameter)"
				+" order by lastViewed desc";
		
		
		Session session = sessionFactory.getCurrentSession();
		

	    Query query = session.createQuery(sql);
        query.setParameterList("parameter", id.split(" "));

	    
	    int page= 1;
	    int maxResult= 5;
	    int maxNavigationPage=1;
	    
	    return new PaginationResult<ProductInfo>(query, page, maxResult, maxNavigationPage);

	}

	@Override
	public String queryNumberReviews(String code) {
		
		String sql = "Select COUNT(c.rating) from "//
	            + Comment.class.getName() + " c "
	            +" Where product_id="+code+"";
//		SELECT COUNT(rating) FROM comments Where product_id=2409;
		Session session = sessionFactory.getCurrentSession();

	    Query query = session.createQuery(sql);
		
		List<?> result = query.list();
		
		return String.valueOf(result.get(0));
	}

	@Override
	public Product findProductByReviewItem(String[] code) {
		
		return null;
	}

	@Override
	public void saveLastView(String code) {
    	
      Product product = null;

      boolean isNew = false;
      if (code != null) {
          product = this.findProduct(code);
          product.setLastViewed(new Date());
      }
      if (product == null) {
          isNew = true;
          product = new Product();   
      }
      
      
      
      if (isNew) {
          this.sessionFactory.getCurrentSession().persist(product);
      }
     
      this.sessionFactory.getCurrentSession().flush();
		
	}

	@Override
	public String findSection(String code) {
		  Product product = this.findProduct(code);
	       
		  if (product == null) {
	            return null;
	        }
	        
	        return product.getSection();
	        
	}
	
	@Override
	public String findBrand(String code) {
		  Product product = this.findProduct(code);
	       
		  if (product == null) {
	            return null;
	        }
	        
	        return product.getBrand();
	        
	}
	
	@Override
	public String findCategory(String code) {
		  Product product = this.findProduct(code);
	       
		  if (product == null) {
	            return null;
	        }
	        
	        return product.getCategory();
	        
	}
	
	@Override
	public void UpdateQuantitiesOfItems(String productCode, long quanity) {
        Session session = sessionFactory.getCurrentSession();
        
        Product product = this.findProduct(productCode);
        
        String result = POJO.countingQuantity(product.getQuantity(), quanity);
   
        product.setQuantity(result);
        
        session.saveOrUpdate(product);       
	}
    
	public void deleteProduct(String code) {
    Session session = sessionFactory.getCurrentSession();

    Product product = this.findProduct(code);

    session.delete(product);    	

	}
  
	public boolean chechIfItemExistInOrderList(String id) {
		
		OrderDetails orderdetails = findProductInOrderDetails(Long.parseLong(id));

		if(orderdetails == null) {return false;}
		
		
		return true;
	}


}