import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class Page(val driver: WebDriver, val url: String = "https://citibikenyc.com") {

  fun go(): Page {
    driver.get(url)
    return this
  }

  fun viewStatusMap(): Map.Page {
    val link = driver.findElement(By.linkText("Station Map"))
    link.click()

    return Map.Page(driver)
  }
}

