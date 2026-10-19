# 🧮 Calculadora Básica en Java

[![Java Version](https://img.shields.io/badge/Java-25-blue.svg)](https://www.oracle.com/java/)
[![GUI: Java Swing](https://img.shields.io/badge/GUI-Java%20Swing%20%2F%20AWT-orange.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![IDE: VS Code](https://img.shields.io/badge/IDE-VS%20Code-007ACC.svg)](https://code.visualstudio.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Aplicación de escritorio de una **Calculadora Básica** con interfaz gráfica de usuario (GUI) desarrollada íntegramente en **Java**. El proyecto aplica una arquitectura modular orientada a objetos que desacopla la lógica aritmética (`clases`), la gestión de errores personalizados (`excepciones`) y los controladores de eventos de la interfaz (`interfaz`).

---

## ✨ Características Principales (Features)

* **Operaciones Aritméticas Fundamentales:** Soporte completo para suma (`BotonSumarListener`), resta (`BotonRestarListener`), multiplicación (`BotonMultiplicarListener`) y división (`BotonDividirListener`) coordinados mediante una jerarquía de eventos (`BotonOperacionesListener`).
* **Soporte de Punto Flotante:** Capacidad para ingresar y operar con números decimales mediante control y validación de separador decimal (`BotonPuntoListener`).
* **Manejo de Excepciones Personalizado:** Implementación de la excepción propia `DividirEntreCeroException` para interceptar y gestionar de forma segura los intentos de división por cero sin interrumpir la ejecución del programa.
* **Controles de Edición y Pantalla:**
  * **Borrado parcial:** Eliminación del último carácter o dígito ingresado (`BotonBorrarListener`).
  * **Reinicio total (Clear):** Limpieza completa de la pantalla (`Pantalla`) y restablecimiento del estado interno de la calculadora (`BotonLimpiarListener`).
  * **Resolución directa:** Cálculo inmediato del resultado mediante el controlador `BotonIgualListener`.
* **Arquitectura Desacoplada:** Separación estricta entre el motor de cálculo (`Calculadora.java`), el modelo de visualización (`Pantalla.java`) y la ventana gráfica principal (`VentanaCalculadora.java`).

---

## 🛠️ Tecnologías Utilizadas

| Categoría | Tecnología / Componente | Propósito en el Proyecto |
| :--- | :--- | :--- |
| **Lenguaje** | Java (JDK) | Lógica de negocio, POO y estructura de paquetes (`clases`, `excepciones`, `interfaz`, `main`). |
| **Interfaz Gráfica** | Java Swing / AWT | Renderizado de componentes visuales en `VentanaCalculadora` y captura de eventos (`ActionListener`). |
| **Entorno (IDE)** | Visual Studio Code | Configuración de espacio de trabajo mediante `.vscode/settings.json`. |
| **Control de Versiones** | Git | Gestión de código fuente e historial del repositorio local. |

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

Una vez iniciada la ventana `VentanaCalculadora`:

1. **Operación con decimales:**
   * Haz clic en `1` → `2` → `.` (`BotonPuntoListener`) → `5`.
   * Selecciona el operador `+` (`BotonSumarListener`).
   * Haz clic en `7` → `.` → `5` y presiona `=` (`BotonIgualListener`).
   * **Resultado en `Pantalla`:** `20.0` (o `20`).
2. **Corrección de entrada:**
   * Si ingresas `458` por error queriendo escribir `459`, pulsa el botón de borrar (`BotonBorrarListener`) para eliminar el `8` y luego presiona `9`.
3. **Validación de división entre cero:**
   * Ingresa cualquier número (ej. `9`), pulsa `÷` (`BotonDividirListener`), ingresa `0` y presiona `=`.
   * El sistema capturará la excepción `DividirEntreCeroException` mostrando la alerta o mensaje de error correspondiente sin cerrar la ventana.

---