# 🏦 Nequi Franquicias Microservicio

Este proyecto es un **microservicio** desarrollado en **Spring Boot**, que permite la gestión de **franquicias**, **sucursales** y **productos**, incluyendo operaciones como creación, actualización de stock y modificación de nombres. Fue desplegado en la nube usando una instancia **EC2** de **AWS** y utiliza una base de datos **MySQL** también alojada en **AWS RDS**.

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

Para la capa de persistencia de datos, se utilizó el motor de base de datos **MySQL**, implementado a través del servicio **Amazon RDS** (Relational Database Service) de **AWS**. Esta solución permite una administración eficiente, escalabilidad automática y alta disponibilidad de la base de datos en la nube.

**Datos de conexión:**

- **URL JDBC:**  `jdbc:mysql://database-1.c3sgk42s8hfr.us-east-2.rds.amazonaws.com:3306/nequi-pruebas`
- **Port:** `3306`
- **Base de Datos:** `nequi-pruebas`
- **Usuario:** `admin`
- **Contraseña:** `Sistemas123`

---

## 🌐 Despliegue en la Nube

Este microservicio se encuentra desplegado en una instancia **EC2 de AWS**, ejecutándose sobre un sistema operativo **Linux**. La instancia cuenta con una dirección IP pública. Para su implementación en la nube, se provisionó una máquina virtual en **Amazon EC2**, donde se realizó el despliegue del código de manera eficiente y segura.

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
  }
]
```
---
## ✅ Criterios de Aceptación
- **Exponer endpoint para obtener todas las franquicias**
  `GET` http://3.128.206.149:8080/api/franquicias/todas
    
      
- **Exponer endpoint para crear nueva franquicia**
  `POST` http://3.128.206.149:8080/api/franquicias
  
- **Exponer endpoint para crear nueva sucursal**
  `POST` http://3.128.206.149:8080/api/franquicias/2/sucursales
  
- **Exponer endpoint para agregar producto a una nueva sucursal**
  `POST` http://3.128.206.149:8080/api/franquicias/sucursales/1/productos

- **Exponer endpoint para eliminar producto**
  `DEL` http://3.128.206.149:8080/api/franquicias/productos/1


  
  
- **Exponer endpoint para actualizar Stock**
  `PUT` http://3.128.206.149:8080/api/franquicias/productos/1/stock
  
- **Exponer endpoint para obtener producto con mayor stock**
  `GET` http://3.128.206.149:8080/api/franquicias/2/productos-max-stock
  
- **Exponer endpoint para actualizar nombre de la franquicia**
  `PUT` http://3.128.206.149:8080/api/franquicias/sucursales/1/actualizar-nombre
  
- **Exponer endpoint para actualizar nombre de la sucursal**
  `PUT` http://3.128.206.149:8080/api/franquicias/sucursales/2/actualizar-nombre
  
- **Exponer endpoint para actualizar nombre de un producto especifico**
  `PUT`  http://3.128.206.149:8080/api/franquicias/productos/1/actualizar-nombre
  
  

### 📌 Endpoint

`GET` [http://3.128.206.149:8080/api/franquicias](http://3.128.206.149:8080/api/franquicias)

### 📝 Descripción

Exponer endpoint para obtener todas las franquicias.

###  (JSON)

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


### 📌 Endpoint

`POST` [http://3.128.206.149:8080/api/franquicias](http://3.128.206.149:8080/api/franquicias)

### 📝 Descripción

Exponer endpoint para crear nueva franquicia.

###  (JSON)

```json
{

    "nombre":"Sucursal Norte"
}
```


### 📌 Endpoint

`POST` [http://3.128.206.149:8080/api/franquicias/2/sucursales](http://3.128.206.149:8080/api/franquicias/2/sucursales)

### 📝 Descripción

Exponer endpoint para crear nueva sucursal.

###  (JSON)

```json
{
  "nombre": "Sucursal CC Andino"
}

```


### 📌 Endpoint

`POST` [http://3.128.206.149:8080/api/franquicias/sucursales/1/productos](http://3.128.206.149:8080/api/franquicias/sucursales/1/productos)

### 📝 Descripción

Exponer endpoint para agregar producto a una nueva sucursal.

###  (JSON)

```json
{
  "nombre": "Zapatos de vestir",
  "stock": 100
}


```

### 📌 Endpoint

`DELETE` [http://3.128.206.149:8080/api/franquicias/productos/1](http://3.128.206.149:8080/api/franquicias/productos/1)

### 📝 Descripción

Exponer endpoint para eliminar producto.

###  (JSON)

```json
{
  "id": 1
}


```

### 📌 Endpoint

`PUT` [http://3.128.206.149:8080/api/franquicias/productos/1/stock](http://3.128.206.149:8080/api/franquicias/productos/1/stock)

### 📝 Descripción

Exponer endpoint para actualizar Stock.

###  (JSON)

```json
{
  "stock": 120
}


```

### 📌 Endpoint

`GET` [http://3.128.206.149:8080/api/franquicias/2/productos-max-stock](http://3.128.206.149:8080/api/franquicias/2/productos-max-stock)

### 📝 Descripción

Exponer endpoint para obtener producto con mayor stock.

###  (JSON)

```json
[]


```


### 📌 Endpoint

`PUT` [http://3.128.206.149:8080/api/franquicias/sucursales/1/actualizar-nombre](http://3.128.206.149:8080/api/franquicias/sucursales/1/actualizar-nombre)

### 📝 Descripción

Exponer endpoint para actualizar nombre de la franquicia.

###  (JSON)

```json
{
  "nuevoNombre": "Nuevo Nombre de la Sucursal"
}


```


### 📌 Endpoint

`PUT` [http://3.128.206.149:8080/api/franquicias/sucursales/2/actualizar-nombre](http://3.128.206.149:8080/api/franquicias/sucursales/2/actualizar-nombre)

### 📝 Descripción

Exponer endpoint para actualizar nombre de la sucursal.

###  (JSON)

```json
{
  "nuevoNombre": "Sucursal Unicentro"
}


```



### 📌 Endpoint

`PUT` [http://3.128.206.149:8080/api/franquicias/productos/1/actualizar-nombre](http://3.128.206.149:8080/api/franquicias/productos/1/actualizar-nombre)

### 📝 Descripción

Exponer endpoint para actualizar nombre de un producto especifico.

###  (JSON)

```json
{
  "nuevoNombre": "Zapatos Deportivos"
}



```

