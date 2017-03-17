## Project

This is just a modification of the spring security oauth tutorial [here](https://github.com/spring-guides/tut-spring-boot-oauth2/tree/master/auth-server). We've added an AuthorizationEndpointConfigurer by way of overriding the adapter class.

## Issue

The ```@PostConstruct``` method in our implementation of ```ClientDetails``` is called twice: Once during the creation of the spring context, and once on the first attempt to access a token endpoint, which we do with the following command: ```curl acme:acmesecret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=password```. Building this project and issuing the previous command in the terminal should be enough to reproduce the issue. The calling of the ```@PostConstruct``` method is visible as a warning in the logs.