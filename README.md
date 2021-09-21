# PriceMe APP
The price me app was created with [`aws-serverless-java-container`](https://github.com/awslabs/aws-serverless-java-container).


The project defines an api `/price` resource that can accept `POST` requests with its tests.

## Pre-requisites
* [AWS CLI](https://aws.amazon.com/cli/)
* [Serverles](https://www.serverless.com/)
* Install ---  npm install -g serverless)
* [Maven](https://maven.apache.org/)

## Clone the project

## Building the project
You can use the Maven to quickly build the project
$ cd priceme

$ mvn  package


[INFO] ------------< com.equihealth:spring-lambda-serverless-api >-------------
[INFO] Building priceme 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ spring-lambda-serverless-api ---
[INFO] Deleting /Users/ganeshsahu/Desktop/Lambda/springboot/serverless-examples/spring-lambda-serverless-api/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS


### Deploying the project
COMMAND -- sls deploy -v

--------- *****  Deployment output *** -------
endpoints:
  POST - https://4mjxomubfl.execute-api.us-east-1.amazonaws.com/dev/price
functions:
  pricemeapi: price-api-v1-dev-pricemeapi
  priceme: price-api-v1-dev-priceme
  


###  Testing Command line Execution

COMMAND -- serverless invoke -f priceme -d 'lemon 53 405'

OUTPUT -- "[IN  22060.100000000002 |54.42*405+20.0, HN  21999.2 |54.24*405+32.0]"


###  Rest End Point testing
curl -H "Content-Type: application/json" -X POST -d '{"commodityName":"lemon","pricePerTon":"53","volumeInTons":"45"}' https://4mjxomubfl.execute-api.us-east-1.amazonaws.com/dev/price

OUTPUT -- "[IN  22060.100000000002 |54.42*405+20.0, HN  21999.2 |54.24*405+32.0]"


