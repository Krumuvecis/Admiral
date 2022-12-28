@echo off
title Test - getJarName
cd ..
call getJarName.bat jarName
echo jarName: %jarName%
echo.
pause
exit