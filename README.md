# sel-acc
Selenium Fluent Wrapper

This project wraps selenium drivers with a fluent set of actions to set up and launch a browser in tests.

The hub ensures we can also handle BrowserStack, Sauce labs etc

Usage:
fluent calls using these items - if any are left out, null/empty they are assumed to be the local Chrome Driver (handled by Bonigarcia WedDriver Manager)

  ```.withCapabilities( DesiredCapabilities dc )```
  ~~~.withCapabilities( String dc )~~~
    initialses the desired capabilities from a formatted string or a capabilities object

  ~~~usingHub( String url )~~~
  ~~~usingHub( URL url )~~~
    prepares a remote driver session with the capabilites from above

  ~~~asType( DriverType type )~~~
  ~~~asType( String type )~~~
    expects type to cover android ios or Browser

  ~~~start()~~~
    fires the session up and hands the driver for use in a test
