# [ParcelPath: An globla package tracking Application](https://github.com/Michaelyangzhaohua/Springboot-parcelPath "ParcelPath: An globla package tracking Application")

## Introduction
The project is a back-end application for package tracking called &quot;Parcel Path&quot;.
This applcation allows customers to add the package number into the system so that the system can start to receive the package information. 
The system should keep monitor the status and the update of the package. The Application using TrackingMore or EasyPost tracking API. Some tracking API may have update notification feature.
I have test for that. Since the tracking API is not free, we using RabbitMQ to simulate the process.
The application store the information into the database and push the SMS message to the user when the system get the update of the package.



## Frameworks & Tools
- [Spring Boot](https://spring.io/projects/spring-boot "Spring Boot"): an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.
- [Redis](https://redis.io/ "Redis"): an in-memory data structure project implementing a distributed, in-memory key–value database with optional durability. Redis supports different kinds of abstract data structures, such as strings, lists, maps, sets, sorted sets, HyperLogLogs, bitmaps, streams, and spatial indexes.
- [MySQL](https://www.mysql.com/ "MySQL"): an open-source relational database management system (RDBMS).
- [Lombok](https://projectlombok.org/ "Lombok"): a java library that automatically plugs into your editor and build tools, spicing up your java.
- [Mybatis](https://mybatis.org/mybatis-3/ "Mybatis"): a first class persistence framework with support for custom SQL, stored procedures and advanced mappings.
- [RabbitMQ](https://www.rabbitmq.com/ "RabbitMQ"): an open-source message-broker software (sometimes called message-oriented middleware) that originally implemented the Advanced Message Queuing Protocol (AMQP) and has since been extended with a plug-in architecture to support Streaming Text Oriented Messaging Protocol (STOMP), MQ Telemetry Transport (MQTT), and other protocols.


