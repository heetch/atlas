# This is kafka Bridge

#Getting Started

## Run Kafka

Get yourself a kafka from : https://github.com/heetch/data-hub-pocs

```
docker-compose -f amundsen-atlas/docker-compose-kafka.yml up
```

## Local dev

expose ZK_CONNECT=localhost:2181

Run in IDE org.apache.atlas.kafka.bridge.KafkaBridge

