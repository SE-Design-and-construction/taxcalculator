## Tax calculator example  

A simple tax calculator using the updated [IRD brackets](https://www.ird.govt.nz/pages/campaigns/personal-income-tax-threshold-changes)




To run, `mvn clean install`

To run tests only,  `mvn test`


To run Docker: 
1. first build the docker image `docker build -t [image name] .`
2. then run the image in a container ` docker run -p [port number] -d [image name]`