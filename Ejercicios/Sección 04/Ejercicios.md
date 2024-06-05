# Sección 4 - Entrada / Salida

## Ejercicios resueltos en vídeo

1. Implementar una herramienta que sea capaz de copiar directorios, incluyendo su contenido. Debe recibir los datos necesarios por la línea de argumentos. Si la carpeta de destino existe, se preguntará al usuario si desea *sobreescribirla* o detener la operación

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/04.9_Ejercicio01/)

2. Cifrado del César

El [cifrado del César](https://es.wikipedia.org/wiki/Cifrado_C%C3%A9sar) es un mecanismo de cifrado por sustitución que cambia una letra por otra, aplicando un desplazamiento fijo (por ejemplo, de 3 posiciones en el abecedario).

Implementar una aplicación que reciba un fichero de texto y le aplique el cifrado del César. Debe recibir por la línea de argumentos el fichero de entrada, el fichero de salida, y un entero indicando el desplazamiento.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/04.10_Ejercicio02/)


## Otros ejercicios resueltos

3. Modifica el ejercicio anterior para añadir la posibilidad de descifrar. Para ello, en la línea de argumentos recibirá uno nuevo, quedando así

`java CifradoCesar <modo> <origen> <destino> <desplazamiento>`

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S04E03/)

4. Implementa una herramienta en Java similar a `find` de los sistemas Linux/Unix, que permita buscar en una jerarquía de directorios, aquellos que cumplen un patrón glob concreto. Ten en cuenta que:

- Puedes usar la clase [`PathMatcher`](https://docs.oracle.com/en/java/javase/17/docs//api/java.base/java/nio/file/PathMatcher.html) para verificar si el fichero cumple con el patrón Glob.
- Debes implementar un `FileVisitor` que muestre los ficheros que cumplen el patrón glob.

La sintaxis de llamada a la herramienta puede ser la siguiente:

`java GlobFinder <directorio> <patrón glob>`

## Ejercicios propuestos

5. Implementa una herramienta similar a `wc` de los sistemas Linux/Unix que sea capaz de contar el número de líneas, palabras y letras que tiene un fichero de texto. La ruta del fichero la puede recibir desde la línea de argumentos.

6. Modifica el ejercicio anterior para que, en caso de no recibir ningún argumento, realice el conteo desde la entrada estándar `System.in`.

7. Implementar una aplicación que sea capaz de leer un fichero en [formato CSV](https://es.wikipedia.org/wiki/Valores_separados_por_comas), y transformarlo en un documento HTML (el cual será almacenado en un fichero).

La aplicación recibirá como argumento la ruta al fichero, y tendrá que detectar cual es el carácter separador, que podrá estar entre los siguiente:

- coma (,)
- punto y coma (;)
- tabulador (\t)

A partir de ahí, deberá leer los datos, y tendrá que procesarlos "al vuelo" en una tabla HTML, que irá almacenando en una lista de cadenas de caracteres (se recomienda usar la clase StringBuilder). Se recuerda que el código de una tabla HTML es, como mínimo el siguiente:

```html
<html>
    <head>
    </head>
    <body>
        <table>
            <tr>
                <td>...</td>
                <td>...</td>
            ....
            </tr>
        ....
        </table>
    </body>
</html>
```

8. Modificar el ejercicio 4 para que además de mostrar las rutas de los ficheros que cumplen el patrón glob, muestre también el tamaño en bytes "humanizado", es decir, que en lugar de mostrar 1048576 bytes, muestre 1MB.

9. Implementa una herramienta similar a `tail` sistemas Linux/Unix que sea capaz de mostrar la parte final de un fichero. Recibirá por la línea de argumentos, como poco, la ruta al fichero, y optativamente el número de líneas a mostrar (si no se proporciona valor, será igual a 5).

> Esta herramienta es muy útil para mostrar, por ejemplo, ficheros de log, donde interesa ver sobre todo _lo último que ha sucedido_.

10. Investiga la clase [`RandomAccessFile`](https://docs.oracle.com/en/java/javase/17/docs//api/java.base/java/io/RandomAccessFile.html) para realizar una versión mejorada del ejercicio anterior en la cual no haya que leer el fichero completo para mostrar las últimas líneas, sino solamente lo necesario. En este caso tendrás que ir leyendo byte a byte, añadiendo los bytes a una cadena, y detectando cuándo encuentras un carácter de salto de línea (`\n`, `\r`), para poder saber cuándo incrementar el contador de líneas.

