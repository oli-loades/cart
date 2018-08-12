package com.qa.com.qa.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private String firstName;
    private String surname;
    private String accNo;

//    @OneToOne
//    @JoinColumn(name="orderId")
//    @JsonIgnore
//    private Order order;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Account() {
    }

    public Account(String firstName, String surname, String accNo) {
        this.firstName = firstName;
        this.surname = surname;
        this.accNo = accNo;
        orders = new ArrayList<>();
    }

    public long getId() {
        return accountId;
    }

    public void setId(long id) {
        this.accountId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
/*
    public Order getOrder(long id) {
        int pos = findOrderPos(id);
        Order order = null;
        if (pos != -1) {
            order = orders.get(pos);
        }
        return order;
    }

    public boolean removeOrder() {
        boolean removed = false;
        int pos = findOrderPos(id);
        if (pos != -1) {
            orders.remove(pos);
            removed = true;
        }
        return removed;
    }

    private int findOrderPos(long id) {
        int pos = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                pos = i;
            }
        }
        return pos;
    }
    */
}
