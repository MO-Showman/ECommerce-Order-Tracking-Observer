# C2: UML Diagrams & Design Documentation

## 📊 1. Observer Pattern Class Diagram
The following diagram represents the architecture of our **E-Commerce Order Tracking System**. It follows the standard structure defined in the reference book (Chapter 7).

```mermaid
classDiagram
    class Subject {
        <<interface>>
        +subscribeObserver(Observer observer)
        +unSubscribeObserver(Observer observer)
        +notifyObservers()
        +subjectDetails() String
    }

    class Observer {
        <<interface>>
        +update(String status)
    }

    class Order {
        -List~Observer~ observers
        -String orderStatus
        -String orderId
        +Order(String orderId)
        +subscribeObserver(Observer observer)
        +unSubscribeObserver(Observer observer)
        +notifyObservers()
        +subjectDetails() String
        +setStatus(String status)
        +getStatus() String
    }

    class CustomerApp {
        -Subject order
        +update(String status)
        +display()
    }

    class SMSService {
        -Subject order
        +update(String status)
        +sendSMS()
    }

    class AnalyticsLogger {
        -Subject order
        +update(String status)
        +logData()
    }

    Subject o-- Observer : Aggregation (1 to Many)
    Order ..|> Subject : Realization / Implements
    CustomerApp ..|> Observer : Realization / Implements
    SMSService ..|> Observer : Realization / Implements
    AnalyticsLogger ..|> Observer : Realization / Implements
    CustomerApp --> Order : Dependency
    SMSService --> Order : Dependency
    AnalyticsLogger --> Order : Dependency
