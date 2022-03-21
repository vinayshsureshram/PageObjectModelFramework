import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTests extends BaseTest {

    @TmsLink("MBP-1234")
    @Description("Verify successful login on Swag Labs")
    @Test(dataProviderClass = utils.ExcelReaderUtil.class, dataProvider = "getExcelData")
    public void firstTest(String userName, String password) {
        common.logInToApp(userName, password);
        Assert.assertTrue(dashboardPage.verifyProductHeaderIsDisplayed(), "Login unsuccessful");

        common.logOutFromApp();
    }

    @Test
    public void secondTest() {
        System.out.println("This is the second test");
    }

    @Test
    public void thirdTest() {
        System.out.println("This is the third test");
        Assert.assertTrue(false);

    }
}