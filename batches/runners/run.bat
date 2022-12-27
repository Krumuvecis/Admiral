@echo off
cd batches
call getJarName.bat jarName
cd ..
start javaw -jar %jarName%
exit