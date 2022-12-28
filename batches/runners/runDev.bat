@echo off
cd batches
call getJarName.bat jarName
cd ..
set devArgument=dev
start javaw -jar %jarName% %devArgument%
exit