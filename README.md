# Welcome to SonarQube client API

SonarQube client API is a Java library to make use of SonarQube REST API as easy as as drinking water.

SonarQube client API helps you make REST calls to SonarQube and return fully defined objects with all returned data.

## Usage
### Initialization of SonarQube client API
Main entrypoint to start using SonarQube client API is `SonarQubeClientApi` class accepting URL to SonarQube server, username and password or security token.

**Initialization of client API with username and password**
```java
SonarQubeClientApi clientApi = new SonarQubeClientApi("sonarqube_url", "username", "password");

/* Example */
SonarQubeClientApi clientApi = new SonarQubeClientApi("https://sonarcloud.io", "admin", "admin");
```

**Initialization of client API with security token**
```java
SonarQubeClientApi clientApi = new SonarQubeClientApi("sonarqube_url", "security_token");

/* Example */
SonarQubeClientApi clientApi = new SonarQubeClientApi("https://sonarcloud.io", "fs65df4as6f4sa1scds56a4fs");
```

### Initialization of service specific API
`SonarQubeClientApi` provides a set of service specific APIs such as `ProjectsApi`, `IssuesApi` or `QualityGatesApi`.

```java
ProjectsApi projectsApi = clientApi.getProjectsApi();
```

### Initialization of task specific API
Each of service APIs provides a set of task specific Services such as `ProjectsCreateService`, `IssuesSearchService` or `QualitGatesProjectStatusService`.
```java
ProjectsCreateService projectsCreateService = projectsApi.create()
```

### Using task specific API
Most of the Services require parameters for their REST calls such as project key, user name, issue type etc.

**Example usage**
```java
SonarQubeClientApi clientApi = new SonarQubeClientApi("https://sonarcloud.io", "admin", "admin"); // initializing SonarQube Client API
ProjectCreateModel pcm = clientApi.getProjectsApi() // getting Projects API
						.create() // getting Create Project service API
						.name("Test Project") // setting name of the project
						.project("TEST1") // setting key of the project
						.execute(); // executing the call
// Executing the call returns ProjectCreateModel which includes all data received from the call.
System.out.println("Project created. name: " + pcm.getProject().getName() + ", key: " + pcm.getProject().getKey());
```
### SonarQube Exception
In case the call to SonarQube instance ends with failing status code (4xx, 5xx) SonarQubeException is thrown together with the message describing the problem.

## Contribution
### Library
Contributing to standard library follows standard workflow. Create feature/bugfix branch, implement, create pull request with me as a reviewer and merge after approval :-)
### Testing
The library is tested manually at this point. If you are interested in implementing any kind of testing, unit testing, integration testing, end-to-end testing, potentially including some virtualization you are welcome to do so. Please follow the same workflow as for any work on library itself.
