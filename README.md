# JwissDK (JwissDevKit)

JwissDK (JwissDevKit) is a Java library designed to facilitate the integration of JwissTool with addons and plugins. This prototype library provides essential tools and interfaces for developers to extend and enhance the JwissTool application.

## Overview

JwissDK aims to streamline the process of integrating custom addons and plugins into JwissTool. By offering a set of predefined interfaces and utilities, JwissDK helps developers create and manage addons and plugins that seamlessly interact with the JwissTool ecosystem.

## Features

- **Addon Integration**: Provides a framework for creating and managing addons that can extend JwissTool's functionality.
- **Plugin Management**: Facilitates the loading and handling of plugins within the JwissTool application.
- **Flexible Architecture**: Designed to be easily integrated and customized according to specific project needs.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven (for building the project)

### Installation

1. **Clone the Repository**

   ```
   git clone https://github.com/yourusername/jwissdk.git
   cd jwissdk
   ```

2. **Build the Project**

   Ensure you have Maven installed, then build the project with:

   ```
   mvn clean install
   ```

   This will compile the project and package it into a JAR file.

3. **Integrate with JwissTool**

   Add JwissDK as a dependency in your JwissTool project. In your JwissTool `pom.xml`, include:

   ```xml
		<dependency>
			<groupId>com.digitalfen</groupId>
			<artifactId>jwissdevkit</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency>
   ```
