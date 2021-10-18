@echo off
javac Vec3.java
javac Ray.java
javac Main.java
java Main > output\image.ppm
"output\ppmtobmp.exe" output\image.ppm > output\image.bmp
output\image.bmp