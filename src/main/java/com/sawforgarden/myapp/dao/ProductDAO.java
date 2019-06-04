package com.sawforgarden.myapp.dao;
 
import org.springframework.stereotype.Repository;

import com.sawforgarden.myapp.entity.OrderDetails;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.model.PaginationResult;
import com.sawforgarden.myapp.model.ProductInfo;

@Repository
public interface ProductDAO {

    public Product findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
 
    public PaginationResult<ProductInfo> queryProductsForSearching(int page, int maxResult,
            int maxNavigationPage, String likeName);
    
    public void save(ProductInfo productInfo);
    
    public void saveOwnMethod(ProductInfo productInfo,String code);

	ProductInfo queryProductByCode(String code);

	Product findProductfORdATEOFcREATE(String code);

	void findProductForEditQuantity(String code, int OrderedQuantity);

	PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName,
			String TransitedTypeOfSorting);

	public void queryForAddRegisterDataToDataBase(String varName, String varEmail, String varPassword);

	PaginationResult<ProductInfo> queryProductsForSearching(int page, int maxResult, int maxNavigationPage,
			String likeName, String TransitedTypeOfSorting);

	public double queryRating(String code);

	public void updateRating(Double ratingNumber, String code);

	PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName,
			String TransitedTypeOfSorting, String categorySearch);

	PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage, String likeName,
			String TransitedTypeOfSorting, String categorySearch, String sortByBrand, String sortByPrice,
			String sortByRating);

	public PaginationResult<ProductInfo> queryProducts(String id);

	public Object queryNumberReviews(String code);


	Product findProductByReviewItem(String[] code);

	public void saveLastView(String code);

	public String findSection(String code);

	public Object findBrand(String code);

	public Object findCategory(String code);

	void UpdateQuantitiesOfItems(String productCode, long quanity);

	public void deleteProduct(String code);


	public boolean chechIfItemExistInOrderList(String id);

	OrderDetails findProductInOrderDetails(Long id);
    

}