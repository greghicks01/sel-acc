package selacc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class FluentDriver {

    enum DriverType { ANDROID, IOS, BROWSER }

    public FluentDriver(){};

    public FluentDriver withCapabilities(DesiredCapabilities dc){
        return this;
    }

    public FluentDriver withCapabilities(String dc){
        return this;
    }

    public FluentDriver usingHub( URL url){
        return this;
    }

    public FluentDriver usingHub( String url){
        return this;
    }

    public FluentDriver asType( DriverType type){
        return this;
    }

    public FluentDriver asType( String type){
        return this;
    }

    public WebDriver start(){
        return new ChromeDriver();
    }

}
