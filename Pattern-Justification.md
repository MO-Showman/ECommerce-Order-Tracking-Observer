# C2: Design Pattern Justification Document

## 1. Selected Design Pattern
The selected pattern for the E-Commerce Order Tracking System is the **Observer Design Pattern** (also known as Publish-Subscribe), which falls under the category of Behavioral Design Patterns.

## 2. Why it Fits the Identified Problem
The Observer pattern is perfectly suited for this logistics and delivery tracking scenario because:
* **Handles One-to-Many Dependencies:** In an order lifecycle, we have a single data source (the `Order` object) that changes state, and multiple independent external components (Customer App, SMS Service, Analytics Logs) that must react immediately.
* **Loose Coupling:** The core `Order` object does not need to know the implementation details or the exact types of the notification systems. It only communicates through a abstract interface.
* **Dynamic Management:** Observers can subscribe (register) or unsubscribe (remove themselves) from the order dynamically at runtime based on the system's needs or customer preferences.

## 3. Reasoning Based on Design Principles
The selection of the Observer pattern is heavily supported by core object-oriented design principles:

### A. Single Responsibility Principle (SRP)
Without the Observer pattern, the `Order` class would be bloated with two unrelated responsibilities: managing core order business logic (items, pricing, status changes) and handling communication logic (sending SMS, updating UIs, pushing logs). By applying the Observer pattern, we achieve SRP:
* The `Order` class is strictly responsible for maintaining and changing its internal fulfillment state.
* The individual `Observer` classes (e.g., `SMSService`, `CustomerAppNotification`) are strictly responsible for their own reaction and communication logic once notified.

### B. Open/Closed Principle (OCP)
The architecture becomes open for extension but closed for modification. If the business decides to introduce a new notification channel (e.g., WhatsApp Alerts, Slack Business Notifications, or Push Webhooks), we simply create a new concrete observer class that implements the generic `Observer` interface. We **do not** need to change a single line of code inside the existing `Order` class or the other observers.

### C. Liskov Substitution Principle (LSP) / Depend on Abstractions
The subject (`Order`) only maintains a list of the abstract `Observer` interface. It invokes the `update()` method uniformly on all registered items. Because all concrete notification handlers adhere strictly to the contract defined by the interface, they can be substituted or interchanged seamlessly without causing runtime errors or disrupting the state broadcasting engine.
