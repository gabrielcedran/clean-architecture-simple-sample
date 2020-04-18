# Clean Architecture Sample
This application is a very simplistic simulation of a system meant to register sales. Each sales consist of the product, employee and customer involved in that transaction.

The business rules implemented were simplified as much as possible so that it is possible to focus on the clean architecture's patterns, principles and practices 
followed during development.

This application implements the following layers, each represented as a sub module in this project source:
Presentation: Place where controllers are developed and stored in order to expose the rest api to interact with the application.
Application: Layer where business logic and use cases are implemented and stored 
Domain: Place where the entities are stored
Persistence: Layer responsible to abstract database access
Infrastructure: Layer responsible to abstract communication with third party systems, apis and OS features 

As a domain centric architecture (rather than a database centric architecture), the outer layers point to the inner layers and the inner layers have no 
knowledge of the outer layers. In order to allow inner layers to access external tools and apis, dependency inversion and inversion of control is utilized, 
so that coupling is reduced and flexibility increased:

![Image of Yaktocat](https://github.com/gabrielcedran/clean-architecture-simple-sample/blob/master/diagram.png) 

The solid lines represent the actual dependency among the components, while the dashed lines represent the real dependencies.
In order to allow the Application layer to access the Persistence layer, the Application layer declares the interfaces which 
make sense from business perspective and the Persistence layer implement them (DIP: abstractions should rely on interfaces rather than in details) and they are
wired together using Dependency Inject/Inversion of Control.]
] 

Project based on the plural sight course [Clean Architecture: Patterns, Practices and Principles](https://app.pluralsight.com/library/courses/clean-architecture-patterns-practices-principles).

