# Sección 1 - Excepciones

## Ejercicios resueltos en vídeo

1. Crea una calculadora simple que realice operaciones básicas (suma, resta, multiplicación, división) y maneje excepciones en caso de que ocurran errores durante la operación.
Las excepciones a recoger son:
- `ArithmeticException` en caso de intentar dividir entre 0
- `IllegalArgumentException` en caso de requerir una operación no soportada

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/01.7_Ejercicio01/)
 
2. Escribe un programa en Java para simular un sencillo banco que tenga cuentas corrientes. 
- Cada cuenta corriente tendrá un saldo inicial y permitirá realizar operaciones como retirar dinero y hacer traspasos a otras cuentas.
- Si el saldo de la cuenta no es suficiente para realizar una operación, se lanzará una excepción personalizada llamada `SaldoInsuficienteException`.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/01.8_Ejercicio02/)

## Otros ejercicios resueltos

3. Modifica el ejercicio anterior para crear dos subtipos de excepción que hereden de `SaldoInsuficienteException`.
- Ambos dos tendrán, además del constructor "obligado" por extender la clase base, un nuevo constructor que acepte el saldo y la cantidad.
- Un subtipo será `SaldoInsuficienteRetiradaException`, y el otro `SaldoInsuficienteTransferenciaException`.
- En ambos casos el constructor que acepta dos valores numéricos llamará al constructor de la clase base con el mensaje de error conveniente.

Modifica el código de la clase CuentaCorriente para lanzar las excepciones que correspondan en cada caso.

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S01E03/)


4. Modifica el ejercicio 1 para que:

- Incluya un menú con 5 opciones, una por cada operación y otra para salir.
- Maneje la posible excepción que se puede provocar si el usuario introduce, cuando se espera un valor numérico, otra cosa.

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S01E04/)

## Ejercicios propuestos

5. Amplía el ejercicio 3 (que a su vez ya mejoraba el ejercicio 2) de forma que:
- Se cree la clase `CuentaCredito`, que extienda a `CuentaCorriente`. Como atributo añade un double con la cantidad de crédito del que se dispone.
- Este nuevo tipo de cuenta sí que permite realizar algunas operaciones sin tener saldo en las siguientes circunstancias:
  - El saldo de la cuenta no puede ser menor de -CREDITO. Es decir, que si tiene 500€ de crédito, el saldo no podrá ser de -501€, lanzándose como antes la excepción adecuada.
  - Si al realizar una operación (retirada de dinero o transferencia), el saldo queda en negativo pero superior a la cuantía indicada anteriormente, se dará un aviso al cliente de que **ha quedado en descubierto** (su saldo es negativo). Para ello se puede crear un nuevo tipo de excepción (por ejemplo, `SaldoNegativoException`).

6. Vamos a implementar la clase `Player` para un juego online. Algunos de los atributos que incluirá esta clase son `username`, `password` y `age`. Al pedir los datos al usuario, se deben dar las siguientes condiciones:
- El nombre de usuario no podrá estar repetido de entre todos los usuarios del juego.
- El nombre de usuario tendrá como mínimo 4 caracteres y como máximo 20.
- La contraseña tendrá como mínimo caracteres y como máximo 20, y debe incluir alguna letra, algún número y algún símbolo de entre los siguientes: $ - _ * !

Maneja con excepciones propias y/o proporcionadas por Java la posible gestión de errores que pueda suceder al solicitar al usuario que introduzca sus datos.

7. Amplía el ejercicio anterior creando la clase Game, que tendrá como atributo una edad mínima para jugar. Si el usuario que quiere jugar tendrá que tener al menos la edad requerida. En caso contrario, se debe lanzar una excepción propia.

8. Nos piden un programa en Java para manejar la relación jerárquica que hay entre los empleados de una empresa, de forma que un empleado puede ser el responsable o jefe directo de otros empleados, pero no de más de 5. Para ello:
   - Implementa la clase Empleado, incluyendo como atributos el nombre, apellidos, edad y email.
   - También tendrá como atributo una referencia al empleado que es su jefe directo.
   - Debe incluir también un List<Empleado>, almacenando los empleados que son sus subordinados.
   - Añade los métodos necesarios para establecer la relación entre un subordinado y su jefe.
¡OJO! Recuerda que un empleado puede ser jefe de como mucho otros 5 empleados. Si se intenta agregar un 6º subordinado, se debe producir una excepción.