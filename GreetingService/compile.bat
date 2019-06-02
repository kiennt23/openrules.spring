@echo off
cd %~dp0
set CLASS_NAME=com.openrules.Main
set FILE_NAME=rules/Goals.xls
set DECISION_NAME="DecisionHelloStatement"
call ant -f "%~dp0\build.xml" compile
pause