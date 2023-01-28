# Admiral

## Abstract

An admiral simulator.

*Very far off from an actual admiral...*

<!--
[![](https://jitpack.io/v/Krumuvecis/<projname>.svg)](https://jitpack.io/#Krumuvecis/<projname>)
-->

by [Krumuvecis](https://github.com/Krumuvecis)


## Requirements

### For running

* JDK: 18 [(download)](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)

### For compiling

* Maven compiler: 18
* [Apache Maven Assembly Plugin](https://maven.apache.org/plugins/maven-assembly-plugin/): 3.4.2

### Dependencies

* [JetBrains Java Annotations](https://mvnrepository.com/artifact/org.jetbrains/annotations): 23.0.0
* [GraphicsEngine](https://github.com/KruMF/GraphicsEngine) : 0.8.15
* [MathUtils](https://github.com/KruMF/MathUtils) : 0.2


## Launch instructions

1. Ensure you have the correct version of Java installed _(see requirements above)_.
2. Get a release of Admiral [here](https://github.com/Krumuvecis/Admiral/releases).
3. Launch desired mode:
   1. Normal mode:
      * _(Windows)_ run `run.bat`.
      * _(other OS)_ run `.jar` argumentless.
   2. Dev mode:
       * _(Windows)_ run `runDev.bat`.
       * _(other OS)_ run `.jar` with argument `dev`.


## Functionality

Currently only simulates pressure-wind relationship.

*Pressure gradient creates wind; wind creates pressure gradient.*


## Notes

UI needs some polishing, but it'll do for now.

*Work is under progress, expect changes.*