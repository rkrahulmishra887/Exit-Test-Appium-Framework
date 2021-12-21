# Cucumber with TestNG and Appium framework

The framework is developed using Cucumber(Behaviour Driven Development), TestNG and Appium. The scripts are written using Java programming language. The design pattern used as part of this framework is "Page Object Model". 
The sample application used as a part of the assignment is "ApiDemos". This apk is available in "app_folder" folder of the repository

The key features about this framework include:
1. TestNG feature- Scenario execution can be distributed among different devices by configuring the parameter "tags" to include the required scenarios to be executed and setting "enabled" option as "true" for the respective devices on which scripts need to be executed
2. Cucumber feature- Test cases are written in easily understandable format. The Feature files are placed in "resources/features" folder.
3. Page Object Model - The objects for every screen is defined in class files under "pageobjects" folder
4. Reporting:
a. Detailed Report - Detailed execution results can be viewed in Detailed report under reports/DetailedTestReport.html
a. Summary Report - Summary execution results can be viewed in Summary report under reports/SummaryTestReport.html
5. The test data required for the scenarios is read from excel file using APACHE POI. Data files are placed in "data" folder.
6. Property file is also used where the app properties such as app path and app package is defined. The property file "demoApp.properties" is placed in "config" folder
7. The generic functions are written in ElementWrappers class file. This would help in maximum reuse of the functions written for performing different actions on mobile app and completion of automation faster.   

Execute scripts using command: 
1. "mvn test"