echo on
cd C:\Users\HP\git\CucumberAutomationTest\target
java -jar -Dbrowsername=chrome -Dapplicationname=phptravels -Denvname=qa CucumberAutomationTest-0.0.2.jar classpath:features -n "Login Functionality"
Pause