# Runasjar
## Project structure
As developers, we should try to keep our project structure as clean as possible.
I changed your structure back to a more base setup leaving your page files and utils in `src/main/java`
and moving your test classes and resources back into the `test` package. This allowed me to better visualize the project
structure which later allowed me to figure out the issue with the jar files.

it's also important that we don't add compiled code, compiler settings or, or test results to repositories as they take
up tons of space and can sometimes include things like passwords and config files that we want to keep to ourselves.
we can handle this by adding a .gitignore file with everything we want to leave out or keep local then by removing the 
offending files from our git tracking.

## pom.xml
with the structure changed i had to update the pom xml to jar our test package, i did this by adding a goal.
```
<plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>2.4</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>test-jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```
I also used the opportunity to reformat the xml, so it looked nicer =p

## Running tests with .Jar
This is where most the work happened and wasn't in the code at all, after everything the issue ended up being how were
executing. Java is not smart enough to follow a jar chain on its own so each jar path needs to be specified so
the executor can find all the code it needs. in our case we now have 3 jars

| Jar Name                                          |                    Description                     | 
|:--------------------------------------------------|:--------------------------------------------------:|
| RunAsJar-0.0.1-SNAPSHOT.jar                       | This jar contains the contents of `src/main/java`  |
| RunAsJar-0.0.1-SNAPSHOT-jar-with-dependencies.jar | This jar contains all our dependencies like testNG |
| RunAsJar-0.0.1-SNAPSHOT-tests.jar                 | This jar contains the contents of `src/main/test`  |

To get java to recognize all these jars and the code within we need to define them in our class path, to do this we'll
`--class-path` which takes a `:` seperated list of jars. Then we'll use the testNG package `org.testng.TestNG` with
options `-testjar` and `-xmlpathinjar` to kick off the test run below is the exact command line to achieve this:
```
java --class-path RunAsJar-0.0.1-SNAPSHOT-jar-with-dependencies.jar:RunAsJar-0.0.1-SNAPSHOT.jar:RunAsJar-0.0.1-SNAPSHOT-tests.jar org.testng.TestNG -testjar RunAsJar-0.0.1-SNAPSHOT-tests.jar -xmlpathinjar resources/Contacts.xml
```
