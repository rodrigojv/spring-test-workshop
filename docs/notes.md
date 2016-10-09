
Notas de preguntas y temas charlados durante el taller
-----------

No tengo ppt :)

Ventajas de test unitarios:
- Mayor robustez
- Tranquilidad para hacer refactor
- Documentación
- Mejor diseño de clases (API), con o sin TDD :)


## ¿Qué es TDD?
Es escribir primero el test, sin tener aún la implementación.
Provee la ventaja de que guia el diseño del API de la clase bajo test.

Pasos en un flujo de TDD:
1) Escribir test que haga fallar el feature nuevo o método
2) Implementar el método con lo mínimo para hacer que pase el test
3) Refactorear la solución
4) Volver al paso 1) y hacer que falle la implementación que se tiene hasta el momento

## ¿Qué significa test de regresion?
Respuesta: los unit test ya son test de regresión. 
Aseguran que con cualquier cambio (bug fix o feature), lo que ya funcionaba antes del cambio, siga funcionando.

http://stackoverflow.com/questions/3464629/what-does-regression-test-mean
