package tests;

import org.testng.annotations.Test;

public class LoginvalidTest extends TestBase {

    @Test
    public void testvalidLoginAttempt() throws Exception {
            lv.VerifyvalidCredentials();
            lv.clickLogin();
            lv.logoutbtn();
            
            
       
    }
}
