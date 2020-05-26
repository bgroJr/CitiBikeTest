# :statue_of_liberty: :bike: CitiBike UI Test Examples

Example UI tests for the [Citi Bike](https://www.citibikenyc.com) web application. 

Automated UI tests are written in [Kotlin](https://kotlinlang.org) (script), with
[Selenium](https://www.selenium.dev) for browser interaction. 

## Purpose

Proof of concept for using the
[scripting capabilities](https://kotlinlang.org/docs/tutorials/command-line.html#using-the-command-line-to-run-scripts)
of Kotlin to write test scripts (.kts files). Attempting a lighter weight, more agile
approach to an area of the technical stack where [Java](https://www.oracle.com/java)
is the most commonly used language :stuck_out_tongue_closed_eyes:

## Setup

```
# on Mac OS, use Homebrew to install Kotlin
$ brew install kotlin
```

## Run

```
$ kotlinc -script TestRunner.main.kts
```

## Tests

The tests are defined in **CitiBike.kts**. The tests interact with the Citi Bike web application.

Each relevant page of the web application is represented by a class which implements methods of
interacting with and retrieving information from the page. These classes are an instance of 
the [Page Object Model](https://martinfowler.com/bliki/PageObject.html) design pattern. 

**TestRunner.main.kts** contains a minimal test runner using
[JUnitCore](https://junit.org/junit4/javadoc/latest/org/junit/runner/JUnitCore.html). 

## .main.kts

By giving a Kotlin file the extension ".main.kts", when you run the file, the special extension will
trigger Kotlin's experimental scripting functionality. The experimental functionality includes the 
special annotation "@file:DependsOn" to specify external dependencies, and "@file:Import" to specify
internal dependencies.

Specifying the dependencies at the top of the script saves some work that would otherwise be done
with a project build tool and its many associated scripts / configurations. Looking at you, 
[Gradle](https://gradle.org) :elephant: :roll_eyes:

