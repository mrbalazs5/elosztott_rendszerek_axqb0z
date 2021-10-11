Apache Kafka környezet Docker-ben. kafka-docker mappában található 
docker-compose.yml fájlban egy zookeeper és egy kafka service található.
Ezekből készül utána 1-1 container, melynek portjai külsőleg is elérhetők
lesznek.

Futtatás:

cd kafka-docker && docker-compose up
