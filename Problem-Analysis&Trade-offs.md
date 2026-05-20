# C2: Problem Analysis & Trade-off Report

## 1. The Real-World Software Problem
In modern E-Commerce and logistics platforms (such as Amazon, eBay, or FedEx), tracking the fulfillment and delivery status of a package is a critical feature. A typical package goes through several distinct stages during its lifecycle:
* **PLACED:** The order is successfully submitted by the customer.
* **IN_WAREHOUSE:** The item is packaged and prepared for shipping.
* **OUT_FOR_DELIVERY:** The package is handed over to the courier for local delivery.
* **DELIVERED:** The package has been successfully received by the customer.

## 2. Design Challenges
The primary behavioral challenge is managing the one-to-many dependencies that arise whenever an order changes its state. 

When the `Order` status transitions (e.g., from `IN_WAREHOUSE` to `OUT_FOR_DELIVERY`), multiple independent subsystems and UI components must be notified instantly to update their states simultaneously:
* **Customer Mobile Application:** To update the live tracking map interface and progress bar.
* **Notification Service:** To trigger automated SMS, Email, or Push alerts to the user.
* **Analytics & Logging Engine:** To record timestamps for business intelligence and courier performance metrics.

Without an appropriate design pattern, developers hardcode these dependent objects inside the core `Order` class. This leads to **Tight Coupling**, where the `Order` class is forced to hold concrete references to all external notification systems. Consequently, the codebase becomes highly rigid: if a new notification system is added (e.g., WhatsApp Alerts), the core `Order` class must be opened and modified, directly violating the **Open/Closed Principle (OCP)**.

## 3. Comparing Design Approaches (Trade-offs)
To resolve this behavioral and communication complexity, we evaluate two architectural patterns from our reference material: **State Pattern** and **Observer Pattern**.

### Option A: State Design Pattern
* **Purpose:** Allows an object to alter its behavior when its internal state changes, making the object appear as if it changed its class.
* **Pros:** Excellent for encapsulating state-specific transitions and logic (e.g., preventing an order from moving directly from `PLACED` to `DELIVERED` without passing through the intermediate stages).
* **Cons:** It does not address the core issue of broadcasting notifications to independent, external subsystems. The external notification managers would still remain tightly coupled to the state transition logic, failing to solve the decoupling challenge.

### Option B: Observer Design Pattern (Selected)
* **Purpose:** Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
* **Pros:** Completely decouples the core `Order` class (Subject) from the external notification engines (Observers). The Subject only maintains a generic list of observers that implement a unified interface, allowing new observers to be added or removed dynamically at runtime without breaking existing code.
* **Cons:** Notifications are broadcasted blindly; the Subject has no control over whether all observers successfully processed the update, and the order of notification execution among observers is not guaranteed.

## 4. Conclusion
While the State Pattern is effective for managing internal state transitions, the primary design bottleneck in this case study is the communication rigidity between the order state changes and the external notification receivers. Therefore, the **Observer Pattern** is the superior structural-behavioral solution to eliminate tight coupling, fulfill the Open/Closed Principle, and establish a scalable publish-subscribe mechanism for tracking updates.
