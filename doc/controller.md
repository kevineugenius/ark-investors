### Controllers

The controllers, which house Spring endpoints, are all located in the `controllers` directory/package. Each endpoint has been kept as minimal as possible, offloading work to the appropriate service.

To access an endpoint, the url may be constructed by `server base` + `Spring base` + `controller context` + `endpoint path`.  The `base` is the server address plus whatever is set in `application.properties`, if any. Individual controllers may also have a path applied but it is not required -- all controllers in this app should have their base path supplied.

For example: `localhost:8080` + `/api/v1` + `/investor` + `/add` will access `InvestorController.addInvestor()` if it is a `POST` request.

Further, curl may be used to target these endpoints:

`curl -X POST http://localhost:8080/api/v1/investor/add -H "Content-Type: application/json" -d '{"createdBy":2,"name":"New Investor"}'`

`curl -X POST http://localhost:8080/api/v1/client/add -H "Content-Type: application/json" -d '{"name":"Clive Client"}'`

`curl -X POST http://localhost:8080/api/v1/transaction/add -H "Content-Type: application/json" -d '{"investorId":1,"fundId":1,"type":1,"amount":40.25}'`
