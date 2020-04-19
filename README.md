# Clean Architecture Sample
This application is a very simplistic simulation of a system meant to register sales. Each sale consists of the product, employee and customer involved in that transaction.

The business rules implemented were simplified as much as possible so that it is possible to focus on the clean architecture's patterns, principles and practices 
followed during development - project based on the plural sight course [Clean Architecture: Patterns, Practices and Principles](https://app.pluralsight.com/library/courses/clean-architecture-patterns-practices-principles).

This application implements the following layers, each represented as a sub module in this project source:
Presentation: Place where controllers are developed and stored in order to expose the rest api to interact with the application.
Application: Layer where business logic and use cases are implemented and stored 
Domain: Place where the entities are stored
Persistence: Layer responsible to abstract database access
Infrastructure: Layer responsible to abstract communication with third party systems, apis and OS features 

As a domain centric architecture (rather than a database centric architecture), the outer layers point to the inner layers and the inner layers have no 
knowledge of the outer layers. In order to allow inner layers to access external tools and apis, dependency inversion and inversion of control is utilized, 
so that coupling is reduced and flexibility increased. This design can be seen in the following diagram, where the solid lines represent the actual dependency among the components, while the dashed lines represent the real dependencies.

![Image of Yaktocat](https://github.com/gabrielcedran/clean-architecture-simple-sample/blob/master/diagram.png) 

The application layer cannot explicitly instantiate or reference anything from the Persistence and Infrastructure modules. 
It's not possible even on purpose, preventing unwary mistakes and violation of DIP and the architecture design.

### Command Query Responsibility Segregation
The primary reason to segregate Commands from Queries is that they should optimized to perform their operations. In general,
commands should execute behaviors in the domain model in order to mutate state, raise events and write data to the database,
while queries should use whatever is most suitable to retrieve data, project into a format for presentation and display to the user.

In other words, Commands should read as high level instructions working with entities in the domain model to modify state and save changes
while query should bypass model and query the database directly but whatever means it the most appropriate way to display the necessary data.

CQRS can have three different levels of implementation: single-database, database segregation and event sourcing.


### Project Organization
"The architecture should scream the intent of the system" Robert C. Martin
When organizing the structure of a project, facilitating the understand of the readers should be taken into consideration.
The classical structuring by components (or categories) although widely and commonly used does not convey the intention of the 
project clearly. Suppose the two following sets of root modules/packages for the same project, just organized differently:
By components (typical MVC structure):
- Content
- Controllers
- Models
- Scripts
- Views

By use cases/domains:
- Customers
- Employees
- Products
- Sales
- Vendors
  
While the first example is very hard to determine the intent of the software, the second is easier.
The functional cohesion provided by the second is generally more efficient than categorical cohesion, because it better models
the way the system is maintained, navigated and reason about software.
It is like keeping together your silverware forks your the pitch forks and tuning fork, just because they are forks.
Functional cohesion is like keeping your forks next to your spoons and knives, because these three utensils are usually used together.   

