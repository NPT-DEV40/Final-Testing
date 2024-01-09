import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def verifyInputFieldValue(TestObject to, String expectedValue) {
	String actualValue = WebUI.getAttribute(to, 'value')
	if (actualValue != expectedValue) {
		KeywordUtil.markFailedAndStop('Input field value is not as expected. Actual: ' + actualValue + ', Expected: ' + expectedValue)
	}
}

WebUI.openBrowser('')

WebUI.navigateToUrl('https://demo.firefly-iii.org/login')

WebUI.click(findTestObject('Object Repository/Page_Login to Firefly III/button_Sign in'))

WebUI.click(findTestObject('Object Repository/Page_Whats playing  Firefly III/span_demofirefly_fa fa-plus-circle'))

WebUI.click(findTestObject('Object Repository/Page_Whats playing  Firefly III/a_New budget'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page Create new budget/auto_budget_input new budget'), 
    '1', true)

WebUI.setText(findTestObject('Object Repository/Page Create new budget/auto_budget_amount_input new budget'), 
    '3333')

TestObject inputFieldTo = findTestObject('Object Repository/Page Create new budget/auto_budget_amount_input new budget')
String expectedValue = '3333'
verifyInputFieldValue(inputFieldTo, expectedValue)

WebUI.closeBrowser()

