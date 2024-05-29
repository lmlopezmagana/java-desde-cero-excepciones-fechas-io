# Sección 2 - Manejo de fechas

## Ejercicios resueltos en vídeo

1. Necesitamos un programa que nos ayude a calcular los descuentos para los clientes en las fechas cercanas a su cumpleaños. Las reglas de descuento son las siguientes:

- En la semana de su cumpleaños y hasta el viernes de la siguiente semana, 20% de descuento
- Si cumple una edad redonda (termina en 5 o 0), un 5% adicional en la semana de su cumpleaños.

Implementa un método que nos dé el descuento para hoy.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/02.8_Ejercicio01/)

2. Amplia el ejercicio anterior, añadiendo otro método que nos indique los períodos de descuento para el año actual.

Puedes encontrar el código fuente completo de este ejercicio resuelto en vídeo [aquí](../../Ejemplos/02.9_Ejercicio02/)

## Otros ejercicios resueltos

3. Para un mes determinado del año actual, listar todos los lunes del mes.

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S02E03/)

4. Lista los nombres de los días de la semana en español.

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S02E04/)

5. Tengo un amigo que es muy supersticioso, y quiere que le ayude a hacer un programa que diga si una determinada fecha _cae_ en martes y 13. De paso, me pide que añada un método para que devuelva la fecha del próximo martes y 13, para estar muy pendiente de no salir de casa.

> En las culturas de Grecia y algunos de los países de cultura hispana, como España, Cuba, Uruguay, Paraguay, República Dominicana, Argentina, Chile, Perú, Venezuela, Colombia, Ecuador y otros, se considera martes 13 un día de mala suerte. Puedes leer más en [wikipedia](https://es.wikipedia.org/wiki/Martes_13).

Puedes encontrar el código fuente completo de este ejercicio resuelto [aquí](./S02E05/)

## Ejercicios propuestos

6. Implementa un programa en Java que muestre toda la información posible sobre la fecha de tu cumpleaños.

7. En muchos países anglosajones existen los _bank holidays_, que son fiestas que hace años disfrutaban los empleados de la banca y que actualmente se han extendido como festivos nacionales. Los días festivos varían entre diferentes países, así que para este ejercicio nos centraremos en la República de Irlanda. Cada año, los _bank holidays_ de este país son:

- 1 de enero, Año nuevo
- 17 de marzo, día de San Patricio
- El lunes después de Pascua (día siguiente al domingo de Resurrección)
- Primer lunes de mayo
- Primer lunes de junio
- Primer lunes de agosto
- Último lunes de octubre
- 25 de Diciembre
- 26 de Diciembre, Boxing Day.
 
Implementa un `TemporalAdjuster` que devuelva la fecha del siguiente _bank holiday_. Para calcular la fecha del domingo de Pascua, puedes usar el [algoritmo de Meeus/Jones/Butcher](https://es.frwiki.wiki/wiki/Calcul_de_la_date_de_P%C3%A2ques_selon_la_m%C3%A9thode_de_Meeus). Aquí te dejo una implementación de este algoritmo como un `TemporalAdjuster`:

```java
public class DomingoDePascuaAdjuster implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        int year = LocalDate.from(temporal).getYear();
        return calcularDomingoDePascua(year);
    }

    public static LocalDate calcularDomingoDePascua(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;

        return LocalDate.of(year, month, day);
    }
}
```

8. Plantea una nueva la solución del ejercicio 5 creando:

- Un `TemporalQuery` que nos diga si una fecha es menor o igual a martes y 13
- Un `TemporalAdjuster` que nos devuelva el siguiente martes y 13.

9. Implementa un programa en Java que sea capaz de calcular el [cuadro de amortización francés](https://es.wikipedia.org/wiki/Pr%C3%A9stamo_franc%C3%A9s) para un préstamo. Los datos de entrada deben ser:

- Capital a prestar
- Interés anual
- Fecha de inicio del préstamo.
- Plazo en meses

Debemos suponer que, al estilo de las hipotecas, el pago se va a realizar mensualmente.

Como salida se debe mostrar una tabla que incluya

- El nº de cuota que se paga
- La cantidad de cuota que se paga
- De la cuota, cuanto dinero corresponde a interés (según el sistema francés debe ir decrementando)
- De la cuota, cuanto dinero corresponde a amortización de capital (según el sistema francés, debe ir aumentando)
- El saldo pendiente
- La fecha de pago de la cuota (supón que se paga el primer lunes de cada mes)
