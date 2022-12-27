@echo off
title Test - versionRead
cd ..
call versionRead.bat version
echo version: %version%
echo.
pause
exit