@file:DependsOn("junit:junit:4.13")
@file:DependsOn("org.hamcrest:hamcrest:2.2")
@file:DependsOn("org.seleniumhq.selenium:selenium-java:3.141.59")

@file:Import("CitiBike.kts")
@file:Import("Home.kts")
@file:Import("Map.kts")

import org.junit.runner.JUnitCore

val results = JUnitCore.runClasses(CitiBike.UITest::class.java)

println(
  "Ran ${results.getRunCount()} tests " +
  "in ${results.getRunTime() / 1000.0} seconds " +
  "with ${results.getFailureCount()} failures."
)

if (results.getFailureCount() > 0) {
  results.getFailures().forEach {
    println(it.getMessage())
    println(it.getException())
  }
}

