#!/bin/bash
docker stop oidc-api
docker rm oidc-api
docker rmi -f luis/oidc-api:1.0
export group=luis
export name=oidc-api
export calculatedVersion=1.0

./gradlew build buildDocker
#sudo docker system prune
docker run --name oidc-api -d -p 8974:8999 --network=apisamplenw -e "TZ=America/Sao_Paulo"  luis/oidc-api:1.0
docker logs -f oidc-api

