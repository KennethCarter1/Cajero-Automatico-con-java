@echo off
REM ============================================
REM run.bat - Compila y ejecuta el proyecto Java
REM ============================================

REM Limpiar archivos .class anteriores
echo Limpiando archivos compilados anteriores...
if exist build\classes (
    del /s /q build\classes\*.class
)

REM Crear directorio de salida si no existe
if not exist build\classes (
    mkdir build\classes
)

REM Verificar que existe el JAR de MySQL
if not exist lib\mysql-connector-j-8.0.33.jar (
    echo ✗ Error: No se encuentra el archivo lib\mysql-connector-j-8.0.33.jar
    echo Asegurate de que el driver MySQL este en la carpeta lib\
    pause
    exit /b 1
)

REM Compilar todas las clases desde src\
echo Compilando el proyecto...
javac -cp "lib\mysql-connector-j-8.0.33.jar" -d build\classes src\Conexion\*.java src\ventanas\*.java src\Principal\*.java

IF %ERRORLEVEL% NEQ 0 (
    echo ✗ Error en la compilacion. Revisa tu codigo.
    pause
    exit /b 1
)

REM Ejecutar el programa
echo ✓ Compilacion exitosa. Ejecutando el programa...
java -cp "build\classes;lib\mysql-connector-j-8.0.33.jar" Principal.Main

pause
