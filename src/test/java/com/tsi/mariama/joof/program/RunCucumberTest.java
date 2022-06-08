package com.tsi.mariama.joof.program;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "src/test/resources/Cucumber",
        glue = "com.tsi.mariama.joof.program"

)
public class RunCucumberTest {

}
