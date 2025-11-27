package com.projeto.estudos.services;

import com.projeto.estudos.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public double total(Order order){

        double discountValue = order.getBasic() * order.getDiscount() / 100;
        double total = order.getBasic() - discountValue + shippingService.shipment(order);
        return total;
    }
}
