@echo off
call mvn clean package
xcopy target\*.jar .
call mvn clean
pause
exit