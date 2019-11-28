# StadiumGoods
This project includes both StadiumGoods and Pokeiapi tests

Preferable system prefs:
* Win 8.1
* Chrome 78
* jdk 11
* apache maven 3.6.3
* chromedriver_win32_78

### Before running tests
1. Please make sure that you have jdk, maven and chrome installed
2. Clone this repo to your computer
3. Download "Test Data QA Challenge 11.4.19.xlsx", rename it to TestDataQAChallenge.xlsx and put file as an example src/test/resources/data/TestDataQAChallenge.xlsx near the testDataPlaceholder.txt file
4. Download cromedriver for your OS and Chrome (https://chromedriver.chromium.org/downloads). Put chromedriver.* as an example src/test/resources/driver/chromedriver.* near the chromedriverPlaceholder.txt file

Hopefully, you will use chromedriver.exe file. If not it may cause an issue.

### RUN tests
For running tests from console switch to current project root dir
* for StadiumGoods tests run command in command prompt `mvn clean test -P StadiumGoods -DbasicAuth.login=<login> -DbasicAuth.pass=<pass>`
* for Pokeiapi tests run command in command prompt `mvn clean test -P Pokeapi`

### Test results
Test results can be found in target/surefire-reports/index.html

# Happy testing :)
