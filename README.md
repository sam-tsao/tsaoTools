# TSAO Tools

- a personal library of functions and utilities I use often 
for [OpenRNDR](https://openrndr.org) programs
  
## Usage
Download this repository then publish it to your local Maven repository.

   ```bash
   cd tsaoTools
   ./gradlew publishToMavenLocal
   ```
Inside your OpenRNDR program, add `mavenLocal()` to your repositories
inside `build.gradle.kts` and add the following line to your dependencies.
``` kt
dependencies("com.github.chosamuel:tsaoTools:+")
```