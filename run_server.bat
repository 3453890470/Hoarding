@echo off
setlocal
set JAVA_HOME=C:\Java\jdk-25
set PATH=%JAVA_HOME%\bin;%PATH%
echo Hoarding-26.1.2 — Starting Minecraft Server with JDK 25
echo.
call gradlew.bat runServer %*
endlocal
