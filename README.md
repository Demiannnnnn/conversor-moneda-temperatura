# Proyecto-Alura-2

[![CI](https://github.com/Demiannnnnn/conversor-moneda-temperatura/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/Demiannnnnn/conversor-moneda-temperatura/actions/workflows/ci.yml)

Conversor de moneda y temperatura de escritorio (proyecto 2 de Oracle ONE / Alura) con ventanas `JOptionPane`.

- Moneda: peso a/desde dólar, euro, libra, yen y won coreano.
- Temperatura: Celsius, Fahrenheit y Kelvin.
- Los valores aceptan decimales con punto o coma (`10.5` o `10,5`).

## Stack

- Java 21 y Swing (`JOptionPane`)
- Maven (`pom.xml`) y proyecto NetBeans/Ant (`build.xml`, `nbproject/`)
- JUnit 5

El código está en `Proyecto 2 Oracle One/Coversor`.

## Cómo correrlo

Requiere JDK 21 y Maven:

```bash
cd "Proyecto 2 Oracle One/Coversor"
mvn package
java -jar target/conversor-1.0.jar
```

También se puede abrir la carpeta `Coversor` como proyecto de NetBeans y ejecutar `Conversor.Main`.

## Tests

```bash
cd "Proyecto 2 Oracle One/Coversor"
mvn verify
```

El workflow `.github/workflows/ci.yml` ejecuta `mvn -B -ntp verify` en cada push y pull request.
