# 🚀 Proyecto Final DAM – Plataforma Multiplataforma Integral

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![Java Version](https://img.shields.io/badge/Java-17-blue.svg)](https://www.java.com/)
[![Build Status](https://img.shields.io/github/actions/workflow/status/usuario/Proyecto-DAM/build.yml?branch=main)](https://github.com/usuario/Proyecto-DAM/actions)
[![GitHub Issues](https://img.shields.io/github/issues/usuario/Proyecto-DAM)](https://github.com/usuario/Proyecto-DAM/issues)

---

## 🏫 Introducción

Este repositorio contiene el **proyecto final** del ciclo de grado superior en **Desarrollo de Aplicaciones Multiplataforma (DAM)**.  
El objetivo es desarrollar una **aplicación multiplataforma completa**, aplicando los conocimientos adquiridos en programación, acceso a datos, interfaces gráficas, gestión de sistemas y despliegue.  

El proyecto está diseñado con **arquitectura modular**, **buena separación de capas** y enfoque en **escalabilidad, mantenibilidad y rendimiento**.

---

## 🎯 Objetivos del Proyecto

- ✅ Construir una aplicación multiplataforma funcional y documentada.  
- ✅ Aplicar patrones de diseño y arquitectura limpia (MVC/MVVM).  
- ✅ Integrar una **gestión de base de datos** eficiente y segura.  
- ✅ Implementar **control de versiones** con Git y GitHub.  
- ✅ Aplicar metodologías ágiles (**Scrum/Kanban**) durante el desarrollo.  
- ✅ Documentar todo el proceso y facilitar la comprensión para terceros.  

---

## 🧠 Tecnologías y Herramientas

| Categoría | Herramienta / Tecnología | Descripción |
|------------|--------------------------|-------------|
| Lenguaje | Java 17 / Kotlin / C# / Python | Base del proyecto |
| IDE | IntelliJ IDEA / Android Studio / VS Code | Desarrollo y depuración |
| Framework | JavaFX / Spring Boot / .NET MAUI / Django | UI y backend |
| Base de datos | MySQL / SQLite / Firebase | Persistencia y consultas |
| Control de versiones | Git + GitHub | Gestión colaborativa de código |
| Automatización CI/CD | GitHub Actions | Compilación y pruebas automáticas |
| Contenedores | Docker / Docker Compose | Despliegue aislado y reproducible |
| Documentación | Markdown + Javadoc | Manuales, diagramas y guías |

---

## 🧩 Arquitectura del Proyecto

El sistema sigue una **arquitectura en capas** bien definida:

📦 Proyecto-DAM
┣ 📂 src/
┃ ┣ 📂 main/
┃ ┃ ┣ 📂 java/ # Código fuente: modelo, vista, controlador
┃ ┃ ┣ 📂 resources/ # Configuración, imágenes, estilos
┃ ┃ ┗ 📄 application.yml # Configuración global de la app
┣ 📂 test/ # Pruebas unitarias e integración
┣ 📂 docs/ # Manuales, diagramas UML y documentación técnica
┣ 📂 .github/workflows/ # Automatización CI/CD
┣ 📂 docker/ # Configuración de contenedores
┣ 📄 README.md # Este archivo
┣ 📄 pom.xml / build.gradle # Gestión de dependencias
┗ 📄 .gitignore # Archivos ignorados por Git


---

## ⚙️ Funcionalidades Principales

1. **Autenticación de usuarios**: registro, login y gestión de permisos.  
2. **Gestión de datos CRUD**: crear, leer, actualizar y eliminar registros.  
3. **Interfaz gráfica intuitiva**: responsive y multiplataforma.  
4. **Integración con servicios externos**: APIs REST y almacenamiento en la nube.  
5. **Registro de logs y auditoría**: seguimiento de errores y eventos.  
6. **Configuración dinámica**: parámetros ajustables sin recompilar la app.  
7. **Modularidad y escalabilidad**: código organizado por capas y patrones de diseño.

---

## 🧩 Buenas Prácticas Aplicadas

- Programación orientada a objetos (POO): encapsulación, herencia y polimorfismo.  
- Uso de patrones de diseño: DAO, MVC, Singleton y Observer.  
- Separación de responsabilidades y modularidad.  
- Validación y control de errores centralizado.  
- Documentación técnica con Javadoc y Markdown.  
- Pruebas unitarias y de integración con JUnit y Mockito.  
- Versionado semántico y Git Flow para ramas.

---

## 🖼️ Capturas de Pantalla

| Interfaz Principal | Panel de Gestión de Datos |
|------------------|---------------------------|
| ![Inicio](assets/inicio.png) | ![Gestión](assets/gestion.png) |

> 💡 Añade imágenes de tus módulos clave para que otros puedan entender tu proyecto visualmente.

---

## 📚 Documentación Adicional

- 📄 [Manual de Usuario](docs/manual_usuario.pdf)  
- 🧩 [Diagrama UML de Clases](docs/diagrama_clases.png)  
- ⚙️ [Guía de Instalación](docs/instalacion.md)  
- 📌 [Especificación de Requisitos](docs/requisitos.md)  

---

## 🐳 Despliegue y Entorno

- **Requisitos Previos**: Java 17+, Maven/Gradle, MySQL 8+, Docker opcional.  
- **Instalación y Ejecución**:

```bash
# Clonar el repositorio
git clone https://github.com/usuario/Proyecto-DAM.git

# Entrar al directorio del proyecto
cd Proyecto-DAM

# Compilar y empaquetar
mvn clean package

# Ejecutar la aplicación
java -jar target/proyecto-dam.jar