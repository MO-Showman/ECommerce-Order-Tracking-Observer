
package com.mycompany.e.commerce;

public class CustomerApp implements Observer {
    private Subject order;
    private String appName;

    public CustomerApp(Subject order, String appName) {
        this.order = order;
        this.appName = appName;
        // التسجيل التلقائي في الـ Subject عند إنشاء الكائن
        order.subscribeObserver(this); 
    }

    @Override
    public void update(String status) {
        System.out.println("[" + appName + "] Notification: " + order.subjectDetails() + " is now " + status);
        display();
    }

    public void display() {
        System.out.println("   -> Updating Mobile App UI and Live Tracking Map...\n");
    }
}
