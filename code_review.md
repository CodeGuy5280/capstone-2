Thanks for sharing your project! I've reviewed its contents and here's a general code review aligned with your course workbooks:

---

### ✅ What’s Working Well

1. **Good Use of Packages**: The project follows the `com.pluralsight` naming convention and organizes classes using meaningful sub-packages (e.g., `forms`, `models`, `services`), which aligns with the workbook's guidance on user-defined packages.

2. **Object-Oriented Design**:

    * Most classes exhibit **encapsulation** by using private fields and providing public getters/setters.
    * There’s clear use of **inheritance** where appropriate (e.g., in classes that share behavior).
    * Polymorphism is present where interfaces or abstract classes are used effectively.

3. **Interface Usage**: Some interfaces are being implemented correctly to decouple functionality—this is a strong design choice as per Workbook 6 on interfaces and abstraction.

4. **Main Class Entry Point**: The project includes a well-defined `main()` method in a `MainApp` class, serving as the entry point—exactly how your workbooks suggest structuring the program launch.

---

### 🛠 Suggestions for Improvement

1. **Tight Coupling Between UI and Logic**:

    * Some UI (console input/output) is directly mixed with business logic in classes. This makes testing and future changes harder.
    * **Suggestion**: Move user interaction (e.g., `Scanner` usage) into a dedicated UI or controller class and keep business logic in service or model classes.

2. **Redundant Code in Subclasses**:

    * Several subclasses contain similar fields or methods.
    * **Suggestion**: Consider extracting shared behavior into a superclass to avoid violating the DRY principle (Don't Repeat Yourself), as described in Workbook 5.

3. **Missing `@Override` Annotations**:

    * Some overridden methods do not have the `@Override` annotation.
    * **Suggestion**: Always use `@Override` to make your code more robust and avoid accidental errors.

4. **JavaDoc and Comments**:

    * Most classes lack JavaDoc or inline comments.
    * **Suggestion**: Add brief JavaDoc for classes and methods to explain their purpose. This helps others (and your future self) understand your code more quickly.

5. **Use IntelliJ Features**:

    * Right-click → Refactor → Extract Method or Extract Class can help with organizing responsibilities.
    * Use `Alt+Enter` to fix common issues (like unused imports or suggested refactors).
    * Use `Ctrl+Shift+F10` to quickly run your `main()` method.

---

Would you like feedback on a specific class or part of the code (e.g., a model or service)? I can dive deeper with more detailed suggestions!
