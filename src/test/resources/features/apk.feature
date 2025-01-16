
Feature: Kullanici calistirmak istedigi uygulamanin yukleme isşemini bu feature dosyasi ile apkSetup'ini yapar.


  Scenario: Kullanici aile bütçem apk dosyasini telefona set eder.
    * kullanici gerekli kurulumlari yaparak istenilen uygulamayi "C:\Users\Hp\IdeaProjects\AppiumCucumber\apps\Bütçem_1.0_apkcombo.app.apk" cihaza yukler
    # yukaridaki islem icin, APKSetup Stepdefinitions classina önceki projeden aldığım capability tanimlamalarini
    # koydum ancak kodumuzun dinamik calismasi için bu classta apk uygulamasinin olduğu contentRoot u siliyorum ve
    # her defasinda kod blogunun icerise girip bu kismi duzeltmek zorunda kalmayayim.
    # bunu nasil yaparim ==> featuredaki tc ye " " ile bir parametre yeri koyarak. ayrica StepDefinition daki metod kısmında
    # da çift tirnak yaptigimiz yere {string} yazdigimizda artik parametreli hale gelmis olacaktir. method kısmına da
    # Strind dosyaYolu ile parametreyi tanimladim. artik feature kısmına apk'nin contentRoot unu ekleyerek devam ediyorum.Feature:

