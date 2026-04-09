 # World of Tanks Statistics API 📊

Ez a projekt egy **Java Spring Boot 3** alapú REST API, amely a hivatalos Wargaming.net Open API-t használja fel. Segítségével lekérdezhetők a játékosok statisztikái, a garázsukban lévő tankok adatai, valamint a teljes World of Tanks jármű-enciklopédia.


## ✨ Funkciók
- **Felhasználókezelés:** Biztonságos regisztráció és JWT (Bearer Token) alapú hitelesítés.
- **Személyes statisztikák:** Játékos szintű adatok (győzelmi arány, csaták száma, átlagos sebzés).
- **Jármű elemzés:** A játékos saját tankjainak és azok teljesítményének (rating) listázása.
- **Teljes Enciklopédia:** Részletes technikai adatok minden járműhöz (páncélzat, ágyú jellemzők, modulok fája, árak).

## 🚀 Technológiai Stack
* **Backend:** Java 17, Spring Boot 3.x
* **Security:** Spring Security, JWT (JSON Web Token)
* **API Client:** Spring WebFlux (`WebClient`) a reaktív külső hívásokhoz.
* **Adatkezelés:** Lombok, Jackson (Snake Case JSON mapping).

## 🛠️ Telepítés és Konfiguráció

1.  **Wargaming API Kulcs:** Szerezz egy `application_id`-t a [Wargaming Developer Room](https://developers.wargaming.net/) oldalon.
2.  **Klónozás:**
    ```bash
    git clone [https://github.com/yourusername/wot-api.git](https://github.com/yourusername/wot-api.git)
    cd wot-api
    ```
3.  **Beállítás:** Az `src/main/resources/application.properties` fájlban add meg az azonosítódat:
    ```properties
    wargaming.api.key=YOUR_APPLICATION_ID_HERE
    spring.application.name=wotandme

    jwt.secret=mZ7Jx7sJX3kF4Zp5n8W2cL1tQ9vR6yT0aBcDeFgHiJk=
    jwt.expiration=86400000

    app.id=SECRET APP ID (USE PWN ID REQUESTED FROM WOT DEV)
    api.account.list=?application_id=
    ```
4.  **Futtatás:**
    ```bash
    ./mvnw spring-boot:run
    ```

## 🔌 API Végpontok

### 🔐 Autentikáció
A személyes adatok eléréséhez regisztráció és a kapott token használata szükséges.

* **Regisztráció:** `POST /wot/player/registration`
    * **Body (JSON):**
        ```json
        {
          "email": "pelda@email.hu",
          "password": "titkosjelszo",
          "nickname": "Dooring"
        }
        ```
    * *Sikeres regisztráció esetén a válaszban egy JWT (Bearer) Tokent kapsz.*

---

### 👤 Játékos Adatok
*(A végpontokhoz `Authorization: Bearer <token>` fejléc szükséges)*

| Végpont | Leírás | Paraméter |
| :--- | :--- | :--- |
| `GET /wot/player/data` | Személyes statisztikák lekérése | `nickname=Dooring` |
| `GET /wot/player/vehicles` | A játékos garázsában lévő járművek | `nickname=Dooring` |
| `GET /wot/player/vehicles/stats` | Járművekre lebontott teljesítmény | `nickname=Dooring` |

---

### 🚜 Jármű Enciklopédia

* **Járművek listája:** `GET /wot/vehicle/list`
    * Visszaadja a játék összes tankjának alapvető adatait.
* **Részletes adatlap:** `GET /wot/vehicle/details?tank_id=7505`
    * Visszaadja a tank minden technikai paraméterét: HP, páncélzat, ágyú adatok (stun, penetration), modulok és fejlesztési fa.

## ⚙️ Technikai megoldások (DTO & Mapping)
Az API kezelése során az alábbi kihívásokat oldottuk meg:

1.  **Wrapper Kezelés:** A Wargaming API minden választ egy `data` objektumba csomagol, ahol a kulcs a dinamikus `tank_id`. Ezt egy generikus `WargamingResponseDTO<T>` osztály kezeli le.
2.  **Snake Case Konverzió:** Az API `snake_case` mezőit (pl. `speed_forward`) a Java DTO-k automatikusan `camelCase` formátumba képezik le a `@JsonNaming` annotáció segítségével.
3.  **Összetett típusok:** Az olyan mezők, mint az `ammo.stun.duration` vagy a `damage`, listaként érkeznek `[min, avg, max]` formátumban, melyeket speciális DTO struktúra dolgoz fel.

## 📝 Roadmap / To-Do
- [ ] Hibakezelés finomítása (pl. nem létező nickname vagy API hiba esetén).
- [ ] Caching (Redis) implementálása az enciklopédia adatokhoz.
- [ ] Swagger/OpenAPI dokumentáció integrálása a könnyebb teszteléshez.
- [ ] ## ️ 🛠️TODO:
- [ ] **Basic Api** hívások kirefaktorálása és paraméterek inputja
- [ ] **WN8** és hozzá tartozó tábla letöltése és implementálása
- [ ] **Tankok** és ID-k lokális tárolása
- [ ] **Hibakezelés** és Try catch és időtúllépések és retry
- [ ] **releváns adatok** wrappolása csoportokba a megjeleníthetőségért
- [ ] **Redis** vagy egy egyszerű memóriabeli cache-t a gyakran lekérdezett játékosok adataihoz
- [ ] **Lazy Loading**: Ha egy játékos összes tankját listázod (ami lehet akár 400+ is), ne egyszerre rendereld
  le az összeset képekkel együtt, mert belassítja a böngészőt.
  Használj "infinite scroll"-t vagy lapozást.

- [ ] **Képoptimalizálás**: A tankok ikonjait ne a WG szervereiről húzd be minden egyes alkalommal,
  hanem ha lehet, használj optimalizáltabb forrást vagy helyi sprite-okat.
- [ ] **SOLID**
- [ ] **UnitTesztek**
- [ ] **Adatkalkulálások és Grafikonok**

---
*Készült a World of Tanks rajongók és fejlesztők számára.*
