generate:
	docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate -i /local/contract.yaml -g spring  --additional-properties=apiPackage=at.fhtw.swen3.controller.rest --additional-properties=modelPackage=at.fhtw.swen3.services.dto -o /local/springboot

project-gen:
	docker run --rm -v "${PWD}:/local" openapitools/openapi-generator-cli:latest-release generate -i https://raw.githubusercontent.com/swagger-api/swagger-petstore/master/src/main/resources/openapi.yaml -g spring -o /local/out/springboot 
