# sel-acc
Selenium Fluent Wrapper

[![Build Status](https://travis-ci.com/greghicks01/sel-acc.svg?branch=master)](https://travis-ci.com/greghicks01/sel-acc)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=alert_status)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=coverage)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc) [![Bugs](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=bugs)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc) [![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=code_smells)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc) [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=security_rating)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc) [![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=greghicks01_sel-acc&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=greghicks01_sel-acc)

This project wraps selenium drivers with a fluent set of actions to set up and launch a browser in tests.

The hub ensures we can also handle BrowserStack, Sauce labs etc

Usage:
fluent calls using these items - if any are left out, null/empty they are assumed to be the local Chrome Driver (handled by Bonigarcia WedDriver Manager)

  ```
  .withCapabilities( DesiredCapabilities dc )
    initialses the desired capabilities from a formatted string or a capabilities object

 .usingHub( URL url )
    prepares a remote driver session with the capabilites from above

  asType( DriverType type )
    expects type to cover android ios or Browser

  start()
    fires the session up and hands the driver for use in a test
