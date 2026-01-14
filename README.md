# Shopping Mall with Java

一個以 **Java / Spring Boot** 為核心的電商後端系統，涵蓋商品、帳號與訂單等基本購物流程，並具備良好的擴充性，適合持續進行功能優化與架構演進。

---

##  專案目標
- 建立完整的電商後端核心功能
- 實作模組化、可維護的系統架構
- 為後續高併發、金流、權限管理等需求預留彈性

---

##  技術
- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA / JDBC
- MySQL
- Maven
- RESTful API

---

##  Current Development

### 商品功能（Product）
- 商品新增 / 修改 / 刪除
- 商品查詢（單筆 / 列表）
- 商品庫存管理

### 帳號功能（Account）
- 使用者註冊
- 使用者登入
- 基本帳號資料管理

### 訂單功能（Order）
- 建立訂單
- 查詢訂單
- 訂單與商品關聯

---

### B. 帳號功能（Account）

#### 1. Token 驗證機制
- 使用 **JWT**
- 實作：
  - 登入取得 Token
  - API Token 驗證
  - Token 過期與刷新機制

---

### C. 訂單功能（Order）

#### 1. 高併發 / 搶購問題
- 解決超賣問題
- 規劃方案：
  - Redis 鎖
  - 樂觀鎖 / 悲觀鎖
  - 訂單排隊機制

#### 2. 訂單狀態管理
- 訂單狀態流程：
  - CREATED（已建立）
  - PAID（已付款）
  - SHIPPING（配送中）
  - COMPLETED（完成）
  - CANCELED（取消）
  - REFUNDING（退款中）
  - REFUNDED（已退款）
- 搭配物流狀態追蹤

#### 3. 金流串接
- 串接第三方金流（如：Line Pay / 綠界 / 藍新）
- 處理：
  - 付款請求
  - Callback 驗證
  - 付款成功 / 失敗流程

---

