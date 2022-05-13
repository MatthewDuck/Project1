Coverage: 80.4%
# Project Title

Program to manage customer, orders, items and their relationships. Uses java and SQL databases.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Requires Java and MYSQL unless using the fatjar which includes all dependencies and only requires Java.


### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

*Each class has its own set of tests, with each type of class having a different type of test.
*Domains have a single simple test to check they contains a toString and hashCode method.
*Controllers have tests to check every method works and interacts properly with its correcponding method in the DAO. They do this by using Mockito to get around generating Objects. 
*DAOs have test to check that each method and interacts with SQL correctly. These tests will need to be changed if more data is put into the tables using the test sqldata file.




## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Matthew Duck** - *Further Implementation*

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone Chris Perrins for the initial work and Pawel Stypulkowski for helping me on a few issues that I got stuck on.*
* Jira Link:https://matthewdduck.atlassian.net/jira/software/projects/P1/boards/2/roadmap*
