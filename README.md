## The Spring Boot application provides an example API that consumes and produces protobuf messages.

### Curl PUT message type protobuf.
```
curl -X PUT -H "Content-Type: application/x-protobuf" \
--data-binary @example_file/request.bin http://localhost:8080/my-controller/user
```

### Curl GET message type protobuf.
```
curl -X GET -H "Accept: application/x-protobuf" http://localhost:8080/my-controller/user \
--output example_file/response.bin
```

### NOTE
Please run before start service
```mvn clean compile```
