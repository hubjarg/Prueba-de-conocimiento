# README

Este repositorio contiene un archivo de código Java (`ClaroTest.java`) y un archivo de manifiesto (`Manifest.mf`) lo necesario para compilar un binario (`jar`) (`ClaroTest.jar`), al terminar tendra una aplicación
para línea de comando que puede leer un archivo que contenga una clase de java y puede describir los atributos y las firmas de los métodos que contenga la clase pública del archivo de forma dinámica .
## Requisitos

Antes de compilar y ejecutar este proyecto, asegúrate de tener los siguientes requisitos:

- **Java Development Kit (JDK)**: Necesitarás tener instalado el JDK en tu sistema. Recomendamos usar JDK 11.0.16.1 o superior. Puedes descargar el JDK desde [la página oficial de Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o utilizar una distribución OpenJDK.

- **Configuración del PATH**: Asegúrate de que la ruta al directorio binario del JDK esté configurada correctamente en la variable de entorno PATH de tu sistema. Esto permite que el sistema operativo encuentre los ejecutables del JDK (como `javac` y `java`) cuando los ejecutas desde la línea de comandos.

- **Configuración de las variables de entorno JAVA_HOME**: Algunos programas y herramientas pueden requerir que la variable de entorno JAVA_HOME esté configurada correctamente para localizar la instalación del JDK en tu sistema.

## Compilación y Ejecución

Una vez que hayas cumplido con los requisitos anteriores, puedes usar estos comandos para compilar el código Java y crear un archivo JAR ejecutable:

```bash
javac -cp src/ ClaroTest.java
jar cvfm ClaroTest.jar Manifest.mf ClaroTest.class
```
Una vez que hayas compilado el código y creado el archivo JAR, puedes ejecutarlo utilizando el siguiente comando:
```bash
java -jar ClaroTest.jar Person.txt
```
