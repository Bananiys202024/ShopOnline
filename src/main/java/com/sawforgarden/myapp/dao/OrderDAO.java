package com.sawforgarden.myapp.dao;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sawforgarden.myapp.model.CartInfo;
import com.sawforgarden.myapp.model.OrderDetailInfo;
import com.sawforgarden.myapp.model.OrderInfo;
import com.sawforgarden.myapp.model.PaginationResult;

@Repository
public interface OrderDAO {
 
    public void saveOrder(CartInfo cartInfo);
 
    public PaginationResult<OrderInfo> listOrderInfo(int page,
            int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);

	void saveOrderWithEditOfQuantity(CartInfo cartInfo);

	void deleteOrderDetails(String orderdetailId);

	void deleteOrders(String orderId);

	void deleteOrderDetailsORDERID(String orderdetailId);

	List listOrderInfoGetSingleItemOrSingleQuery(String orderId);

 
}