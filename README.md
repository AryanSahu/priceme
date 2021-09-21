# PriceMe APP
The price me app was created with [`aws-serverless-java-container`](https://github.com/awslabs/aws-serverless-java-container).


The project defines an api `/price` resource that can accept `POST` requests with its tests.

## Pre-requisites
* [AWS CLI](https://aws.amazon.com/cli/)
* [Serverles](https://www.serverless.com/)
* Install ---  npm install -g serverless)
* [Maven](https://maven.apache.org/)


## Cloning and building the project
You can use the Maven to quickly build the project

$ cd priceme

$ mvn  package


### Deploying the project
COMMAND -- sls deploy -v

###  Testing Command line Execution

COMMAND -- serverless invoke -f priceme -d 'lemon 53 405'

OUTPUT -- "[IN  22060.100000000002 |54.42*405+20.0, HN  21999.2 |54.24*405+32.0]"


###  Rest End Point testing
curl -H "Content-Type: application/json" -X POST -d '{"commodityName":"lemon","pricePerTon":"53","volumeInTons":"45"}' https://4mjxomubfl.execute-api.us-east-1.amazonaws.com/dev/price

OUTPUT -- "[IN  22060.100000000002 |54.42*405+20.0, HN  21999.2 |54.24*405+32.0]"


