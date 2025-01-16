package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    static TouchAction touchAction = new TouchAction(Driver.getAndroidDriver());

    public static void kordianataTiklamaMethodu(int xKoordinati, int yKoordinati, int tiklamaSayisi, int beklemeSuresi) throws InterruptedException {

        for (int i = 0; i < tiklamaSayisi; i++) {
            Thread.sleep(beklemeSuresi);
            touchAction.press(PointOption.point(xKoordinati, yKoordinati))
                    .release()
                    .perform();

        }
        /*
        Bu methodu statik olmadan sadece puplic void olarak isaretleseydim digerClasslardan kullanabilmem icin
        o classta ClassAdi ile obje olusturmam gerekecekti. Ancak Statik olarak yaptigim icin ClassAdini yazdigimda
        statik olarak belirtilen methodlara dogrudan ulasabiliyorum.
        */

    }

    public static void screenScrollMethod(int pressXkordinati, int pressYkordinati, int fingerwaitingTime, int moveXkordinati, int moveYkordinati, int kaydirmaSayisi, int bekleme) throws InterruptedException {
        /* Uygulamada bir erkan boyutu kadar ekrani asagiya kaydirma islevi gorur.
        ekrana parmagini koy alttan yukari kaydir ve birak. sayfa bir akran kadar asagiya indi.
        Bu methodu kullanirken deneme yanilma yolu ile uzerinde calisilan driverin ekranini kontrol ederek calisma
        stabil hale getirilir. */

        for (int i = 0; i < kaydirmaSayisi; i++) {
            Thread.sleep(1500);
            touchAction.press(PointOption.point(pressXkordinati, pressXkordinati))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(fingerwaitingTime)))
                    .moveTo(PointOption.point(moveXkordinati, moveYkordinati))
                    .release()
                    .perform();
            Thread.sleep(bekleme);
        }
    }

    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver) Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
        /*
        ===> Android cihazlar üzerinde UI Automator Viewer API'lerini kullanarak mobil uygulamalarda belirli bir elementi bulmanıza
        olanak sağlar. oogle tarafından geliştirilmiştir ve Android cihazlardaki kullanıcı arayüzünü test etmek için kullanılan
        bir framework'tür. Appium, Selenium'un prensipleri üzerine inşa edilmiştir .

        ===> MobileElement element = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Login\")");
        Bu örnek, "Login" metni olan bir butonu bulur.

        ===> Dinamik listeler, kaydırılabilir (scrollable) alanlar ve belirli özelliklere sahip elementler için arama yapabilirsiniz.
        Örneğin, belirli bir text'in görünene kadar kaydırılmasını sağlayabilirsiniz. biz de yukaridaki method ile bunu yaptik.

        ===> XPath gibi diğer yöntemler karmaşık hiyerarşilerde performans sorunlarına yol açabilirken, findElementByAndroidUIAutomator
        yöntemi daha optimize ve doğrudan bir yol sunar. */


    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void ekranKaydirmaMethodu(int xbaslangic,int ybaslangic,int beklemeSuresi,int xbitis,int ybitis ){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.
                press(PointOption.point(xbaslangic,ybaslangic))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(beklemeSuresi)))
                .moveTo(PointOption.point(xbitis,ybitis))
                .release()
                .perform();
    }


}
