# ShopKeep
QA Assignment


This repository contains Selenium tests for the iPad Button Layout section of the ShopKeep BackOffice.
It contains both manual and automated test cases.
The framework is built following a Page Object Model design pattern.



*****************
MANUAL TEST CASES
*****************
Navigate to:

 * ShopKeep/Manual/TestCases



********************
AUTOMATED TEST CASES
********************
The WebElements & Methods have been divided from the Tests

Navigate to:

 * ShopKeep/src/main/java/IPadLayout/.. (for WebElements & Methods)
 * ShopKeep/src/test/java/IPadLayoutTest/.. (for Tests)                        <----------- AUTOMATED TESTS

TEST SUITE (.xml) is under /ShopKeepAutomation/ShopKeep/src/test/ShopKeepAppTestRunner.xml


**************
Things to know
**************
* Object Design Pattern: Page Object Model
* Programming Language:  Java
* Data Flow:             mySQL Database is used to retrieve sensitive data to log into the ShopKeep account.
                       (To execute tests locally navigate to ShopKeep/src/main/java/methods/CommonMethods and enter username and password
                       manually into the commented out shopKeepLogin methods AND comment out the current shopKeepLogin method)
* Build Tool:            Maven
* Code Repository:       GitHub
* Configuration:         Stored in XML file. (Navigate to /ShopKeepAutomation/ShopKeep/src/test/ShopKeepAppTestRunner.xml)



***************
GETTING STARTED
***************
The following steps should get you set up for running Selenium tests locally on your machine:


i)Clone the repository into a local computer by running the following commands in the terminal:

     * cd (select destination directory)

     * git clone https://github.com/achowdhury94/ShopKeep.git

After running codes open the cloned file in an IDE.

To run test locally user would have to run the XML file located under /ShopKeepAutomation/ShopKeep/src/test/ShopKeepAppTestRunner.xml


