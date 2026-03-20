# 👔 Sistema de Planilla Integral - ROPA INDUSTRIAL SA

Este proyecto es una solución de software desarrollada en **Java** para la gestión y cálculo de planillas de la empresa textil "ROPA INDUSTRIAL SA". El sistema automatiza el cálculo de sueldos, beneficios sociales y descuentos de ley correspondientes al periodo de **diciembre 2025**, aplicando normativas laborales reales del Perú.

## 🛠️ Tecnologías y Arquitectura
El proyecto ha sido diseñado bajo una **Arquitectura Limpia en Capas**, garantizando un código mantenible y escalable:

* **Lenguaje:** Java 
* **Entorno:** NetBeans IDE / Maven
* **Capas del Proyecto:**
    * `Interface`: Definición de contratos y servicios.
    * `Entity`: Modelado de las entidades de negocio.
    * `Model`: Lógica de negocio y persistencia.
    * `Controller`: Gestión de la comunicación entre la vista y el modelo.
    * `Vistas (JSP)`: Interfaz web dinámica para la interacción del usuario.

## 🧠 Implementación de Pilares POO
El sistema demuestra el dominio de los 4 pilares fundamentales de la Programación Orientada a Objetos:

1.  **Abstracción:** Representación clara de las entidades del mundo real en clases Java.
2.  **Herencia:** Implementación de una **Superclase** de la cual heredan todos los atributos de instancia y clase, optimizando la reutilización de código.
3.  **Encapsulamiento:** Protección de datos sensibles, aplicando correctamente modificadores de acceso, especialmente en el atributo `asignacionFamiliar`.
4.  **Polimorfismo:** Cálculos dinámicos de comisiones y beneficios que varían según el rol del trabajador (Vendedor u Obrero).

## 📋 Reglas de Negocio Implementadas
El software realiza los siguientes cálculos automáticos basados en la normativa vigente:

* **Comisiones por Rol:** 10% para Vendedores y 8% para Obreros sobre el sueldo bruto.
* **Adelantos de Quincena:** Descuento automático del 50% del sueldo.
* **Gratificaciones:** Cálculo conforme a ley para el cierre de año (Diciembre).
* **Seguridad Social y Pensiones diferenciadas:**
    * **Empleados:** Gestión de AFP y EPS.
    * **Obreros:** Gestión de ONP y ESSALUD.
* **Asignación Familiar:** Cálculo dinámico basado en la selección del usuario en la interfaz.

## 💻 Funcionalidades de la Vista (JSP)
La interfaz web permite una gestión intuitiva mediante:
* Selección de cargo del trabajador a través de componentes `select`.
* Gestión opcional de asignación familiar mediante `checkbox` o `select`.
* Generación de una **Boleta de Pago** completa que muestra todos los ingresos, aportes y el **Neto a Recibir**.

---
© 2026 ISIL - Facultad de Tecnología
