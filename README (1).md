# 🦁 Ejemplo Mamíferos

Proyecto desarrollado en **Java** como ejercicio de **Técnicas de Programación Orientada a Objetos**, enfocado en el diseño e implementación de una jerarquía de clases para la administración de animales de un zoológico.

El proyecto modela diferentes tipos de mamíferos utilizando **herencia, abstracción, encapsulamiento y polimorfismo**.

---

## 📋 Descripción

El zoológico administra inicialmente cinco tipos de mamíferos:

* 🦁 León
* 🐺 Lobo
* 🐯 Tigre
* 🐆 Guepardo
* 🐕 Perro salvaje africano

Para representar estos animales se diseñó una jerarquía de clases con distintos niveles de abstracción:

```text
                    Mamifero
                  <<abstract>>
                       │
             ┌─────────┴─────────┐
             │                   │
           Felino              Canino
         <<abstract>>         <<abstract>>
             │                   │
      ┌──────┼──────┐       ┌────┴────┐
      │      │      │       │         │
    Leon   Tigre Guepardo  Lobo      Perro
```

---

## 🧩 Estructura de clases

### Mamifero

Clase abstracta que contiene los atributos y comportamientos comunes a todos los mamíferos.

**Atributos:**

* `habitat`
* `altura`
* `largo`
* `peso`
* `nombreCientifico`

**Métodos abstractos:**

* `comer()`
* `dormir()`
* `correr()`
* `comunicarse()`

---

### Felino

Clase abstracta que hereda de `Mamifero` y representa las características comunes de los felinos.

**Atributos adicionales:**

* `tamanoGarras`
* `velocidad`

De esta clase heredan:

* `Leon`
* `Tigre`
* `Guepardo`

---

### Canino

Clase abstracta que hereda de `Mamifero` y representa las características comunes de los caninos.

**Atributos adicionales:**

* `color`
* `tamanoColmillos`

De esta clase heredan:

* `Lobo`
* `Perro`

---

## 🦁 Clases concretas

### Leon

Atributos adicionales:

* `numManada`
* `potenciaRugido`

### Tigre

Atributo adicional:

* `especieTigre`

### Guepardo

No posee atributos adicionales.

### Lobo

Atributos adicionales:

* `numCamada`
* `especieLobo`

### Perro

Atributo adicional:

* `fuerzaMordida`

---

## 🔄 Métodos abstractos

Cada clase concreta implementa los siguientes métodos heredados de `Mamifero`:

```java
public abstract String comer();

public abstract String dormir();

public abstract String correr();

public abstract String comunicarse();
```

Las implementaciones devuelven una descripción relacionada con las características específicas de cada animal.

Por ejemplo:

```java
@Override
public String comer() {
    return "El León caza junto a su grupo de "
            + numManada
            + " individuos en las llanuras africanas.";
}
```

Esto permite que cada animal tenga un comportamiento diferente aunque todos compartan la misma interfaz definida por la clase abstracta `Mamifero`.

---

## 🧠 Conceptos de POO aplicados

El proyecto utiliza los principales conceptos de la Programación Orientada a Objetos:

### Abstracción

Se utilizan las clases abstractas `Mamifero`, `Felino` y `Canino` para representar características comunes sin crear directamente objetos de estas clases.

### Herencia

Las clases concretas heredan las características de sus clases superiores:

```text
Leon → Felino → Mamifero
Tigre → Felino → Mamifero
Guepardo → Felino → Mamifero

Lobo → Canino → Mamifero
Perro → Canino → Mamifero
```

### Encapsulamiento

Los atributos de las clases se mantienen encapsulados y se proporciona acceso mediante métodos `getter`.

### Polimorfismo

Los objetos concretos son asociados al tipo más genérico posible mediante referencias de tipo `Mamifero`.

Ejemplo:

```java
Mamifero leon = new Leon(...);
Mamifero guepardo = new Guepardo(...);
Mamifero lobo = new Lobo(...);
```

Posteriormente pueden almacenarse en un arreglo:

```java
Mamifero[] mamiferos = new Mamifero[6];

mamiferos[0] = leon;
mamiferos[1] = guepardo;
mamiferos[2] = lobo;
```

Y recorrerlos utilizando el tipo genérico:

```java
for (Mamifero animal : mamiferos) {
    System.out.println(animal.comer());
    System.out.println(animal.dormir());
    System.out.println(animal.correr());
    System.out.println(animal.comunicarse());
}
```

---

## 🛠️ Tecnologías

| Tecnología                              | Uso                                 |
| --------------------------------------- | ----------------------------------- |
| ☕ **Java**                              | Lenguaje principal del proyecto     |
| 🧱 **Programación Orientada a Objetos** | Diseño de la jerarquía de clases    |
| 📦 **Maven**                            | Gestión y construcción del proyecto |
| 🖥️ **Consola**                         | Visualización de los resultados     |

### Versión de Java

El proyecto está desarrollado utilizando **Java 17 o superior**.

---

## 📁 Estructura del proyecto

```text
src/
└── main/
    └── java/
        └── ...
            ├── Mamifero.java
            ├── Felino.java
            ├── Canino.java
            ├── Leon.java
            ├── Tigre.java
            ├── Guepardo.java
            ├── Lobo.java
            ├── Perro.java
            └── EjemploMamiferos.java
```

---

## ▶️ Ejecución

La clase principal del proyecto es:

```text
EjemploMamiferos
```

Esta clase crea entre 5 y 7 instancias de las diferentes clases concretas y las almacena utilizando el tipo más genérico posible:

```java
Mamifero[] mamiferos = new Mamifero[6];
```

Posteriormente se recorren las instancias para mostrar sus datos y comportamientos en la consola.

---

## 🎯 Objetivo académico

El objetivo principal del proyecto es aplicar los fundamentos de la **Programación Orientada a Objetos** mediante un caso práctico, utilizando:

* Clases abstractas
* Herencia
* Polimorfismo
* Encapsulamiento
* Constructores
* Métodos `getter`
* Métodos abstractos
* Sobrescritura de métodos (`@Override`)
* Referencias del tipo más genérico posible

---

## 👨‍💻 Autor

**Augusto**

Proyecto académico — Técnicas de Programación Orientada a Objetos.

```
```
