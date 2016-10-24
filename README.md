# Spring-Boot Camel XML QuickStart

This example demonstrates how to configure Camel routes in Spring Boot via
a Spring XML configuration file.

The application utilizes the Spring [`@ImportResource`](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html) annotation to load a Camel Context definition via a [camel-context.xml](src/main/resources/spring/camel-context.xml) file on the classpath.

### Building

The example can be built with

    mvn clean install


### Running the example locally

The example can be run locally using the following Maven goal:

    mvn spring-boot:run


### Running the example on Kubernetes

It is assumed a running Kubernetes platform is already running. If not you can find details how to [get started](http://fabric8.io/guide/getStarted/index.html).

Assuming your current shell is connected to Kubernetes or OpenShift so that you can type a command like

```
kubectl get pods
```

or for OpenShift

```
oc get pods
```

Then the following command will package your app and run it on Kubernetes:

```
mvn fabric8:run
```

To list all the running pods:

    oc get pods

Then find the name of the pod that runs this quickstart, and output the logs from the running pods with:

    oc logs <name of pod>

You can also use the [fabric8 developer console](http://fabric8.io/guide/console.html) to manage the running pods, and view logs and much more.


### More details

You can find more details about running this [quickstart](http://fabric8.io/guide/quickstarts/running.html) on the website. This also includes instructions how to change the Docker image user and registry.
