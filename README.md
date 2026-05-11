# 🚀 Dictionary Search & Auto-Suggestion System

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge)
![Data Structure](https://img.shields.io/badge/Data%20Structure-Trie-blue?style=for-the-badge)
![REST API](https://img.shields.io/badge/API-REST-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

A high-performance backend-only Dictionary Search & Auto-Suggestion System built using **Java** and **Trie Data Structure**.

</div>

---

# 📖 Overview

This project is designed to efficiently store and search words while providing intelligent prefix-based auto-suggestions similar to modern search engines.

The system supports:
- Exact word search
- Prefix auto-suggestions
- Frequency-based ranking
- Dynamic word insertion
- REST-style APIs
- Efficient Trie-based searching

---

# ✨ Features

✅ Exact Word Search  
✅ Prefix-Based Auto Suggestions  
✅ Frequency-Based Ranking  
✅ Dynamic Word Addition  
✅ REST API Endpoints  
✅ Optimized Trie Data Structure  
✅ In-Memory Storage  
✅ Fast Lookup Operations  
✅ Clean & Modular Code Structure  
✅ No External Libraries/Frameworks  

---

# 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core Development |
| Trie Data Structure | Fast Prefix Searching |
| HttpServer | REST API Handling |
| VS Code | Development Environment |

---

# 📂 Project Structure

```text
DictionarySystem/
│
├── Main.java
├── DictionaryService.java
├── Trie.java
├── TrieNode.java
├── Word.java
├── README.md
│
├── Main.class
├── DictionaryService.class
├── Trie.class
├── TrieNode.class
└── Word.class
```

---

# 🧠 Core Concepts Used

## 🔹 Trie Data Structure

Trie is used for:
- Fast exact word search
- Efficient prefix matching
- Auto-complete suggestions

### Advantages
- Optimized searching
- Efficient memory usage for shared prefixes
- Fast insertion and retrieval
- Scalable for large datasets

---

# 🌐 API Endpoints

## 🔍 Search Word

### Request
```http
GET /search?word=apple
```

### Response
```text
FOUND
```

or

```text
NOT FOUND
```

---

## ➕ Add Word

### Request
```http
GET /add?word=orange
```

### Response
```text
Word added successfully
```

or

```text
Word already exists
```

---

## 💡 Prefix Suggestions

### Request
```http
GET /suggest?prefix=app&k=3
```

### Response
```text
[apple (frequency=4), apply (frequency=2), application (frequency=1)]
```

---

# ⚙️ How It Works

1. Words are stored inside a Trie.
2. Search operations traverse characters efficiently.
3. Successful searches increase word frequency.
4. Suggestions are sorted by:
   - Higher frequency first
   - Lexicographical order if frequency is same
5. Top `k` matching words are returned.

---

# ▶️ How to Run

## Step 1: Open Project Folder

Open the `DictionarySystem` folder in VS Code.

---

## Step 2: Compile Java Files

```bash
javac Main.java DictionaryService.java Trie.java TrieNode.java Word.java
```

---

## Step 3: Run Application

```bash
java Main
```

---

## Step 4: Server Starts

```text
Server started at port 8080
```

---

# 🧪 API Testing

## Browser/Postman Testing

### Search API
```text
http://localhost:8080/search?word=apple
```

### Add Word API
```text
http://localhost:8080/add?word=orange
```

### Suggestion API
```text
http://localhost:8080/suggest?prefix=app&k=3
```

---

# 📊 Time Complexity Analysis

| Operation | Complexity |
|---|---|
| Insert Word | O(n) |
| Search Word | O(n) |
| Prefix Suggestion | O(p + m log m) |

### Where:
- `n` = word length
- `p` = prefix length
- `m` = number of matching words

---

# 🔥 Performance Benefits

- Fast search operations
- Efficient prefix querying
- Scalable architecture
- Low latency suggestions
- Optimized for large datasets

---

# 📌 Assumptions

- Words are case-insensitive
- In-memory storage is used
- Frequency increases after successful search
- No database integration
- No external dependencies

---

# 🚀 Future Enhancements

- Database Integration (MySQL/MongoDB)
- Frontend UI
- Authentication & Authorization
- Delete/Update Word APIs
- Persistent Storage
- Top-K Optimization using Heap
- Docker Deployment
- Cloud Deployment

---

# 🏆 Assignment Requirements Covered

| Requirement | Status |
|---|---|
| Exact Word Search | ✅ |
| Prefix Suggestions | ✅ |
| Frequency Tracking | ✅ |
| Add Word Feature | ✅ |
| Efficient Data Structure | ✅ |
| REST APIs | ✅ |
| Clean Architecture | ✅ |
| No External Frameworks | ✅ |

---

# 👨‍💻 Developer

**Nishant Awasthi**

---

# 📄 Assignment

**Dictionary Search & Auto-Suggestion System**
