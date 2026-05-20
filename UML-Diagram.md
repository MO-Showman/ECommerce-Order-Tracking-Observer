# C2: UML Diagrams & Design Documentation


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
        -String appName
        +CustomerApp(Subject order, String appName)
        +update(String status)
        +display()
    }

    class SMSService {
        -Subject order
        -String phoneNumber
        +SMSService(Subject order, String phoneNumber)
        +update(String status)
        +sendSMS()
    }

    Subject o-- Observer : Aggregation 
    Order ..|> Subject : Realization
    CustomerApp ..|> Observer : Realization
    SMSService ..|> Observer : Realization
