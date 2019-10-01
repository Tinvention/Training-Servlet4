# Training-Servlet4
Training Servlet4 HelloWorld - Example

# Servlet4 HelloWorld
## deploy with maven
### To use with wildfly standalone 
* Start your server , set credentials and addresses in pom.xml
* $> mvn wildfly:deploy -Pstandalone OR  mvn wildfly:deploy

### To use with wildfly domain
* Start your domain servers , set credentials, server-group-name and addresses in pom.xml
* $> mvn wildfly:deploy -Pdomain

## Deploy using REST interface
### To use with wildfly standalone 
* Upload file 
*  $> Servlet4HelloWorld> curl --digest -u httpadmin:admin --form file=@target/Servlet4HelloWorld-0.1-SNAPSHOT.war  http://localhost:9990/management/add-content
   $> Servlet4HelloWorld> {"outcome":"success","result":{"BYTES_VALUE":"TaMlsSvW4ghA0zRFfFM1CoA2hwI="}}
* Deploy the content created by key
*  $> Servlet4HelloWorld> curl --digest -u httpadmin:admin -L --header "Content-Type: application/json" -d '{"content":[{"hash": {"BYTES_VALUE" : "TaMlsSvW4ghA0zRFfFM1CoA2hwI="}}], "address": [{"deployment":"Servlet4HelloWorld-0.1-SNAPSHOT.war"}], "operation":"add", "enabled":"true"}' http://localhost:9990/management
   Tips: on windows is suggested to use a REST client ( es. postman ) due to escaping issues in curl

### To use with wildfly domain 
* Add the deployment to the content repository
* $> Servlet4HelloWorld> curl --digest -u admin:admin --form file=@target/Servlet4HelloWorld-0.1-SNAPSHOT.war  http://localhost:9990/management/add-content

* Add the deployment to the desired server group and enable it ( deploy and start ).
$> Servlet4HelloWorld> curl --digest -L -D - http://localhost:9990/management/ --header "Content-Type: application/json" -u admin:admin -d '{
 "operation" : "add", 
 "address" : {"server-group" : "other-server-group","deployment":"Servlet4HelloWorld-0.1-SNAPSHOT.war"},
 "enabled":"true"
}'


Hint: sometimes wildfly seems not to see the uploaded content, also if the HTTP response contains "success". Using the web console to upload, solve the issue.

