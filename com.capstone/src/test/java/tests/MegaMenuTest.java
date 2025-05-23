package tests;


import org.testng.Assert;
import org.testng.annotations.*;


public class MegaMenuTest  extends TestBase1{
    

    @Test
    public void testAppleFromMegaMenu() {
        megaPage.hoverAndClickApple();
//       
        Assert.assertTrue(megaPage.getPageTitle().contains("Apple"), "Apple page not opened");
    }

    

}
