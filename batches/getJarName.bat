REM call getJarName.bat [output value]

call versionRead.bat version
set jarName=Admiral-%version%.jar
set %~1=%jarName%

goto :eof