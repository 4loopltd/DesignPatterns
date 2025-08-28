# Java Design Patterns

![Java](https://img.shields.io/badge/Java-17+-orange)
![Patterns](https://img.shields.io/badge/Patterns-23-green)

A collection of **Java design patterns**, demonstrating best practices for scalable, maintainable software development.  

## Patterns Included  
- **Creational Patterns**: Abstract Factory, Builder, Factory, Prototype, Singleton  
- **Structural Patterns**: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy  
- **Behavioral Patterns**: Chain of Responsibility, Command, Interpreter, Mediator, Memento, Observer, State, Strategy, Template, Visitor  

## Why Use Design Patterns?  
Design patterns **improve code structure, scalability, and maintainability**. This repo serves as a reference for Java developers looking to implement **clean, efficient software architectures**.  

---

## Pattern Reference Guide

This comprehensive guide helps you quickly find the right pattern for your needs. Each pattern includes **what it solves**, **when to use it**, and **key benefits**.

### Creational Patterns
*Handle object creation mechanisms to increase flexibility and reuse*

#### **Abstract Factory** - `abstract-factory/`
**Creates families of related objects without specifying concrete classes**
- **Use When**: Need consistent object families, want to isolate product creation, building cross-platform applications
- **Benefits**: Ensures compatibility between related objects, easy to swap entire product families, promotes consistency
- **Example**: Garden design system with compatible layouts and plants

#### **Builder** - `builder/`
**Constructs complex objects step by step with different representations**
- **Use When**: Complex objects with many parameters, want readable object construction, need immutable objects
- **Benefits**: Fluent interface, flexible construction process, eliminates telescoping constructors
- **Example**: Vehicle construction with customizable components

#### **Factory Method** - `factory/`
**Creates objects through factory methods instead of direct instantiation**
- **Use When**: Don't know exact types at compile time, want to delegate object creation, need centralized creation logic
- **Benefits**: Eliminates dependency on concrete classes, centralizes creation logic, follows Open/Closed Principle
- **Example**: Car manufacturing based on type specifications

#### **Prototype** - `prototype/`
**Creates objects by cloning existing instances rather than constructing new ones**
- **Use When**: Object creation is expensive, want to avoid subclassing, need objects at runtime
- **Benefits**: Avoids expensive creation operations, uniform cloning interface, runtime object creation
- **Example**: Cloning different types of entities (animals, plants, minerals)

#### **Singleton** - `singleton/`
**Ensures only one instance exists and provides global access point**
- **Use When**: Need exactly one instance, require global access, want to control instantiation
- **Benefits**: Controlled instantiation, global access, memory efficiency, consistent state
- **Example**: Four different implementation approaches (eager, lazy, thread-safe, enhanced)

### Structural Patterns
*Compose objects into larger structures while keeping them flexible and efficient*

#### **Adapter** - `adapter/`
**Makes incompatible interfaces work together through conversion**
- **Use When**: Need to use existing class with incompatible interface, want to reuse legacy code, integrate third-party libraries
- **Benefits**: Enables code reuse, separates interface conversion from business logic, promotes interoperability
- **Example**: Making motorcycles work with bicycle interfaces

#### **Bridge** - `bridge/`
**Separates abstraction from implementation for independent variation**
- **Use When**: Want to avoid permanent binding, need to share implementation among objects, require runtime implementation switching
- **Benefits**: Decouples abstraction and implementation, both hierarchies can evolve independently, promotes composition over inheritance
- **Example**: Vehicles with different gearbox implementations

#### **Composite** - `composite/`
**Treats individual objects and compositions uniformly in tree structures**
- **Use When**: Need to represent part-whole hierarchies, want uniform treatment of objects and compositions, building tree structures
- **Benefits**: Uniform interface for leaves and composites, easy to add new component types, simplifies client code
- **Example**: Organizational hierarchy with managers and employees

#### **Decorator** - `decorator/`
**Adds behavior to objects dynamically without changing their structure**
- **Use When**: Want to add responsibilities dynamically, subclassing is impractical, need flexible behavior extension
- **Benefits**: Runtime behavior composition, alternative to subclassing, follows Single Responsibility Principle
- **Example**: Message processing pipeline with encoding/decoding decorators

#### **Facade** - `facade/`
**Provides simplified interface to complex subsystem**
- **Use When**: Want to hide subsystem complexity, need unified interface, reduce coupling between client and subsystem
- **Benefits**: Simplifies subsystem usage, reduces learning curve, promotes loose coupling, centralizes common operations
- **Example**: Engine control system with simplified start/stop operations

#### **Flyweight** - `flyweight/`
**Shares objects efficiently to support large numbers of fine-grained objects**
- **Use When**: Need many similar objects, memory usage is concern, object state can be separated (intrinsic/extrinsic)
- **Benefits**: Dramatic memory savings, efficient object reuse, separates intrinsic from extrinsic state
- **Example**: Car object sharing with different colors (extrinsic state)

#### **Proxy** - `proxy/`
**Provides placeholder/surrogate to control access to another object**
- **Use When**: Need lazy loading, access control, caching, logging, or remote object access
- **Benefits**: Transparent access control, performance optimization, additional behaviors without changing original object
- **Example**: Caching proxy for expensive operations

### Behavioral Patterns
*Focus on communication between objects and assignment of responsibilities*

#### **Chain of Responsibility** - `chain-of-responsibility/`
**Passes requests along chain of handlers until one handles it**
- **Use When**: Multiple objects can handle request, don't want to specify handler explicitly, need dynamic handler chain
- **Benefits**: Decouples sender from receiver, dynamic chain configuration, follows Single Responsibility Principle
- **Example**: Vehicle control system with different command handlers

#### **Command** - `command/`
**Encapsulates requests as objects for parameterization and queuing**
- **Use When**: Want to parameterize objects with operations, queue operations, support undo, log requests
- **Benefits**: Decouples invoker from receiver, supports macro commands, enables undo/redo, promotes first-class operations
- **Example**: Home automation switches controlling different devices

#### **Interpreter** - `interpreter/`
**Defines grammar representation and interpreter for language sentences**
- **Use When**: Have simple language to interpret, grammar is not too complex, efficiency is not critical
- **Benefits**: Grammar rules as classes, easy to add new grammar rules, supports recursive grammar structures
- **Example**: Number format parser for different bases (binary, octal, hex, decimal)

#### **Mediator** - `mediator/`
**Defines how objects interact through central mediator**
- **Use When**: Objects communicate in complex ways, want to reuse objects in different contexts, centralize complex communications
- **Benefits**: Decouples colleagues, centralizes communication logic, promotes object reusability
- **Example**: Animal communication system through central mediator

#### **Memento** - `memento/`
**Captures and restores object state without violating encapsulation**
- **Use When**: Need to save/restore object state, implement undo functionality, provide checkpoints
- **Benefits**: Preserves encapsulation boundaries, simplifies originator, separates state management from business logic
- **Example**: Text editor with undo capability

#### **Observer** - `observer/`
**Notifies multiple objects about state changes in observed object**
- **Use When**: Change in one object requires updating multiple objects, want loose coupling between objects
- **Benefits**: Broadcast communication, dynamic relationships, supports different observer types, follows Open/Closed Principle
- **Example**: Stock price monitoring with multiple observers

#### **State** - `state/`
**Changes object behavior when internal state changes**
- **Use When**: Object behavior depends on state, have many conditional statements for state-dependent behavior
- **Benefits**: Eliminates complex conditionals, encapsulates state-specific behavior, makes state transitions explicit
- **Example**: Traffic light system with state-specific transitions

#### **Strategy** - `strategy/`
**Makes algorithms interchangeable within object family**
- **Use When**: Have multiple ways to perform task, want to choose algorithm at runtime, eliminate conditional statements for algorithms
- **Benefits**: Algorithms are interchangeable, easy to add new strategies, eliminates conditional statements, supports composition
- **Example**: Calculation strategies with traditional classes, lambdas, and functional composition

#### **Template Method** - `template/`
**Defines algorithm skeleton, letting subclasses override specific steps**
- **Use When**: Have multiple classes with similar algorithms, want to control algorithm structure, need to reuse common code
- **Benefits**: Code reuse through inheritance, consistent algorithm flow, flexibility through method overrides
- **Example**: Car building process with different implementations for different car types

#### **Visitor** - `visitor/`
**Performs operations on object structure elements without changing their classes**
- **Use When**: Want to perform various operations on complex object structure, operations change frequently, structure is stable
- **Benefits**: Operations separated from data structure, easy to add new operations, operations can accumulate state
- **Example**: Car parts inspection system with different visitor operations

---

## Quick Pattern Selector

**Need to create objects?** → Creational Patterns  
- Complex construction? → **Builder**  
- Expensive creation? → **Prototype**, **Flyweight**  
- Families of objects? → **Abstract Factory**  
- Single instance? → **Singleton**  
- Runtime type selection? → **Factory Method**

**Need to combine objects?** → Structural Patterns  
- Incompatible interfaces? → **Adapter**  
- Complex subsystem? → **Facade**  
- Tree structures? → **Composite**  
- Add behavior dynamically? → **Decorator**  
- Control access? → **Proxy**  
- Separate abstraction/implementation? → **Bridge**

**Need objects to communicate?** → Behavioral Patterns  
- Undo functionality? → **Memento**  
- Multiple event handlers? → **Observer**  
- Chain of handlers? → **Chain of Responsibility**  
- Encapsulate requests? → **Command**  
- State-dependent behavior? → **State**  
- Interchangeable algorithms? → **Strategy**  
- Parse simple language? → **Interpreter**  
- Complex object interactions? → **Mediator**  
- Operations on structure? → **Visitor**  
- Common algorithm steps? → **Template Method**

---


