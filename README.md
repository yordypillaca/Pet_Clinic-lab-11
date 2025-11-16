# Spring Boot : Application PetClinic

## Features  

### 1.  Unit Test  --> Tag v1.0.0

mvn test -Dspring.profiles.active=h2 


# Comandos Básicos

1. mvn clean
- Elimina la carpeta target/ (limpia el proyecto).

2. mvn compile
- Compila el código fuente (src/main/java).

3. mvn test
- Compila y ejecuta las pruebas unitarias (src/test/java).

4. mvn package
- Compila, prueba y empaqueta el proyecto (JAR, WAR, etc.).

5. mvn install
- Empaqueta y lo instala en el repositorio local de Maven (~/.m2/repository).

6. mvn deploy
- Despliega el artefacto en un repositorio remoto (requiere configuración en pom.xml)


# Ciclo de Vida Común (combinaciones)
1. mvn clean compile → Limpia y compila.
2. mvn clean test → Limpia, compila y ejecuta pruebas.
3. mvn clean package → Limpia, compila, prueba y empaqueta.
4. mvn clean install → Limpia, compila, prueba, empaqueta e instala localmente.
5. mvn clean deploy → Hace todo lo anterior y sube el artefacto a un repositorio remoto

Gracias.