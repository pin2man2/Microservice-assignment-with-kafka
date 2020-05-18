# Microservice-assignment-with-kafka
Implementting kafka as message queue server
# microservice-assignment-with-jwt
public url :-https://github.com/pin2man2/microservice-assignment-with-jwt.git

Service name				Port
------------			    -----
assignment-naming-server    8761
authorization-service       9090
user-profile-service		8100

1)1st you need to authenticate by calling api: 
POST  http://localhost:9090/login 
input json:-
----------
{
"userName":"ranjan",
"password":"password"
}
Note:- username  and password are manualy insert into DB{already present in the code and value gets populated with given username "ranjan" and password "password"}
output
------
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyayIsImV4cCI6MTU4OTIxMTA5NCwiaWF0IjoxNTg5MTkzMDk0fQ.3Y3165zg2yGNYpb6DO78akbIFa4kTryuI5gchH1bRB1xM5vB7FXWcCeFleHbbgp4hSwcgfXXyNVjqb_22_yxkQ"
}

2)After authtication add it in Header of each secured request like key is your "Authentication" and value is your "<token>"  getting as response of /login api 

3) create Profile:-
 
 POST  http://localhost:9090/assigment/user-profile-service
input json:
{
	"phone":8725720022,
	"address":"Pune"
}
4) update Profile:-
PUT  http://localhost:9090/assigment/profile/update
{
	"id":2,
	"address":"Maharastra"
}
5) delete Profile:-
DELETE  http://localhost:9090/assigment/profile/1



 
