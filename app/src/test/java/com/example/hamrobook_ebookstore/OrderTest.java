package com.example.hamrobook_ebookstore;

import com.example.hamrobook_ebookstore.bll.OrderBll;
import com.example.hamrobook_ebookstore.model.Order;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class OrderTest {
    @Test
    public void OrderPass(){
        Order order=new Order("Understanding","500","Patan","9842575");
        OrderBll orderBll=new OrderBll();
        boolean result=orderBll.orderadd(order);
        assertEquals(false,result);
    }
}
