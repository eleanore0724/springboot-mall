# Shopping Mall with Java

一個以 **Java / Spring Boot** 為核心的電商後端系統，涵蓋商品、帳號與訂單等基本購物流程，並具備良好的擴充性，適合持續進行功能優化與架構演進。

---

##  專案目標
- 建立完整的電商後端核心功能
- 實作模組化、可維護的系統架構

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

##  目錄

- [功能模組 (Modules)](#功能模組-modules)
  - [1. 商品功能 (Product Module)](#1-商品功能-product-module)
  - [2. 帳號功能 (User Account Module)](#2-帳號功能-user-account-module)
  - [3. 訂單功能 (Order Module)](#3-訂單功能-order-module)
- [技術亮點 (Technical Highlights)](#技術亮點-technical-highlights)
- [測試 (Testing)](#測試-testing)

---

## 功能模組 (Modules)

### 1. 商品功能 (Product Module)
商品模組是系統的基礎，實現了標準的 CRUD 操作與進階查詢功能。

- **基礎 CRUD 實作**：
  - 支援新增 (Create)、查詢 (Read)、修改 (Update)、刪除 (Delete) 商品。
  - 使用 `Enum` 類型規範商品類別與狀態。
  - 統一規範時間格式，確保前端接收到的時間資訊一致。

- **進階商品列表查詢**：
  - 實作了複雜的查詢邏輯，支援三個維度的操作：
    - **查詢條件 (Filtering)**：依據類別或關鍵字篩選。
    - **排序 (Sorting)**：支援不同欄位的排序功能。
    - **分頁 (Pagination)**：實作分頁機制以優化大量數據的讀取效能。

### 2. 帳號功能 (User Account Module)
帳號模組高度重視**資訊安全 (Information Security)**，確保使用者數據的隱私與安全。

- **註冊功能 (Registration)**：
  - 實作 Email 唯一性檢查，防止重複註冊。
  - **隱私保護**：回應前端請求時自動隱藏密碼欄位，避免敏感資訊外洩。

- **登入功能 (Login)**：
  - **密碼加密儲存**：嚴格遵守資安底線，所有使用者密碼在寫入資料庫前均經過加密處理，絕不明文儲存。
  - 實作安全的登入驗證流程。

### 3. 訂單功能 (Order Module)
訂單模組處理交易邏輯，重點在於數據的一致性與錯誤處理。

- **創建訂單 (Create Order)**：
  - **身分驗證**：檢查 User 是否存在。
  - **庫存檢查**：在下單前檢查商品庫存，防止超賣 (Overselling)。
  - **錯誤處理 (Error Handling)**：完善處理各種 Error Case，避免使用者輸入錯誤資訊導致數據異常。

- **查詢訂單 (Order History)**：
  - 支援透過 User ID 查詢該使用者歷史購買的所有訂單列表。

---

## 技術亮點 (Technical Highlights)

本專案在實作過程中特別注重以下開發規範與細節：

* **RESTful API 設計**：規範的 CRUD 實作。
* **資訊安全 (InfoSec)**：將資安視為開發底線，實作了嚴格的密碼加密機制。
* **數據規範**：使用 Enum 管理狀態，並統一 API 的時間格式回傳。
* **複雜查詢處理**：解決後端開發中具挑戰性的「條件篩選 + 排序 + 分頁」整合查詢。
* **防呆機制**：在庫存扣減與訂單建立時進行嚴謹的邏輯檢查。

---

## 測試 (Testing)

為了確保程式碼的正確性與穩定性，本專案針對各功能模組皆撰寫了單元測試 (Unit Tests)。

* **商品功能測試**：涵蓋 CRUD 各個環節的驗證。
* **帳號功能測試**：針對註冊與登入流程進行測試。
* **測試策略**：著重於從「不同的角度」切入，包含正常流程與邊界情況 (Edge Cases)，確保系統功能的可靠性。

