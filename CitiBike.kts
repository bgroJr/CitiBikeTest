import org.junit.Test
import org.junit.Before
import org.junit.After
import org.junit.Assert
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import org.hamcrest.Matchers.*
import org.hamcrest.MatcherAssert

import org.openqa.selenium.chrome.ChromeDriver


@RunWith(JUnit4::class)
class UITest {

  lateinit var home: Home.Page

  @Before
  fun setUp() {
    home = Home.Page(ChromeDriver())
  }

  @Test
  fun `Station Map should show the number of available bikes`() {
    val exampleStation = "Broadway & E 14 St"

    val map = home.go().viewStationMap()

    val station = map.searchForStation(exampleStation)
                     .getStationInformation()

    Assert.assertEquals(station.name, exampleStation)
    MatcherAssert.assertThat(station.bikes, greaterThanOrEqualTo(0))
    MatcherAssert.assertThat(station.slots, greaterThanOrEqualTo(0))
  }

  @After
  fun tearDown() {
    home.driver.quit()
  }
}

