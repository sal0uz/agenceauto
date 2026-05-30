# 🚗 AgenceAuto — Application de Gestion d'une Agence Médiatrice de Vente de Voitures

![Java](https://img.shields.io/badge/Java-OOP-orange) ![Console](https://img.shields.io/badge/App-Console-blue) ![EMSI](https://img.shields.io/badge/EMSI-Casablanca-green)

> Java console application simulating a car mediation agency — connecting private sellers and buyers, managing listings, appointments, and transactions.

---

## 📌 Context

A car mediation agency wants to manage its intermediary activity between private sellers and buyers. The agency does **not** sell cars directly — it:

- Registers cars proposed by sellers
- Publishes and manages listings
- Connects sellers and buyers
- Tracks client requests
- Manages mediation operations until a sale is finalized or cancelled

---

## ✨ Features

### 👥 People Management
- Full CRUD for **Sellers**, **Buyers**, and **Agents**

### 🚘 Car Management
- Add, view, search, update, and delete cars

### 📢 Listing Management
- Create, display, modify, deactivate listings
- Manage listing status (active, inactive, sold)

### 📋 Request Management
- Register purchase requests
- Link requests to available cars
- Track and update request status

### 🤝 Mediation
- Match a buyer to a listing
- Record contact attempts
- Schedule appointments

### 💸 Transactions
- Create, track, finalize, or cancel transactions

### 🧾 Mediation Fees
- Calculate and display mediation fees per transaction

### 🔍 Search
- Multi-criteria search (price, brand, model, year...)

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Paradigm | Object-Oriented Programming (OOP) |
| App Type | Console application |
| Architecture | Modular — interfaces, abstract classes, concrete classes, enums |

---

## 🏗️ OOP Design Highlights

- **Inheritance** — shared Person base class extended by Seller, Buyer, Agent
- **Abstract classes** — define common structure for entities
- **Interfaces** — enforce contracts across modules (e.g. searchable, manageable)
- **Enums** — model states cleanly (ListingStatus, TransactionStatus, RequestStatus)
- **Modularity** — each feature isolated in its own package/class
- **Extensibility** — new roles or vehicle types can be added without breaking existing logic

---

## 📁 Project Structure

```
AgenceAuto/
├── src/
│   ├── models/
│   │   ├── Person.java          # Abstract base class
│   │   ├── Seller.java
│   │   ├── Buyer.java
│   │   ├── Agent.java
│   │   ├── Car.java
│   │   ├── Listing.java
│   │   ├── Request.java
│   │   ├── Transaction.java
│   │   └── enums/
│   │       ├── ListingStatus.java
│   │       ├── TransactionStatus.java
│   │       └── RequestStatus.java
│   ├── services/
│   │   ├── PersonService.java
│   │   ├── CarService.java
│   │   ├── ListingService.java
│   │   ├── MediationService.java
│   │   └── TransactionService.java
│   ├── interfaces/
│   │   ├── Manageable.java
│   │   └── Searchable.java
│   └── Main.java
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 8+
- Any IDE (IntelliJ, Eclipse, VS Code) or terminal

### Run

```bash
# Compile
javac -d out src/**/*.java src/Main.java

# Run
java -cp out Main
```

Or open the project directly in your IDE and run `Main.java`.

---

## 👩‍💻 Author

**Salma Khatibi** — 1st year Engineering cycle, EMSI Casablanca  
📧 khatibisalma05@gmail.com  
🔗 [linkedin.com/in/salma-khatibi-147768383](https://linkedin.com/in/salma-khatibi-147768383)

---

## 📄 Academic Context

Mini-project — 1ère année Cycle Ingénieur, EMSI Casablanca  
Prof. Ahmed RABHI — May 2026
