package driver;

import io.cucumber.java.After;

public class Hooks {

    @After
    public void quitDriver() {
        SingletonDriver.quitDriver();
    }
}
