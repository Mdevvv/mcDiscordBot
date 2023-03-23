del /Q .\target\
mkdir target
type nul > target/.gitkeep
mvn package
pause