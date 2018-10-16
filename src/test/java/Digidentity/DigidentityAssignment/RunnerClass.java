package Digidentity.DigidentityAssignment;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//DdySmallApp
@CucumberOptions(features="C:\\Users\\sanke\\eclipse-workspaceStudy\\DigidentityAssignment\\src\\test\\java\\\\DDTofDdySmallApp.feature",
plugin={"pretty","html:target/Reports"},monochrome = true)
public class RunnerClass {

}
