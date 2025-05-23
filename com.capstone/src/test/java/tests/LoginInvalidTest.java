package tests;

import org.testng.annotations.Test;

public class LoginInvalidTest extends TestBase {

    @Test
    public void testInvalidLoginAttempt() throws Exception {
            liv.VerifyInvalidCredentials();
            liv.clickLogin();
            liv.verifyLoginMessage();
       
    }
}
