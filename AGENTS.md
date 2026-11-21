# AGENTS.md — Contexto y Guía para Agentes

## Propósito del Proyecto
Conversor interactivo de escritorio para divisas (Pesos a USD, EUR, GBP, JPY, KRW y viceversa) y temperaturas (Celsius, Fahrenheit, Kelvin) desarrollado en Java Swing en el marco de Oracle Next Education (ONE) con Alura Latam.

## Stack Tecnológico
- **Lenguaje:** Java (JDK 17 o superior, configurado para Java 20).
- **Interfaz:** Java Swing (`javax.swing.JOptionPane`).
- **Sistema de compilación:** Apache Ant (`build.xml`) con estructura de proyecto Apache NetBeans.

## Estructura del Repositorio
```
conversor-moneda-temperatura/
├── .gitignore
├── AGENTS.md
├── LICENSE.md
├── README.md
└── Proyecto 2 Oracle One/
    └── Coversor/
        ├── build.xml               # Script de construcción Ant
        ├── manifest.mf             # Manifiesto JAR
        ├── nbproject/              # Configuración compartida de NetBeans
        └── src/
            └── Conversor/          # Paquete principal
                ├── ConversorMoneda.java
                ├── ConversorTemperatura.java
                └── Main.java       # Punto de entrada de la aplicación
```

## Comandos de Compilación, Ejecución y Verificación

> Nota: Requiere JDK instalado en el entorno (`javac` y `java`).

### Compilación manual con `javac`
Desde la raíz del repositorio:
```bash
javac -d out "Proyecto 2 Oracle One/Coversor/src/Conversor/"*.java
```

### Ejecución
```bash
java -cp out Conversor.Main
```

### Compilación y ejecución con Apache Ant
Desde `Proyecto 2 Oracle One/Coversor`:
```bash
ant compile
ant run
```

### Test y Lint
- El proyecto no incluye tests unitarios automatizados (JUnit) ni linter externo configurado.
- Para validación estática con el compilador de Java:
```bash
javac -Xlint:all -d out "Proyecto 2 Oracle One/Coversor/src/Conversor/"*.java
```

## Convenciones de Código
- **Estilo:** Java estándar, clases en `PascalCase`, métodos y variables en `camelCase`.
- **UI:** Interfaz basada en modales `JOptionPane` para entrada de usuario y presentación de resultados.
- **Separación de responsabilidades:** Mantener la lógica de cálculo en clases dedicadas (`ConversorMoneda`, `ConversorTemperatura`) y el flujo de navegación en `Main.java`.
- **Sin dependencias pesadas:** No agregar librerías externas innecesarias; mantener el proyecto autosuficiente sobre la biblioteca estándar de Java.

## Reglas de Seguridad
- **Secretos:** Cualquier configuración sensible o token externo debe ser consumido exclusivamente vía variables de entorno (`System.getenv("VAR_NAME")`).
- **Archivos `.env`:** Nunca versionar archivos `.env` ni claves privadas (`*.pem`, `*.key`, `credentials*.json`).
- Si se agregan nuevas variables de entorno requeridas, documentarlas en `.env.example` con placeholders explícitos (`CHANGE_ME`).

## Flujo de Trabajo Git
- **Ramas de trabajo:** Crear ramas con prefijo `dev/*` (ej. `dev/cleanup-2026-11`).
- **Destino de integración:** Todo PR o merge se integra hacia `develop-AGENTS`.
- **Ramas protegidas:** NUNCA hacer commit o push directo a `main` ni a `develop`.
- **Commits:** Seguir Conventional Commits en inglés (`chore:`, `fix:`, `docs:`, `refactor:`, `test:`).
