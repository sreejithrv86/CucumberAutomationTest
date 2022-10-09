echo on
cd C:\Users\HP\git\CucumberAutomationTest
java --enable-preview -jar -Dbrowsername=chrome -Dapplicationname=phptravels -Denvname=qa -Dplatform=local target\CucumberAutomationTest-0.0.2.jar classpath:features -n "user is able to search"
Pause