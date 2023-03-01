© transperfect-store


#### 1. RUN mvn clean install
#### 2. Run the project as spring boot one
#### 3. An H2 database will start in parallel with a embedded tomcat. and a Flyway script will initialise the database
#### 4. The endpoint to be tested is : 

###### 4.1: if the order doesn't exist: for examle if you hit PUT /orders/9999/status, you will get a 404 Not Found Exception with 
```json  
  {
    "logRef": "BusinessException",
    "message": "Order with Id 999 is not found"
  }
  ```
  
###### 4.2: When you hit an existing order, for example : /orders/2/status, you will get a 200 response:
  ```json  
  {
    "id": 2,
    "reference": "ORDER 2",
    "items": [
        {
            "itemId": 3,
            "itemPrice": 31.8,
            "orderId": 2,
            "quantity": 5,
            "price": 159.0
        },
        {
            "itemId": 4,
            "itemPrice": 11.6,
            "orderId": 2,
            "quantity": 10,
            "price": 116.0
        }
    ],
    "amount": 275.0
}
  ```
and an email is gonna be sent in asynchonous mode, telling that the status has been updated successfully


NB: you should start a fake SMTP server to get the email.


