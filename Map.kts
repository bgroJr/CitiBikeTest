import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions


class Page(val driver: WebDriver) {

  fun searchForStation(stationName: String): Page {
    val search = WebDriverWait(driver, 60).until(
      ExpectedConditions.presenceOfElementLocated(
        By.name("bike-search")
      )
    )
    search.sendKeys(stationName)

    return this
  }

  fun getStationInformation(): Station {
    val name = WebDriverWait(driver, 120).until(
      ExpectedConditions.presenceOfElementLocated(
        By.cssSelector(".mapboxgl-popup-content h1")
      )
    )

    val bikes = driver.findElement(
      By.cssSelector(".ed-map__canvas__info-window__content__detail__info:nth-child(1)")
    )

    val slots = driver.findElement(
      By.cssSelector(".ed-map__canvas__info-window__content__detail__info:nth-child(2)")
    )

    return Station(
      name.getText(),
      bikes.getText().split("\n").first().toInt(),
      bikes.getText().split("\n").first().toInt()
    )
  }
}

data class Station(val name: String, val bikes: Int, val slots: Int)

