This is an example of a SpringBoot GraphQL API, configured via gradle, secured by an IDP (tested via Keycloak).
cd
It also simplifies the building process of a Docker container image, and can also dispatch a running container.

The following are usage instructions:


1 - If you do previously hold a certificate, extract a JKS for that, otherwise:

* Run keytool_cert_create.sh to create the self-signed jks and X509 certificate
* Keep the alias and password handy

2 - Create an OpenID Connect client entry under any IDP realm

* Use with Confidential setting and keep the created *secret* handy
* Create settings according to the following image:
* ![Client openid and confidential settings](/images/client.png =200x)

3 - Run a command to create a Docker network - this will allow connectivity from the api to db and redis hosts

* docker network create apisamplenw

4 - Run commands to create a mysql container

* sudo docker pull mysql/sqlserver:5.7.22
* sudo docker run --net=apisamplenw --name mysqldb -p 3306:3306 -d mysql/mysql-server:5.7.22

5 - Enter mysql container shell (docker exec -it .. sh) and run docker_run_db.sh

6 - Launch redis service(s) - as in docker_run_redis.sh

7 - Update src/main/resources/application.yml

* Under ssl, set the keystore attributes based on step 1
* Under key-manager, set the classpath, store-pass and alias based on the keystore above
* Set entity id and secret based on the realm and client id from step 2
* Set mysql attributes as per step 5
* Set redis attributes according to step 6

8 - Add certificates information

* Copy into src/main/resources/certs/ : the jks from step 1, and the keycloak truststore jks
* The IDP certificate can be obtained via the following command line:
    * openssl s_client -connect idp_host_name:idp_port -showcert
    * Crop the content between ---BEGIN CERTIFICATE--- and ---END CERTIFICATE---
    * And paste in a new file (idp.crt)

* Further we create the jks
    * keytool -storetype JKS -import -trustcacerts -file yourIDP.crt -alias server -keystore idptruststore.jks -storepass truststorepass

* And check IDP settings
    *  E.g. for Keycloak, check https://www.keycloak.org/docs/latest/server_installation/#enabling-ssl-https-for-the-keycloak-server

9 - Update Dockerfile with keycloak client jks configuration

* Set the build process to include it in the new container image
* Set the Java Options attributes related to the truststore settings:
    *  Path and jks name
    *  Certificate type
    *  Jks password



10 - Run reload.sh script to trigger build and initiate a container

For valitation:
Edit and run keytool_cert_create.sh, which will dispatch a request to keycloak for an access token and call the API with the obtained access token

