#!/bin/bash

# ============================================
# run-mac.sh - Compila y ejecuta el proyecto Java
# ============================================

# Limpiar archivos .class anteriores
echo "Limpiando archivos compilados anteriores..."
find build/classes -name "*.class" -delete

# Crear directorio de salida si no existe
echo "Creando directorio de compilación..."
mkdir -p build/classes

# Verificar que existe el JAR de MySQL
if [ ! -f "lib/mysql-connector-j-8.0.33.jar" ]; then
    echo "✗ Error: No se encuentra el archivo lib/mysql-connector-j-8.0.33.jar"
    echo "Asegúrate de que el driver MySQL esté en la carpeta lib/"
    exit 1
fi

# Compilar todas las clases 
echo "Compilando el proyecto..."
javac -cp "lib/mysql-connector-j-8.0.33.jar" -d build/classes src/Conexion/*.java src/ventanas/*.java src/Principal/*.java

# Verificar compilación y ejecuta
if [ $? -eq 0 ]; then
    echo "✓ Compilación exitosa. Ejecutando el programa..."
    java -cp "build/classes:lib/mysql-connector-j-8.0.33.jar" Principal.Main
else
    echo "✗ Error en la compilación. Revisa tu código."
    exit 1
fi
