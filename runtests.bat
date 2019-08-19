java -Dbrowser=%1 -Denv=dev -jar .\target\demoselenide-0.0.1-jar-with-dependencies.jar --threads 2 classpath:features --glue steps --plugin json:cucumber.json --tags @%1
