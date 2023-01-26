# StreamingBackEnd

## Datos del proyecto

- Proyecto creado en Spring Boot 2.7.6 (https://start.spring.io/). 
- Uso de java jdk 19.

## Depenciancias utilizadas 

- PosgresDriver
- Spring Web
- Spring Boot DevToos
- Spring Data JPA
- Lombok
- Swagger 3.0.0

## Pasos para iniciar proyecto

1. Crear una base en posgreSQL, propiedades en el archivo aplication.properties.
2. Limpiar dependencias Mavel con el siguiente comando:
`mvn clean`.
3. Instalar dependencias Mavel con el siguiente comando: `mvn install`.
4. Arrancar el proyecto con el siguente comando: `mvn spring-boot:run`; puerto por defecto `8080`