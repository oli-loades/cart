package com.qa.com.qa.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;


    @ManyToOne
    @JoinColumn(name="itemId")
    private Item item;

    @ManyToOne
    @JoinColumn(name="orderId")
    @JsonIgnore
    private Order order;

    public long getId() {
        return orderItemId;
    }

    public void setId(long id) {
        this.orderItemId = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
