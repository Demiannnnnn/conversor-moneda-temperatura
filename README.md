# Conversor de Moneda y Temperatura

Aplicación de escritorio interactiva desarrollada en Java para la conversión de divisas y unidades de temperatura, creada en el marco del programa Oracle Next Education (ONE) con Alura Latam.

## Características

- **Conversor de Divisas:**
  - Conversión bidireccional entre Pesos y divisas internacionales: Dólar Estadounidense (USD), Euro (EUR), Libras Esterlinas (GBP), Yen Japonés (JPY) y Won Surcoreano (KRW).
- **Conversor de Temperatura:**
  - Conversión entre escalas Celsius (°C), Fahrenheit (°F) y Kelvin (K).
- **Interfaz Gráfica:**
  - Implementada mediante diálogos interactivos de Java Swing (`JOptionPane`).

## Requisitos

- Java Development Kit (JDK) 17 o superior (configurado originalmente en Java 20).
- Apache Ant (opcional, para construir mediante `build.xml`) o un IDE compatible (Apache NetBeans, Eclipse, IntelliJ IDEA, VS Code).

## Ejecución

### Compilación y ejecución directa con JDK

Desde la raíz del repositorio:

```bash
# Compilar las clases
javac -d out "Proyecto 2 Oracle One/Coversor/src/Conversor/"*.java

# Ejecutar la aplicación
java -cp out Conversor.Main
```

### Ejecución con Apache Ant

Desde el subdirectorio del proyecto:

```bash
cd "Proyecto 2 Oracle One/Coversor"
ant run
```

## Estructura del Proyecto

```
conversor-moneda-temperatura/
├── LICENSE.md
├── README.md
├── .gitignore
├── AGENTS.md
└── Proyecto 2 Oracle One/
    └── Coversor/
        ├── build.xml
        ├── manifest.mf
        ├── nbproject/
        │   ├── build-impl.xml
        │   ├── genfiles.properties
        │   ├── project.properties
        │   └── project.xml
        └── src/
            └── Conversor/
                ├── ConversorMoneda.java
                ├── ConversorTemperatura.java
                └── Main.java
```

## Licencia

Distribuido bajo los términos especificados en [LICENSE.md](LICENSE.md).
