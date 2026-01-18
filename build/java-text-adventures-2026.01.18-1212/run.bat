@echo off
setlocal
enableextensions
set APP_HOME=%~dp0
pushd "%APP_HOME%"
"%APP_HOME%runtime\bin\java.exe" -cp ".;otherGames" Index %*
set EXITCODE=%ERRORLEVEL%
popd
exit /b %EXITCODE%
