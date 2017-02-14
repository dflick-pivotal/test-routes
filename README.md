# test-routes

This example describes how to map different routes with different domains to different endpoints of a single application on Pivotal CF.

Goals:
- Map the spring boot actuator endpoints to a private domain. The actuator endpoints must not be accessible via the internet.
- Map other endpoints to different routes usding different domains. The endpoint used by angularjs to communicate from the browser to the app on PCF must be separated from rest api endpoints of the same application. The angularjs endpoint is internet facing the rest endpoint is private.

Pivotal CF supports this kind of route mappings.

This spring-boot app has actuator endpoints and a [rest and a ui](https://github.com/dflick-pivotal/test-routes/blob/master/src/main/java/com/example/MyController.java#L10-L20) endpoint.

The actuator endpoints are available by simple adding the actuator dependency to the [maven pom.xml](https://github.com/dflick-pivotal/test-routes/blob/master/pom.xml#L28-L31) file of the spring-boot app.

No route is mapped to the app when the app is pushed with the [manifest.yml](https://github.com/dflick-pivotal/test-routes/blob/master/manifest.yml#L8).  

Here are the cf cli commands for the mappings:
- ui endpoint: cf map-route test-routes INTERNET_FACING_DOMAIN --hostname ui --path ui
- rest endpoint: cf map-route test-routes PRIVATE_DOMAIN --hostname rest --path rest
- actuator endpoints: cf map-route test-routes PRIVATE_DOMAIN --hostname actuator-health --path health

With this mapping only the ui endpoint of the app is accessible from the internet. The rest endpoint and actuator endpoint is only accessible via a private domain. 
