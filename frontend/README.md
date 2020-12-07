# Frontend
SPA consuming backend API.
Backend model and client are generated from swagger contract.

### Start
You can use following approaches to start the app:
* `ng serve` from current folder
* `docker-compose up frontend` from the repository root

### Generate the API client
After changing the backend model, you have to regenerate the API client.
To do that, run in the current folder:
```shell
projects/fizzbuzz-client/generate.sh
ng build fizzbuzz-client
```
Backend service should be started.
