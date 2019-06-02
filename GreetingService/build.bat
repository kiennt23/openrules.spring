set INPUT_FILE_NAME=rules/DecisionModel.xls
set GOAL="Hello Statement"
set OUTPUT_FILE_NAME=rules/Goals.xls
cd %~dp0
call ..\openrules.config\projectBuild
pause