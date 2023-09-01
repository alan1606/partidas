spring:
  cloud:
    gateway:      globalcors:        corsConfigurations:
          '[/**]':
            allowedOrigins: 
              - 'http://localhost:4200'
              - '*'
            allowedHeaders: 
              - Content-Type
            allowedMethods:
              - GET
              - POST
              - PUT
              - DELETE

server:
  port: 8090
#  http.port: 8080
 # ssl:
  #  key-store: src/main/resources/ssl/springboot_letsencrypt.p12 
   # key-store-password: password99
    #keyStoreType: PKCS12
    #keyAlias: bootalias
    
springdoc:
  swagger-ui:
    operationsSorter: method