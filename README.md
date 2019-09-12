# Cassandra-notes
Cassandra is a distributed database management system designed for handling a high volume of structured data across commodity servers.

Cassandra’s design criteria:

  - Distributed: Runs on more than one server node.
  - Scale linearly: By adding nodes, not more hardware on existing nodes.
  - Work globally: A cluster may be geographically distributed.
  - Favor writes over reads: Writes are an order of magnitude faster than reads.
  - Democratic peer to peer architecture: No master/slave.
  - Favor partition tolerance and availability over consistency: Eventually consistent (see the CAP theorem: [Here](https://en.wikipedia.org/wiki/CAP_theorem.))
  - Support fast targeted reads by primary key: Focus on primary key reads alternative paths are very sub-optimal.
  - Support data with a defined lifetime: All data in a Cassandra database has a defined lifetime no need to delete it after the lifetime expires the data goes away.

Ideal Cassandra Use Cases:

  - The ideal Cassandra application has the following characteristics:

    - Writes exceed reads by a large margin.
    - Data is rarely updated and when updates are made they are idempotent.
    - Read Access is by a known primary key.
    - Data can be partitioned via a key that allows the database to be spread evenly across multiple nodes.
    - There is no need for joins or aggregates.

  - Some of my favorite examples of good use cases for Cassandra are:

    - Transaction logging: Purchases, test scores, movies watched and movie latest location.
    - Storing time series data (as long as you do your own aggregates).
    - Tracking pretty much anything including order status, packages etc.
    - Storing health tracker data.
    - Weather service history.
    - Internet of things status and event history.
    - Telematics: IOT for cars and trucks.
    - Email envelopes—not the contents.
    
# Reference 
https://blog.pythian.com/cassandra-use-cases/
