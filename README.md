# 📦 E-Commerce Order Tracking System - Design Patterns Project

## 📌 Project Overview
This project is developed as part of the **Design Patterns Course (Case 3)**. The main objective is to identify a behavioral software challenge, analyze possible architectural approaches, and implement a suitable pattern.

**Selected Pattern:** Observer Pattern (Behavioral)

## 🎯 The Real-World Problem
In modern e-commerce and logistics systems, tracking a package's fulfillment lifecycle (`PLACED`, `IN_WAREHOUSE`, `OUT_FOR_DELIVERY`, `DELIVERED`) is highly critical. Whenever the order state changes, multiple independent subsystems (Customer UI App, SMS Notification Service, and Analytics Logs) must update simultaneously. Hardcoding these dependencies inside the core `Order` class leads to **Tight Coupling** and breaks the **Open/Closed Principle**.

## 🛠️ The Solution (Observer Pattern)
To eliminate this structural rigidity, we implemented the **Observer Design Pattern** (Publish-Subscribe). By defining a unified interface, the `Order` class acts as a **Subject** that hosts a collection of independent **Observers**. When a state transition occurs, the order simply broadcasts the change via `notifyObservers()`, decoupling business execution from presentation and communication logic.

## 📂 Project Deliverables
- 📝 **[Problem Analysis & Trade-offs](./Problem-Analysis-Trade-offs.md)**
- 🎯 **[Pattern Selection & Justification](./Pattern-Justification.md)**
- 📊 **[UML Class Diagram](./UML-Diagram.md)**
- 💻 **[Source Code Implementation](./src)**
- 📄 **[Presentation Slides (PDF)](#)**
- 🎬 **[Presentation Video (Watch Here)](#)**
- 📋 **[Project Management Board (Kanban)](https://github.com/users/MO-Showman/projects/4)**

## 👨‍💻 Authors
- **Names:** [ Mohammad shoman , Ibrahim Al-Balawi , Ahmed Al-Ajmi ]
- **Role:** Full Project Implementation & Design
