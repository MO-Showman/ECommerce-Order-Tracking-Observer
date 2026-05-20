
package com.mycompany.e.commerce;


public class ECommerce {

    public static void main(String[] args) {
        System.out.println("=== E-Commerce Order Tracking System ===\n");

        // 1. إنشاء الطلب (The Subject)
        Order order123 = new Order("ORD-998877");

        // 2. إنشاء المشتركين (The Observers)
        CustomerApp mobileApp = new CustomerApp(order123, "Customer iOS App");
        SMSService smsAlert = new SMSService(order123, "+962-79-1234567");

        // 3. تغيير حالة الطلب (رح يتم إشعار الجميع تلقائياً)
        System.out.println("--- System: Updating Order to IN_WAREHOUSE ---");
        order123.setStatus("IN_WAREHOUSE");

        System.out.println("--- System: Updating Order to OUT_FOR_DELIVERY ---");
        order123.setStatus("OUT_FOR_DELIVERY");
    }
}
