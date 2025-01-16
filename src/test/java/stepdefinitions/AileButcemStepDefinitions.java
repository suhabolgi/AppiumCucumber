package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.AileButcemPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AileButcemStepDefinitions {

    AileButcemPage page = new AileButcemPage();

    @Given("Kullanici driver kurulumlarini yaparak cihaz baglantisini kurar")
    public void kullanici_driver_kurulumlarini_yaparak_cihaz_baglantisini_kurar() {
        Driver.getAndroidDriver(); // .getAndroidDriver();'undaki capability tanimlarindan appPackage ile appActivity degerleri degisti.
    }

    @Given("ilk ekran ayarlarini yapin ve {string} ardindan login sayfasina ulasin")
    public void ilk_ekran_ayarlarini_yapin_ve_ardindan_login_sayfasina_ulasin(String girisButonu) throws InterruptedException {
        page.loginMethodu(girisButonu);
    }

    @Given("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string}")
    public void ve_bilgilerini_girerek_kullanici_bilgileriyle(String mail, String password, String girisYap) {
        page.eMailBox.sendKeys(ConfigReader.getProperty(mail));
        page.passwordBox.sendKeys(ConfigReader.getProperty(password));
        ReusableMethods.scrollWithUiScrollableAndClick(girisYap);
    }

    @Given("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        Assert.assertTrue(page.basariliGirisText.isDisplayed());

    }


}
