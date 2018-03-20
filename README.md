# Spring-Boot Camel XML QuickStart

This example demonstrates how to configure Camel routes in Spring Boot via
a Spring XML configuration file.

The application utilizes the Spring [`@ImportResource`](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/ImportResource.html) annotation to load a Camel Context definition via a [camel-context.xml](src/main/resources/spring/camel-context.xml) file on the classpath.

IMPORTANT: This quickstart can run in 2 modes: standalone on your machine and on your Single-node OpenShift Cluster 

### Building

The example can be built with

    mvn clean install

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

If you have a single-node OpenShift cluster, such as Minishift or the Red Hat Container Development Kit, link:http://appdev.openshift.io/docs/minishift-installation.html[installed and running], you can also deploy your booster there. A single-node OpenShift cluster provides you with access to a cloud environment that is similar to a production environment.

To deploy your booster to a running single-node OpenShift cluster:

Log in and create your project:

    oc login -u developer -p developer
    oc new-project MY_PROJECT_NAME

Import base images in your newly created project (MY_PROJECT_NAME):

    oc import-image fis-java-openshift:2.0 --from=registry.access.redhat.com/jboss-fuse-6/fis-java-openshift:2.0 --confirm

Unzip, build and deploy your booster:

    mvn clean -DskipTests fabric8:deploy -Popenshift -Dfabric8.generator.fromMode=istag -Dfabric8.generator.from=MY_PROJECT_NAME/fis-java-openshift:2.0
