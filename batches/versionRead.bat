REM call versionRead.bat [output value]

set versionFile=version.ini
set /p version=< %versionFile%
set %~1=%version%

goto :eof