## Testing Spring Boot Applications ##

## Initial Import
Introducir la aplicación, ejecutar desde Eclipse y mostrar los endpoints.

Ejecutar los tests desde consola y desde el Eclipse.

## Application overview
* Mostrar la clase principal `Application`
* Mostrar clases del paquete `domain`
* Mostrar el paquete `service`
   * Empezar con `MovieServiceImpl` y luego ver `UserServiceImpl`
   * En `UserServiceImpl` explicar `addToWatchList`
* Mostrar el paquete `web`
   * Empezar con `UserController`
   * Luego ir a `UserWatchListController`

## Agregar test unitario
* Mostrar `MovieParser`
* Agregar `MovieParserTest`. Explicar qué es un test unitario
* Explicar nomenclatura
* Agregar test para el `parse()` camino feliz
* Usar primero `assertTrue`
* Migrar a `AssertJ`
* Agregar un espacio a la lista de movies. Comentar solución de bugs. Regexp: ",\\s*"
* Agregar soporte para lista separadas por pipe `|` . Comentar evolución. Regexp: "[,|]\\s*"
* Comentar ventaja de documentación
* Pedir un test del método `MovieParser.toString(list)`

## Agregar test de capa de Servicios - MovieServiceTest
* Mostrar `MovieServiceTest`
* Implementar `getMovieByTitleShouldReturnMovieAndRating` y explicar lo necesario para poder llamar a `getByTitle`
* Explicar utilidad de **Framework de Mock**
* Explicar `@Before`
* Explicar por qué se instancia manualmente `MovieService`
* Explicar anatomia de un buen test con estructura `AAA`
* Agregar test para pelicula que no existe. Implementar `getNotExistingMovieShouldThrowException`
* Explicar como manejar los casos de Excepciones

## Agregar test para capa de Servicios - UserServiceTest
* Mostrar `UserServiceTest` y la clase `AbstractMockTest`
* Pedir implementar el test para findAll()
* Pedir implementar el test para getUser() camino feliz y de user no existente
* Implementar el test de addToWatchlist
* Explicar refactor para retornar un User. Para poder testear y tener un mejor API
* Crear método para test de agregar película PG_13

## Agregar tests de integracion para Servicios - MovieServiceIntegrationTest
- Mostrar `MovieServiceIntegrationTest` y su nomenclatura
- Explicar qué es un test de integración
- Explicar qué hace `DataJpaTest`
- Explicar por qué hay que instanciar manualmente `MovieService` 
- Copiar los tests de `MovieServiceTest` y hacer los ajustes

## Agregar test de integración para Servicios - UserServiceIntegrationTest
- Mostrar clase`UserServiceIntegrationTest`
- Copiar lo que hay en `UserServiceTest`
- Sacar los `Mocks` y agregar `@Autowired` para los repos
- Instanciar manualmente `MovieService` con su repo
- Instanciar manualmente `UserService`
- Quitar las lineas de Mockito `when.(...).thenRetun(...)`

## Agregar test unitario de capa web - UserController
- Mostrar `UserControllerTest`
- Explicar el mocking de `UserController`
- Mostrar propiedad `MockMvc mvc` y creación en `Before`
- Implementar test para hacer un request de todos los usuarios `requestingAllUsersShouldReturnJsonArrayAndStatusOk`
   - Explicar `doPrint()` para debug
- Implementar método `requestingNotExistingUserShouldReturnNotFound`
- Pedir implementar método para request de user por username: `requestingUserByUsernameShouldReturnJsonWithUser`

## Agregar test unitario de capa web - UserWatchListController
- Mostrar `UserWatchListControllerTest`
- Implementar test para agregar PG13 movie a usuario menor de 13
  - Controlar status `422` como retorno del test
- Pedir implementar test para agregar una película al usuario 'clark': `requestingAddMovieToWatchListShouldReturnAccepted`
  - Se debe hacer mock de `userService.addToWatchlist` y preguntar si el resultado del request fue `ACCEPTED`

## Si hay tiempo
- Pedir en `UserWatchListControllerTest` un test para obtener el watchlist de un usuario
- Mostrar `UserWatchListControllerIntegrationTest`
- Explicar las anotaciones `SpringBootTest` y las de base de datos
- Explicar el `webAppContextSetup`
- Crear un test para agregar agregar una película a un watchlist
 - Explicar refactor para que el endpoint retorne el usuario con su watchlist
 - Preguntar por el watchlist del usuario y comparar el resultado con el watchlist de la primera llamda



