# Spring-Boot Camel XML QuickStart

This example demonstrates how to configure Camel routes in Spring Boot via
a Spring XML configuration file.

The application utilizes the Spring [`@ImportResource`](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html) annotation to load a Camel Context definition via a [camel-context.xml](src/main/resources/spring/camel-context.xml) file on the classpath.

IMPORTANT: This quickstart can run in 2 modes: standalone on your machine and on your Single-node OpenShift Cluster 

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


#### Integration Testing

The example includes a [fabric8 arquillian](https://github.com/fabric8io/fabric8/tree/master/components/fabric8-arquillian) Kubernetes Integration Test. 
Once the container image has been built and deployed in Kubernetes, the integration test can be run with:

	mvn test -Dtest=*KT

The test is disabled by default and has to be enabled using `-Dtest`. [Integration Testing](https://fabric8.io/guide/testing.html) and [Fabric8 Arquillian Extension](https://fabric8.io/guide/arquillian.html) provide more information on writing full fledged black box integration tests for Kubernetes. 

### More details

You can find more details about running this [quickstart](http://fabric8.io/guide/quickstarts/running.html) on the website. This also includes instructions how to change the Docker image user and registry.

### Running the Quickstart standalone on your machine

You can also run this booster as a standalone project directly:

Obtain the project and enter the project's directory
Build the project:

    mvn clean package
    mvn spring-boot:run 

### Running the Quickstart on a Single-node OpenShift Cluster

All commands below requires one of these:
- be logged in to the targeted OpenShift instance (using oc login command line tool for instance)
- configure properties to specify to which OpenShift instance it should connect

If you have a single-node OpenShift cluster, such as Minishift or the Red Hat Container Development Kit, [installed and running](http://appdev.openshift.io/docs/minishift-installation.html), you can also deploy your quickstart there. A single-node OpenShift cluster provides you with access to a cloud environment that is similar to a production environment.

To deploy your booster to a running single-node OpenShift cluster:

Log in and create your project:

    oc login -u developer -p developer
    oc new-project MY_PROJECT_NAME

Import base images in your newly created project (MY_PROJECT_NAME):

    oc import-image fis-java-openshift:2.0 --from=registry.access.redhat.com/jboss-fuse-6/fis-java-openshift:2.0 --confirm

Unzip, build and deploy your booster:

    mvn clean -DskipTests fabric8:deploy -Popenshift -Dfabric8.generator.fromMode=istag -Dfabric8.generator.from=MY_PROJECT_NAME/fis-java-openshift:2.0
