
package com.mycompany.e.commerce;

public class SMSService implements Observer {
    private Subject order;
    private String phoneNumber;

    public SMSService(Subject order, String phoneNumber) {
        this.order = order;
        this.phoneNumber = phoneNumber;
        // التسجيل التلقائي في الـ Subject عند إنشاء الكائن
        order.subscribeObserver(this);
    }

    @Override
    public void update(String status) {
        System.out.println("[SMS System] Notification: " + order.subjectDetails() + " changed state.");
        sendSMS();
    }

    public void sendSMS() {
        System.out.println("   -> Sending Text Message to " + phoneNumber + ": Your package status is updated.\n");
    }
}
