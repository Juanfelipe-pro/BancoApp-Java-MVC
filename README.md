# 💳 BancoApp — Sistema Bancario en Consola (Java MVC)

Aplicación de consola en **Java** basada en el patrón **MVC (Modelo–Vista–Controlador)**  
que simula un sistema bancario con **clientes, cuentas, transacciones e historial**.  
Desarrollado para practicar **POO, herencia, interfaces y colecciones** en **IntelliJ IDEA**  
sin dependencias externas ni frameworks.

---

## 🧩 Características principales

✅ Patrón MVC completo (Modelo / Vista / Controlador)  
✅ Uso de `interface` para las operaciones bancarias  
✅ Herencia entre `CuentaBancaria`, `CuentaAhorros` y `CuentaCorriente`  
✅ Registro de clientes y múltiples cuentas por cliente  
✅ Depósitos, retiros, sobregiros e intereses  
✅ Historial de transacciones con fecha y hora  
✅ Arquitectura modular y escalable  
✅ 100% compatible con IntelliJ IDEA sin Maven

---

## 🗂️ Estructura del proyecto

```
BancoApp/
 └── src/
      └── com/banco/
           ├── interfaz/
           │    └── OperacionesBancarias.java
           ├── modelo/
           │    ├── Banco.java
           │    ├── Cliente.java
           │    ├── CuentaBancaria.java
           │    ├── CuentaAhorros.java
           │    ├── CuentaCorriente.java
           │    └── Transaccion.java
           ├── vista/
           │    └── BancoVista.java
           ├── controlador/
           │    └── BancoControlador.java
           └── Main.java
```

---

## ⚙️ Cómo ejecutar

1. Abre **IntelliJ IDEA** → “New Project” → “Java Project”.
2. Copia la estructura anterior dentro de `src/com/banco/`.
3. Asegúrate de que el archivo principal sea:

   ```java
   com.banco.Main
   ```

4. Ejecuta el proyecto (Shift + F10 o el botón ▶️ en IntelliJ).

---

## 🧠 Conceptos que aprenderás

- **POO (Programación Orientada a Objetos):**
  - Abstracción, encapsulamiento, herencia y polimorfismo.
- **Interfaces y clases abstractas.**
- **Colecciones (`ArrayList`)** y búsqueda de objetos.
- **Estructura MVC aplicada a consola.**
- **Buenas prácticas de arquitectura limpia en Java.**

---

## 🧾 Ejemplo de uso

```
===== BANCO =====
1. Registrar cliente
2. Crear cuenta
3. Listar clientes y cuentas
4. Operar cuenta
5. Ver historial
6. Salir

Selecciona opción: 1
ID del cliente: 001
Nombre del cliente: Juan Felipe
✅ Cliente registrado.

Selecciona opción: 2
ID del cliente: 001
1. Cuenta de Ahorros
2. Cuenta Corriente
Tipo de cuenta: 1
Número de cuenta: 1001
Saldo inicial: 2000
✅ Cuenta creada correctamente.
```

---

## 🧰 Tecnologías usadas

- **Lenguaje:** Java 17+
- **IDE recomendado:** IntelliJ IDEA Community Edition
- **Paradigma:** Orientado a Objetos (POO)
- **Arquitectura:** MVC clásico por consola

---

## 👨‍💻 Autor

**Juan Felipe Alvear**  
💼 *Backend Developer (Java | Python | Spring Boot | FastAPI)*  
🎯 Proyecto educativo para fortalecer fundamentos antes de 42 Lisboa 2025.

📎 GitHub: [Juanfelipe-pro](https://github.com/Juanfelipe-pro)

---

## 🪄 Próximos pasos (versión 2)

🚀 Persistencia de datos con archivos `.json` o `.txt`  
🧩 DAO para guardar y cargar clientes y transacciones  
💾 Migración futura a JDBC o Spring Boot  
🖥️ Interfaz gráfica con JavaFX (opcional)
