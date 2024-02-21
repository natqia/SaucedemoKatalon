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

def dataLogin = findTestData('Data Files/dataLogin')
def username = dataLogin.getObjectValue('Username', 1)
WebUI.comment(username)
def password = dataLogin.getObjectValue('Password', 1)
WebUI.comment(password)

def dataItem = findTestData('Data Files/dataItem')
def identifierItem = dataItem.getObjectValue('locatorItem', 1)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

if(WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'), 5, FailureHandling.STOP_ON_FAILURE))
	WebUI.comment('Halaman Login Muncul')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_user-name'), username)

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_password'), password)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Swag Labs_login-button'))

loginSuccess = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/span_Products'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyMatch(loginSuccess, 'Products', false)

WebUI.closeBrowser()

