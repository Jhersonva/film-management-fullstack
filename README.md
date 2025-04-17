# 🎥 Film-Management-FullStack

## 🌟 Descripción general del proyecto
Un sistema de gestión de películas FullStack que permite a los usuarios gestionar registros de películas mediante operaciones CRUD. Este proyecto se creó utilizando **Java**, **Spring Boot**, **JPA**, **Validatión** **MySQL**, **HTML**, **CSS** y **JavaScript**.

## 🛠️ Tecnologías utilizadas

### Backend
- **☕ Java**: lenguaje de programación central
- **🌱 Spring Boot**: Marco para construir el backend
- **📦 JPA**: API de persistencia de Java para interacción con bases de datos
- **🐬 MySQL**: Base de datos para almacenar registros de películas
- **🔧 Spring Boot DevTools**: herramientas de desarrollo para recarga en caliente
- **🛡️ Validación**: garantizar la integridad de los datos
- **🚀 XAMPP**: Solución de servidor para gestión de MySQL
- **🗃️ phpMyAdmin**: Interfaz para administrar bases de datos MySQL

### FrontEnd
- **📄 HTML**: Estructura de páginas web
- **🎨 CSS**: Estilo de páginas web
- **⚙️ JavaScript**: funcionalidad dinámica para la interfaz de usuario

## 🚀 Instalación

### Backend
1. **Clona el repositorio desde GitHub:**

    ```bash
    git clone https://github.com/Jhersonva/film-management-fullStack.git
	cd Film-Management/gestion-peliculas-backend
    ```

2. **Configurar la base de datos MySQL:**
	- Inicia XAMPP y lanza MySQL.
	- Crea una base de datos llamada `db_gestion_pelicula` en `phpMyAdmin`.

3. **Configurar las propiedades de la aplicación:**
	- Actualiza el archivo `src/main/resources/application.properties` con tus credenciales de MySQL

4. **Ejecutar el Backend:**

### FrontEnd:

1. **Navegar al Directorio del Frontend**:

 ```bash
    cd film-management-fullStack/gestion-peliculas-frontend
 ```
2. **Abrir index.html en tu navegador web**.

## 🔧 Uso
**Endpoints de la API**
- GET `/api/pelicula/list?page={page}:` Obtener películas paginadas.
- POST `/api/pelicula/create`: Crear una nueva película.
- PUT `/api/pelicula/{id}`: Actualizar una película por ID.
- DELETE `/api/pelicula/{id}`: Eliminar una película por ID.

**Funcionalidades del Frontend**
- 📋 Lista de Películas: Muestra películas con paginación.
- ➕ Agregar/Editar/Eliminar: Gestiona los registros de películas.
- 🔄 Paginación: Navega entre las páginas usando los botones 'Anterior' y 'Siguiente'.

## 🛡️ Validación
Se asegura de que todos los campos estén completos antes de enviar los formularios. Los mensajes de error guían a los usuarios para que completen los campos necesarios.

## 📝 Uso

1. Accede a la interfaz de usuario a través del archivo `formulario.html`.
2. Ingresa los datos como `Título`, `Director` y `Género` en el formurlario.
3. Los botones de agregar, editar y eliminar, realizan una acción en especifica.
4. Los datos agregados, se estaran guardando en la base de datos y para el posterior uso.
5. No permitira crear peliculas, si los campos no han sido rellenados.

## 📜 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para obtener más información.

## 📞 Contacto

- [LinkedIn](https://www.linkedin.com/in/jhersonvillaarcibia/)
- [WhatsApp](https://wa.me/926461654)
- Gmail: jherson2408va@gmail.com
