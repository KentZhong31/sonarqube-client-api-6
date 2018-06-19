# SonarQube client API models
Provides JSON models for transforming of JSON to Java objects via GSON.

## Common
Models that are common for multiple SonarQube REST API endpoints are defined in the root of this package.

## Structure
SonarQube REST API endpoint specific models are defined in their own packages. The package always includes class representing the root model of JSON returned by SonarQube.

### Example
| SonarQube REST API	| Package | Root Model Class |
| ------------- |-------------|-------------|
| /users/groups/group	| users.groups | UsersGroupsModel |
| /project/search      | project.search | ProjectSearchModel |