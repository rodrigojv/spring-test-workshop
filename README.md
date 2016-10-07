## Workshop de Testing para Aplicaciones Java con Spring Boot ##

Aplicación de ejemplo para workshop de testing de aplicaciones Java con Spring Boot.

La aplicación permite a un usuario tener un watchlist de películas que tiene ganas de ver.

Para una vista general de los temas tocados, referir a [el script de la charla](script.md) en combinación con [el historial de commits](https://github.com/rodrigojv/spring-test-workshop/commits/master).

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
1. Clonar el proyecto localmente
```
$ git clone https://github.com/rodrigojv/spring-test-workshop
```

2. Ejecutar el proyecto: 
```
$ cd spring-test-workshop/initial
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

    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD FAILURE
    [INFO] ------------------------------------------------------------------------
   
   ```

5. Importar el proyecto `spring-test-workshop/initial` como proyecto Maven al IDE para empezar a trabajar  

## Referencias
* Standard para nombramiento de test: http://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html
* AssertJ: http://joel-costigliola.github.io/assertj
