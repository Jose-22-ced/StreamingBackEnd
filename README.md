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

## Pasos para dockerizar el proyecto

2. Limpiar el proyecto usando el siguente comando: `maven clean`.
3. Compilar el proyecto usando el siguente comando: `maven install `.
4. Una vez compilado se creara un archivo .jar, en el carpeta target.
5. Revisar que todo los parametros del nombre de aplicativo este correcto en el archivo Dockerfile.
6. En algún termiar y nos direccionamos en la carpeta raiz.
7. Una vez ahí, ejecutamos el siguente comando: `docker build -t "streaimgbackend-docker" .`, con este comando creamos la imagen
8. Una vez la imagen sea creada, ejecutamos el siguente comando: `docker run --name streaimg-back-end-docker-spring-docker -p 8080:8080 streaimgbackend-docker:latest`
9. Con el ultimo comando, podemos ejecutar diferentes containers, recordar cambiar los puestos. 