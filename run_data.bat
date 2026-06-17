@echo off
setlocal
set JAVA_HOME=C:\Java\jdk-25
set PATH=%JAVA_HOME%\bin;%PATH%
echo Hoarding-26.1.2 — Running DataGenerator with JDK 25
echo.
call gradlew.bat runData %*
endlocal
