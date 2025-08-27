# 📚 Alumnos Microservicio

Este microservicio permite **registrar alumnos** y **consultar alumnos activos** mediante una API REST sencilla.

---

## 🔹 Endpoints

### 1. Obtener alumnos activos
- **Método:** `GET`  
- **URL:** `http://localhost:8080/alumnos/activos`  

#### Ejemplo con cURL:

curl --location 'http://localhost:8080/alumnos/activos'

### 2. Registrar un alumno

- **Método:** `POST`  
- **URL:** `http://localhost:8080/alumnos`  
- **Headers:**  
  - `Content-Type: application/json`  

#### 📥 Request body

{
  "id": "1",
  "nombre": "Luis",
  "apellido": "Ginocchio",
  "estado": "activo",
  "edad": 37
}

#### Ejemplo con cURL:

curl --location 'http://localhost:8080/alumnos' \
--header 'Content-Type: application/json' \
--data '{
  "id": "1",
  "nombre": "Luis",
  "apellido": "Ginocchio",
  "estado": "activo",
  "edad": 37
}'

