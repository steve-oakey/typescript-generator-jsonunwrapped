# Unexpected Output using @JsonUnwrapped

Run `mvn clean verify` to generate `target/npm/model.d.ts`

# Setup
Based on [JsonUnwrappedTest](https://github.com/vojtechhabarta/typescript-generator/blob/master/typescript-generator-core/src/test/java/cz/habarta/typescript/generator/JsonUnwrappedTest.java), given classes:
```java
public class Name {
    private String first;
    private String last;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}

public class Person {
    @JsonUnwrapped
    private Name name;

    public Name getName() {
        return name;
    }
}
```
and Maven Configuration:
```xml
<configuration>
    <jsonLibrary>jackson2</jsonLibrary>
    <classPatterns>
        <class>ca.oakey.typescript.model.*</class>
    </classPatterns>
    <outputFile>${project.build.directory}\npm\model.d.ts</outputFile>
    <outputKind>ambientModule</outputKind>
    <module>model</module>
</configuration>
```
## Expected Output
```typescript
/* tslint:disable */
// Generated using typescript-generator version 2.5.423 on 2018-07-25 13:44:18.

declare module "model" {

    interface Name {
        first: string;
        last: string;
    }

    interface Person {
        first: string;
        last: string;
    }

}
```
## Actual Output
```typescript
/* tslint:disable */
// Generated using typescript-generator version 2.5.423 on 2018-07-25 13:44:18.

declare module "model" {

    interface Name {
        first: string;
        last: string;
    }

    interface Person {
        name: Name;
    }

}
```