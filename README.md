# REST API - Payment Example
It is an API exercise that can be used to add and search purchasing records.
## Tech Stack
Java, Spring Boot, Maven and H2 Database.
## How to Run the Application
### Download Image from Dockerhub
1. Run "docker pull ejwang150/payment-image:1.1"
2. Run "docker run -itd -p 80:8080 ejwang150/payment-image:1.1"
#### Add a Payment Record
1. Send Payment data in the following JSON format.
'''json
{
	"userId": 1,
    "itemId": "CO0001",
    "amount": 5,
    "total": 3.5
}
'''
2. Run http://localhost:80/pay in POST method on Postman.
3. You Should receive a response in the following format.
'''json
{
	"status": "success",
    "code": 200,
    "uuid": "2515be7b-e652-45f3-9108-905b9b5dd9ee"
}
'''
#### Search a Record By UUID
1. Send Payment data in the following JSON format.
'''json
{
    "uuid": "2515be7b-e652-45f3-9108-905b9b5dd9ee"
}
'''
2. Run http://localhost:80/getPay in POST method on Postman.
3. You Should receive a response in the following format.
'''json
{
    "status": "success",
    "code": 200,
    "userId": 1,
    "itemId": "CO0001",
    "amount": 5,
    "total": 3.5
}
'''