# Demo project to show simple cucumber scenario with java code
  
Subjects which are covered in this demo project:
- Basic concept of feature and scenario by wallet feature
- PageObjects, with wait functions until page is loaded and actions are done 
- Running scenario's in parallel by using multiple threads
- Running scenario's in a thread-safe way
- Building a complete artifact (jar file) for running tests from commandline with java
- Running scenario's from commandline with java, parametrized by browser and environment
- Filtering scenario's, by browser
- Creating a json file with test output, which can be used for reporting
- Screenshot is added to report in case of failure in scenario


http://automationpractice.com is used as test website for this
#
Features and scenarios can be started from your IDE and from commandline

Running from commandline:

- Parameters needed to start feature/scenario, by -D option:
   - browser=<chrome, ie or phantomjs>
   - env=<dev> (optional, dev=default; currently only environment)

- See buildjar.bat for building a complete jar file, which can be used for running the tests

- See runtests.bat how tests can be started using the complete jar file, including multi-threads and filtering by tags
  E.g. 'runtests chrome'