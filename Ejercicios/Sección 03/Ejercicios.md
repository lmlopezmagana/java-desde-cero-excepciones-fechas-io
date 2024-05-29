# Sección 3 - Modularidad

## Ejercicio resuelto en vídeo

1. Queremos modularizar una aplicación existente ([calendario escolar](../../Ejemplos/03.3_Ejercicio01SinModulos/)). Hay un paquete de implementación interna que se desea ocultar.

> Las fechas escogidas para el calendario escolar son las más habituales en Andalucía, y aunque se contemplan algunas posibilidades, no se han incluido los festivos u otros elementos que la harían totalmente real.

> Se podría dar la posibilidad de ofrecer uno de los módulos como una librería empaquetada en un jar.

La modularización quedaría de la siguiente forma.

- Un módulo, llamado `modulouno`, que incluirá las funciones referentes a fechas.
- Otro módulo, llamado `modulodos`, que incluirá la aplicación en sí (`main`).

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo en los siguientes enlaces: 

- [Módulo 1](../../Ejemplos/03.3_Modulo1)
- [Módulo 2](../../Ejemplos/03.3_Modulo2)

## Otro ejercicio resuelto

2. Crea una aplicación que conste de 3 módulos

- `moduloa`, que incluirá la clase `net.openwebinars.app.App`
- `modulob`, que incluirá la clase `net.openwebinars.service.Saludador`
- `moduloc`, que incluirá la interfaz `net.openwebinars.model.Saludable` y la clase `net.openwebinars.model.Mundo`.

El módulo `moduloa` depende directamente del módulo `modulob` y transitivamente del módulo `moduloc`.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo en los siguientes enlaces: 

- [moduloa](../S03E02M1/)
- [modulob](../S03E02M2/)
- [moduloc](../S03E02M3/)


## Ejercicio propuesto

3. Intenta modularizar el proyecto del [Ejercicio 2 del bloque de fechas](../../Ejemplos/02.9_Ejercicio02) de forma que:

- La clase cliente pueda estar en un módulo llamado `model`
- Los métodos de la clase `CalculadoraDescuentos` que no dependan del modelo pasen a una clase que quede en un paquete interno.
- Los métodos de la clase `CalculadoraDescuentos` que sí dependan del modelo estén en otro módulo que se exporte.
- Un último módulo, `app`, que requiera los módulos necesarios e incluya el código de la aplicación.

