# Eureka-client-client


This repository is part of a tripled of microservices to play with Eureka service discovery. In this trippled, this  microservice plays the next roles: 
- Eureka-instance registering itself in the service registry
- Eureka-client since it queries the registry to locate other services
- Client of microservice-service, using the service discovery to connect to it and it's resources.

To execute simply execute:

```
gradle bootRun
```

This service will be running on port: 8234. To get information from eureka service about a registered application use:

```
  http://localhost:8234/service-instances/{applicationName}
```

The next request will consume an endpoint from eureka-client-service

```
  http://localhost:8234/consume-service/ping
```