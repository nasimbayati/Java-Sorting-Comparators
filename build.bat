@echo off
REM ============================================
REM Build script for java-sorting-comparators
REM ============================================

if not exist bin mkdir bin

echo Compiling Java files...
javac -d bin src\App.java src\cli\Args.java src\model\Person.java src\sort\PersonSorters.java
if %ERRORLEVEL% neq 0 (
  echo.
  echo Compilation FAILED.
  pause
  exit /b %ERRORLEVEL%
)

echo.
echo Compilation SUCCESSFUL.
echo.
echo Examples:
echo   java -cp bin src.App demo
echo   java -cp bin src.App from Ann:22:Austin bill:30:Dallas Chris:25:Austin
pause
