# QuantityMeasurementApp
🔹 UC1: Feet Measurement Equality
    .Compare two values in feet
    .Validate numeric inputs
    .Return equality result
    
 🔹 UC2: Feet and Inches Measurement Equality
     .Extended UC1 to support inches along with feet
     .Equality checks are performed within the same unit type only
     .Feet vs Feet ✅
     .Inches vs Inches ✅
     .Feet vs Inches ❌ (not compared in this UC)
Ensures:
     .Accurate comparison
     .Proper handling of edge cases
     .Complete test coverage   

🔹 UC3: Generic Quantity Class (DRY Principle)
     .Introduced QuantityLength class
     .Eliminated duplicate code from Feet & Inches
     .Applied DRY principle
     
🔹 UC4: Extended Unit Support
   Added:
    .Yards (1 yard = 3 feet)
    .Centimeters (1 cm = 0.393701 inches)
    .Seamless comparison across units
    
🔹 UC5: Unit Conversion
    .Convert between units (feet → inches, etc.)
    .Centralized conversion logic
    
🔹 UC6: Addition of Length Units
    .Add values with different units
    .Result returned in base unit of first operand
    
🔹 UC7: Addition with Target Unit
    .Specify desired output unit
  Example:
  1 ft + 12 in → 0.667 yards
  
🔹 UC8: Refactoring Unit Enum
    .Extracted LengthUnit as standalone
    .Delegated conversion logic to unit
    .Improved scalability & SRP compliance
    
🔹 UC9: Weight Measurement Support
   Added:
    Kilogram
    Gram
    Pound
    Supported equality, conversion, addition
    
🔹 UC10: Generic Quantity Class
    .Introduced Quantity<U>
    .Created IMeasurable interface
    .Unified all measurement categories
    
🔹 UC11: Volume Measurement
    Added:
     Litre
     Millilitre
     Gallon
     Reused generic architecture
     
🔹 UC12: Arithmetic Operations
    Added:
     Subtraction
     Division
     Division returns scalar value
     
🔹 UC13: Centralized Arithmetic Logic
    .Removed duplicate logic
    .Introduced reusable helper methods
    .Improved maintainability
    
🔹 UC14: Temperature Measurement
    Added temperature support
    Limited operations:
   ✅ Addition/Subtraction (differences)
   ❌ Division/Multiplication (not meaningful)
   Refactored interface for flexibility
   
🔹 UC15: N-Tier Architecture
    Layered architecture:
     .Controller
     .Service
     .Repository
     Separation of concerns
     
🔹 UC16: Database Integration
    Integrated H2 Database
    Stored:
     .Users
     .(Optional) Conversion history
     
🔹 UC17: Spring Boot MVC Conversion
    .Converted project into REST APIs
    .Implemented controllers for operations
    .Structured project for real-world backend
    
🔹 UC18: Authentication & Authorization
    Implemented security using:
    .Spring Security
    .JWT Authentication
Features:
   .User Signup
   .Login
   .Protected APIs

Project Structure
src/main/java/com/example/QuantityMeasurementApp
│
├── controller       → REST Controllers
├── service          → Business Logic
├── repository       → Database Layer
├── model            → Entities
├── dto              → Data Transfer Objects
├── config           → Security Config
└── util             → Units & Conversion Logic


⭐ Conclusion

This project demonstrates the evolution of a simple measurement system into a production-ready backend application using modern development practices, scalable architecture, and secure API design.
   
