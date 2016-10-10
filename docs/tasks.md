## Tareas para el programador audaz

Agregar la siguiente funcionalidad a la aplicación:

* Un usuario no puede agregar una misma película dos veces a su watchlist.
  
  Por ejemplo, un usuario ya tiene en su watchlist 'Man of Steel'.
  
  Si se agrega una segunda vez 'Man of Steel', se debe lanzar un `MovieAlreadyInWatchlistException`.

* Cuando se invoca a `POST - users/clark/watchlist` para agregar una película ya existente se debe retornar un error 4XX. 

* Esribir tests de integración y unitarios a nivel de Controllers, para este nuevo control.