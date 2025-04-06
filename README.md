# 🏦 Nequi Franquicias Microservicio

Este proyecto es un **microservicio** desarrollado en **Spring Boot**, que permite la gestión de **franquicias**, **sucursales** y **productos**, incluyendo operaciones como creación, actualización de stock y modificación de nombres. Fue desplegado en la nube usando una instancia **EC2** de **AWS** y utiliza una base de datos **MySQL** también alojada en AWS RDS.

---

## 🚀 Tecnologías Utilizadas

- ☕ **Java 17 (JDK 17)**
- 🌱 **Spring Boot**
- 🐘 **Maven**
- 🛢️ **MySQL (AWS RDS)**
- ☁️ **Amazon EC2**
- 🧪 **Postman (colección de endpoints)**

---

## 💾 Base de Datos

Se utilizó **MySQL** en un servicio de **RDS (Relational Database Service)** de **AWS**.

**Datos de conexión:**

- **URL JDBC:**  `jdbc:mysql://database-1.c3sgk42s8hfr.us-east-2.rds.amazonaws.com:3306/nequi-pruebas`
- **Port:** `3306`
- **Base de Datos:** `nequi-pruebas`
- **Usuario:** `admin`
- **Contraseña:** `Sistemas123`

---

## 🌐 Despliegue en la Nube

Este microservicio está desplegado en una instancia **EC2 de AWS** con la siguiente dirección pública:

### 🔗 IP Pública: 3.128.206.149:8080

Para evitar ejecutar el proyecto localmente, puedes utilizar directamente el servicio en la nube:

**Ejemplo:**

`GET`
http://3.128.206.149:8080/api/franquicias/todas

```json
[
  {
    "id": 1,
    "nombre": "Grupo A"
  },
  {
    "id": 2,
    "nombre": "Grupo B"
  },
  {
    "id": 3,
    "nombre": "Sucursal del Norte"
  }
]
```
