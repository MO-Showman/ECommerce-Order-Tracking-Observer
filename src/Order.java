
package com.mycompany.e.commerce;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private List<Observer> observers;
    private String orderStatus;
    private String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
        this.observers = new ArrayList<>();
        this.orderStatus = "PLACED"; // الحالة المبدئية
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(orderStatus);
        }
    }

    @Override
    public String subjectDetails() {
        return "Order ID: " + orderId;
    }

    // بمجرد ما تتغير الحالة، بنستدعي notifyObservers تلقائياً
    public void setStatus(String status) {
        this.orderStatus = status;
        notifyObservers(); 
    }

    public String getStatus() {
        return orderStatus;
    }
}
