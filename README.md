# NodeServerAPI
API for Node Server

[![](https://jitpack.io/v/node-chat/NodeServerAPI.svg)](https://jitpack.io/#node-chat/NodeServerAPI)

**Download**


```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.node-chat</groupId>
    <artifactId>NodeServerAPI</artifactId>
    <version>VERSION</version>
</dependency>
```

**Creating an Event Listener**

```java
public class ExampleListener extends Listener {

    @EventTarget
    public void onMessage(UserMessageEvent event) {
        System.out.println(event.getMessage());
    }

}
```

**Creating a Command**

```java
public class HelloCommand implements Command {

    @Override
    public String getName() {
        return "hello";
    }

}
```
