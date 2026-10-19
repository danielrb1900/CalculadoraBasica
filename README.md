# 🧮 Calculadora Básica en Java

[![Java Version](https://img.shields.io/badge/Java-25-blue.svg)](https://www.oracle.com/java/)
[![GUI: Java Swing](https://img.shields.io/badge/GUI-Java%20Swing%20%2F%20AWT-orange.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![IDE: VS Code](https://img.shields.io/badge/IDE-VS%20Code-007ACC.svg)](https://code.visualstudio.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Aplicación de escritorio de una **Calculadora Básica** con interfaz gráfica de usuario (GUI) desarrollada íntegramente en **Java**[cite: 2]. El proyecto aplica una arquitectura modular orientada a objetos que desacopla la lógica aritmética (`clases`), la gestión de errores personalizados (`excepciones`) y los controladores de eventos de la interfaz (`interfaz`)[cite: 2].

---

## ✨ Características Principales (Features)

* **Operaciones Aritméticas Fundamentales:** Soporte completo para suma (`BotonSumarListener`), resta (`BotonRestarListener`), multiplicación (`BotonMultiplicarListener`) y división (`BotonDividirListener`) coordinados mediante una jerarquía de eventos (`BotonOperacionesListener`)[cite: 2].
* **Soporte de Punto Flotante:** Capacidad para ingresar y operar con números decimales mediante control y validación de separador decimal (`BotonPuntoListener`)[cite: 2].
* **Manejo de Excepciones Personalizado:** Implementación de la excepción propia `DividirEntreCeroException` para interceptar y gestionar de forma segura los intentos de división por cero sin interrumpir la ejecución del programa[cite: 2].
* **Controles de Edición y Pantalla:**
  * **Borrado parcial:** Eliminación del último carácter o dígito ingresado (`BotonBorrarListener`)[cite: 2].
  * **Reinicio total (Clear):** Limpieza completa de la pantalla (`Pantalla`) y restablecimiento del estado interno de la calculadora (`BotonLimpiarListener`)[cite: 2].
  * **Resolución directa:** Cálculo inmediato del resultado mediante el controlador `BotonIgualListener`[cite: 2].
* **Arquitectura Desacoplada:** Separación estricta entre el motor de cálculo (`Calculadora.java`), el modelo de visualización (`Pantalla.java`) y la ventana gráfica principal (`VentanaCalculadora.java`)[cite: 2].

---

## 🛠️ Tecnologías Utilizadas

| Categoría | Tecnología / Componente | Propósito en el Proyecto |
| :--- | :--- | :--- |
| **Lenguaje** | Java (JDK) | Lógica de negocio, POO y estructura de paquetes (`clases`, `excepciones`, `interfaz`, `main`)[cite: 2]. |
| **Interfaz Gráfica** | Java Swing / AWT | Renderizado de componentes visuales en `VentanaCalculadora` y captura de eventos (`ActionListener`)[cite: 2]. |
| **Entorno (IDE)** | Visual Studio Code | Configuración de espacio de trabajo mediante `.vscode/settings.json`[cite: 2]. |
| **Control de Versiones** | Git | Gestión de código fuente e historial del repositorio local[cite: 2]. |

---

## ⚙️ Requisitos Previos

Para compilar y ejecutar esta aplicación en tu entorno local, asegúrate de contar con:

* **Java Development Kit (JDK):** Versión 11 o superior (compatible con Java 25).
* **Visual Studio Code** con la extensión *Extension Pack for Java* (o cualquier IDE compatible con proyectos estándar de Java)[cite: 2].
* **Git** (opcional, para clonar el repositorio)[cite: 2].

Verifica tu instalación de Java ejecutando en la terminal:
```bash
java -version
```

---

## 🚀 Instalación y Ejecución

### Opción 1: Ejecución desde Visual Studio Code (Recomendado)
1. Abre la carpeta raíz `Calculadora - V1` en **Visual Studio Code**[cite: 2].
2. En el explorador de archivos, navega hasta `src/main/Main.java`[cite: 2].
3. Haz clic en **Run** (`▶️`) sobre el método `main` o presiona `F5`.

### Opción 2: Compilación y ejecución desde la Terminal (CLI)
Sitúate en el directorio raíz del proyecto (`Calculadora - V1`) y ejecuta los siguientes comandos[cite: 2]:

1. **Compilar el código fuente hacia la carpeta `bin/`:**
   ```bash
   javac -d bin src/clases/*.java src/excepciones/*.java src/interfaz/*.java src/interfaz/botonesOperadores/*.java src/main/*.java
   ```
2. **Ejecutar la aplicación:**
   ```bash
   java -cp bin main.Main
   ```

---

## 📂 Estructura del Proyecto

```text
📁 Calculadora - V1
├── 📁 .vscode/
│   └── 📄 settings.json                           # Configuración del proyecto para VS Code
├── 📁 src/                                        # Código fuente (.java)
│   ├── 📁 clases/                                 # Lógica de dominio y estado
│   │   ├── 📄 Calculadora.java                    # Motor matemático y evaluación de operaciones
│   │   └── 📄 Pantalla.java                       # Gestión del texto y valores mostrados en el visor
│   ├── 📁 excepciones/                            # Gestión de errores
│   │   └── 📄 DividirEntreCeroException.java      # Excepción personalizada para divisiones entre 0
│   ├── 📁 interfaz/                               # Vista (GUI) y controladores generales
│   │   ├── 📄 VentanaCalculadora.java             # Ventana principal y disposición de botones
│   │   ├── 📄 BotonNumeroListener.java            # Eventos para los botones numéricos (0-9)
│   │   ├── 📄 BotonPuntoListener.java             # Evento para inserción y validación de decimales
│   │   ├── 📄 BotonIgualListener.java             # Evento para ejecutar el cálculo final
│   │   ├── 📄 BotonBorrarListener.java            # Evento para retroceso/borrado de dígitos
│   │   ├── 📄 BotonLimpiarListener.java           # Evento para reinicio completo de la calculadora
│   │   └── 📁 botonesOperadores/                  # Controladores específicos de operadores
│   │       ├── 📄 BotonOperacionesListener.java   # Clase base/gestor de eventos de operación
│   │       ├── 📄 BotonSumarListener.java         # Operador de adición (+)
│   │       ├── 📄 BotonRestarListener.java        # Operador de sustracción (-)
│   │       ├── 📄 BotonMultiplicarListener.java   # Operador de producto (×)
│   │       └── 📄 BotonDividirListener.java       # Operador de cociente (÷)
│   └── 📁 main/                                   # Punto de entrada
│       └── 📄 Main.java                           # Inicialización de la aplicación
└── 📁 bin/                                        # Archivos bytecode compilados (.class)
```

---

## 💻 Ejemplos de Uso

Una vez iniciada la ventana `VentanaCalculadora`[cite: 2]:

1. **Operación con decimales:**
   * Haz clic en `1` → `2` → `.` (`BotonPuntoListener`) → `5`[cite: 2].
   * Selecciona el operador `+` (`BotonSumarListener`)[cite: 2].
   * Haz clic en `7` → `.` → `5` y presiona `=` (`BotonIgualListener`)[cite: 2].
   * **Resultado en `Pantalla`:** `20.0` (o `20`)[cite: 2].
2. **Corrección de entrada:**
   * Si ingresas `458` por error queriendo escribir `459`, pulsa el botón de borrar (`BotonBorrarListener`) para eliminar el `8` y luego presiona `9`[cite: 2].
3. **Validación de división entre cero:**
   * Ingresa cualquier número (ej. `9`), pulsa `÷` (`BotonDividirListener`), ingresa `0` y presiona `=`[cite: 2].
   * El sistema capturará la excepción `DividirEntreCeroException` mostrando la alerta o mensaje de error correspondiente sin cerrar la ventana[cite: 2].

---

## 🗺️ Posibles Mejoras (Roadmap)

- [ ] **Soporte de Teclado (`KeyListener`):** Permitir al usuario ingresar números, operadores y ejecutar cálculos directamente desde el teclado numérico físico.
- [ ] **Historial de Operaciones:** Añadir un panel lateral en `VentanaCalculadora` que registre las operaciones realizadas durante la sesión actual[cite: 2].
- [ ] **Funciones Científicas Básicas:** Incorporar botones adicionales para cálculo de porcentajes (`%`), raíces cuadradas (`√`), potencias (`x²`) e inversión de signo (`+/-`).