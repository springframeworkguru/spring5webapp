# Spring Framework 5: Beginner to Guru

This repository is for an example application built in my [Spring Framework 5 - Beginner to Guru](https://courses.springframework.guru/p/spring-framework-5-begginer-to-guru) online course

The application is a simple Spring Boot 2 / Spring Framework 5 web application.

If you would like learn about what's new in Spring Framework 5, click [here](https://springframework.guru/what-is-new-with-spring-framework-5/)

If you'd like to learn more about the cool new reactive types in Spring Framework 5, click [here](https://springframework.guru/spring-web-reactive/)

You can learn about my Spring Framework 5 Online course [here.](https://courses.springframework.guru/p/spring-framework-5-begginer-to-guru)

# Spring Framework 5: Beginner to Guru Course FAQs

Check out this section for answers to frequently asked questions! 

## Development Environment Setup

### Recommended Versions

| Recommended | Reference | Notes |
| ----------- | --------- | ----- |
| Oracle Java 8 JDK | [Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) | Java 11 is okay, see notes in FAQ |
| IntelliJ 2018 or Higher | [Download](https://www.jetbrains.com/idea/download/) | Ultimate Edition recommended |
| Maven 3.6.0 or higher | [Download](https://maven.apache.org/download.cgi) | [Installation Instructions](https://maven.apache.org/install.html)|
| Gradle 4.8 or higher | [Download](https://gradle.org/install/) | **Note:** Use Version 5 or higher if using Java 11 |
| Git 2.15 or higher | [Download](https://git-scm.com/downloads) | | 
| Git GUI Clients | [Downloads](https://git-scm.com/downloads/guis) | Not required. But can be helpful if new to Git. SourceTree is a good option for Mac and Windows users. |
| Spring Boot 2.1 or higher | [What's new](https://content.pivotal.io/springone-platform-2017/whats-new-in-spring-boot-2-0-phillip-webb-madhura-bhave) | | 

### Getting Help With the Course
#### Udemy Q&A
Each course section has a Q&A Section. This should always be your first stop. Thousands of people have take this course.
Check to see if someone else asked a question related to your problem. 

If not, share your problem here. The instructor, teacher's assistants, and other students watch and answer questions. 

#### Slack
By enrolling in *Spring Framework 5: Beginner to Guru* you can join a Slack community exclusive to this course.

In Slack you can get help 24 hrs a day, 7 days a week. The instructor, teachers assistants, and other students monitor Slack.

See section 1 of the course for instructions on how to join. 

#### Do's and Don't of Getting Help

###### Do - Use Udemy Q&A or Slack
These resources are monitored by the instructor, teachers assistants, and other students.

###### Don't - Email or message the instructor directly
Asking your question in the public forums actually help others learn too. When you go outside the community, this is lost.
Also, the instructor is not always on-line and does take days off. You are likely to get a much faster response using Udemy Q&A or
Slack.

###### Do - Share a Link to your Project on GitHub
This helps others re-create your problem.

###### Don't - Share just a short part of the Error 
Example of error shared:
```xml
Failed to execute goal org.apache.maven.plugins:maven-release-plugin:2.5.3:prepare (default-cli) on project pet-clinic: Maven execution failed, exit code: '1' -> [Help 1]
```
In the above example, it is impossible to tell what the root cause is. The person has not shared enough details. 

When seeking help, help others help you!

###### Do - Share the Error Output in a GitHub Gist Link
Create a [Gist](https://help.github.com/articles/about-gists/) of the error output to share.

**Pro-Tip** - You can create a gist from the run window of IntelliJ. In the console, right click > select option for 
create gist. 

###### Don't Share Screenshots 
Using a gist is usually a better option! 

###### Don't - Open GitHub Issues
Unfortunately, the course has been pirated. Support is for people who are legitimately enrolled in the course. There is 
no way to verify enrollment from GitHub. Thus, problems raised on GitHub will not be addressed. 

**Exception:** One exception is the Pet Clinic project, which is being treated as a community project.   
### Java Version

#### Which version of Java should I use?

Majority of the course has been developed on Java 8. The course is being updated to Java 11.

If you wish to use Java 9 or higher, please modify the following:

**Note:** If you are on Java 9, or Java 10 you should consider updating to Java 11.

Update your Maven POM properties to reflect the Java version. 
```xml
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>11</java.version>
        <jaxb.version>2.3.0</jaxb.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
    </properties>

```

The JAXB API is no longer included with Java in Java 9 and higher. You will need to add this dependency as follows:

```xml
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>${jaxb.version}</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-core</artifactId>
            <version>${jaxb.version}</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-impl</artifactId>
            <version>${jaxb.version}</version>
        </dependency>
```

#### Do I need to use the Oracle JDK?
No. Open JDK should work just as well. 

#### Do I need to pay Oracle for a license to use Java?
No, the Oracle JDK is free to use for development.

### Java IDE
#### Do I meed to use IntelliJ for this course?
No, all source code examples use Maven or Gradle. Any modern Java IDE supports these build tools.

#### Is it okay to use Eclipse for this course?
Yes. However, please understand the instructor has not used Eclipse in over 10 years and will not be able to 
answer IDE related questions. 

#### Can I use the Community Edition of IntelliJ?
Yes. The Community edition of IntelliJ is very good. The Ultimate Edition does have advanced features to support
Spring Framework development. These features are used in the course, and will not be available in the 
Community Edition.

#### How do I get the free 120 Day Trial to IntelliJ Ultimate?
See section 1 of the course. There is a lecture with a sign-up link to register. You can download IntelliJ Ultimate with a 
free 30 day trial right away. You will be emailed a code with instructions within 3-5 business days. (often faster)

#### I haven't received my 120 Day Trial code to IntelliJ Ultimate
If it has been more than 5 days, check your spam folder. (Almost always there!) If not found, email John Thompson. If 
messaging on Udemy please include the email you registered with.

#### The code I received is not working.
This is often one of the following:
* You are entering the code as a license in IntelliJ. It is not a license code. It is a code for JetBrains to 
issue you a 120 day license. Use this [link](https://www.jetbrains.com/store/redeem/) to register with JetBrains. 
* If you get the error ```This coupon code is not applicable to the product.``` often it is because the email you are 
using has been registered with JetBrains in the past. Try using a different email account.

#### Can I Use the EAP version of IntelliJ?
Yep! The instructor typically runs on the EAP version to get all the latest features. The EAP version is usually 
very stable. Checkout the latest EAP version [here](https://www.jetbrains.com/idea/whatsnew/)

## Common Problems
#### Getting error - Whitelabel Error Page - This application has no explicit mapping for /error...
This is a generic error page generated by Spring Boot. The root cause can be many different things. 

If you see this web page, you need to view the Spring Boot console messages to determine the root cause.  

#### Project wont start. Getting error:  java.net.BindException: Address already in use
May see in console log:
```
***************************
APPLICATION FAILED TO START
***************************

Description:

The Tomcat connector configured to listen on port 8080 failed to start. The port may already be in use or the connector may be misconfigured.

Action:

Verify the connector's configuration, identify and stop any process that's listening on port 8080, or configure this application to listen on another port.
```

This means another application is already running on port 8080. You need to find and stop the other application.

#### Database tables missing in H2 Database console. 
By default Spring Boot will configure the datasource as ```jdbc:h2:mem:testdb```

However, if running the H2 database console for the first time, the datasource URL is ```jdbc:h2:~/test```

What happens is the H2 database console is connecting to a different instance of the H2 database console, thus you will 
not see the database tables.

**Solution:** When connecting in the H2 Database Console, change the JDBC URL to ```jdbc:h2:mem:testdb``` 

#### Multi-Module Maven Project has error 'can't find Main class'
Spring Boot is trying to build an executable fat JAR with dependencies for a module that should be a normal JAR, thus looking 
for the main class for the JAR manifest file.

**Solution:** 
You need to tell the Spring Boot Maven Plugin to **not** repackage the jar. 

Add the following property to the Maven module you wish packaged as a normal jar. 

```xml
    <properties>
        <spring-boot.repackage.skip>true</spring-boot.repackage.skip>
    </properties>
```
**Note:** For Spring Boot 2.1 or Higher! This configuration has changed from earlier versions of Spring Boot.

#### Getting an error, but cannot find what is different from lesson source code.
Sometimes it can be a very small difference. You can use Git to report the differences between your code and the example
source code for the lesson. 

**Note:** This will only work if you've forked the original source code example to your GitHub repository.

1. Commit all of your changes.  
2. Add remote for original repo - ```git remote add sfgRepo github_url```
3. Fetch remote - ```git fetch sfgRepo```
4. Run diff - ```git diff HEAD..sfgRepo/master``` <- update branch name from master to desired branch for lesson

#### Error - java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
You are running Java 9+ and have not added the JAXB dependencies. 

Add the following dependencies to your Maven POM:

```xml
    <properties>
        <jaxb.version>2.3.0</jaxb.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>${jaxb.version}</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-core</artifactId>
            <version>${jaxb.version}</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-impl</artifactId>
            <version>${jaxb.version}</version>
        </dependency>
    </dependencies>        
```

#### JUnit 5 Tests are not running from Maven
There are several reasons for this, and a lot of bad advice on the internet. 

Please see this [blog post!](https://springframework.guru/why-your-junit-5-tests-are-not-running-under-maven/)

#### Spring Pet Clinic - CSS is not rendered, page is not styled. 
The CSS resources are generated with Maven. Thus if the project is cleaned, not built, or re-generated with IntelliJ
the CSS resources will not exist. 

**Solution:** Just build the project with Maven. ```mvn clean package```

#### Error 'No qualifying Bean of type [Java class name] found for dependency...'
Spring is looking for a bean of a specific type in the context, but is unable to find it. Error is because Spring
has not been configured to create a bean for the Java class indicated in the message.

This may be due to several different reasons, but when troubleshooting - keep in mind Spring is telling you
that Java class is missing from the context. You need to tell Spring to create a bean of that type.

Try the following:
1. Make sure you have a bean of the type configured.
    * Is the missing Java class annotated with a Spring stereotype - @Component, @Controller, @RestController, @Service, @Repository?
    * Or has the bean been declared in a Java configuration class using the @Bean annotation? 
2. Is the package of the Java class or configuration class being scanned?
    * By default, Spring Boot will do a component scan of the package of the main application class, and all sub-packages.
    A common mistake is to create a package outside of this package structure. (thus, Spring does not 'see' the configuration)
    * If the component is not under the package of the main application class, use the @ComponentScan annotation. See this 
    [link](https://springframework.guru/spring-component-scan/) for additional information.
