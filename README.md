## Workshop de Testing para Aplicaciones Java con Spring Boot ##

Aplicación de ejemplo para workshop de testing de aplicaciones Java con Spring Boot.

La aplicación permite a un usuario tener un watchlist de películas que tiene ganas de ver.

¿Querés seguir este taller desde tu casa? Referir a [esta sección](#pasos-a-seguir).

## Requisitos

* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* IDE recomendados: [Eclipse STS](https://spring.io/tools/sts), IntelliJ
* Git (duh!)

## Objetivos
- Entender ventajas de tener test unitarios
- Entender cómo configurar y correr tests usando Spring Boot
- Aprender a escribir tests:
	1. Unitarios
	2. De Controladores y Servicios usando Mockito
	3. De Integración
- Aprender las mejores prácticas para escribir tests :-)

## Inicio rápido

1. Clonar el proyecto localmente. No vale espiar la carpeta 'complete'

    ```
    $ git clone https://github.com/rodrigojv/spring-test-workshop
	$ cd spring-test-workshop/initial
    ```
2. Ejecutar el proyecto: 
    
    ```
    $ mvn spring-boot:run
    ```
3. Acceder a: 
    
    ```
    http://localhost:8080/users
    ```
4. Correr los tests:
   * Detener el servidor levantado en paso anterior `ctrl+c`.
   * Ejecutar los tests con Maven
   
        ```
        $ mvn test
        ```   
   * Como resultado deben haber 20/20 tests fallidos. La idea es hacerlos pasar todos durante el workshop.. Wohoo! :D
   
        ```
        Tests run: 20, Failures: 20, Errors: 0, Skipped: 0

        [INFO] --------------------------------------
        [INFO] BUILD FAILURE
        [INFO] --------------------------------------
        ```
5. Importar el proyecto `spring-test-workshop/initial` como proyecto Maven al IDE para empezar a trabajar  

## Pasos a seguir

Para un seguir este taller ver lo que pide cada método `@Test` en las clases `*Test.java` de la carpeta `initial` de este repositorio.

Luego hacer que pase el test, implementando lo que pide el método y comparar la solución con el resultado final en la carpeta `complete`.

También hacer referencia a las [notas](docs/notes.md) sobre preguntas y cuestiones surgidas durante el taller.

Por último se puede referir a mi [copiatini](docs/script.md) para ver el orden de implementación de los tests
que se siguen durante este taller.


## Referencias
* Standard para nombramiento de test: http://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html
* AssertJ: http://joel-costigliola.github.io/assertj
* Patrón para escribir tests "AAA": http://defragdev.com/blog/?p=783
* ¿Qué es test de regresión? http://stackoverflow.com/questions/3464629/what-does-regression-test-mean