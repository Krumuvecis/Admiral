@echo off
title Release preparator
xcopy runners\* ..
cd ..
call mvn clean package
xcopy target\*.jar .
call mvn clean
pause
exit