# This is kafka Bridge

# Getting Started

## Run Kafka

Get yourself a kafka from : https://github.com/heetch/data-hub-pocs

```
docker-compose -f amundsen-atlas/docker-compose-kafka.yml up
```

## Local dev

expose ZK_CONNECT=localhost:2181

Run in IDE org.apache.atlas.kafka.bridge.KafkaBridge

## Kafka metadata

[ZKClient ](https://www.javadoc.io/doc/org.apache.kafka/kafka_2.10/0.8.0/index.html#kafka.utils.ZkUtils$)

def getCluster(zkClient: ZkClient): Cluster

### Brokers

def getAllBrokersInCluster(zkClient: ZkClient): Seq[Broker]

def getBrokerInfo(zkClient: ZkClient, brokerId: Int): Option[Broker]


### Topcis

def getAllTopics(zkClient: ZkClient): Seq[String]

def getTopicPartitionLeaderAndIsrPath(topic: String, partitionId: Int): String

def getTopicPartitionPath(topic: String, partitionId: Int): String

def getTopicPartitionsPath(topic: String): String

def getTopicPath(topic: String): String

### Consumers

def getConsumersPerTopic(zkClient: ZkClient, group: String): Map[String, List[String]]

def getConsumerPartitionOwnerPath(group: String, topic: String, partition: Int): String

def getConsumersInGroup(zkClient: ZkClient, group: String): Seq[String]