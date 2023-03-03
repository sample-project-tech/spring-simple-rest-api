
# **Simple Spring Rest API** 🤓

Di Project ini akan mencontohkan CRUD Sederhana menggunakan REST API Spring boot. Disamping itu, akan dilanjutkan dengan cara implementasi JPA dan Manual Query menggunakan EntityManager.

## Requerement

```bash
  1.) jdk 11
  2.) mvn 3.6.3
  3.) mysql 5.7
  4.) spring-boot 2.7.7
```
## Installation

Instal dan Jalankan project:

```bash
  mvn spring-boot:run
```
    
## API Reference

#### Get All Customer by Entity Manager

```http
  GET /api/spring-simple-rest/customer/em/search?code=
```

| Parameter | Type     | Description                      |
| :-------- | :------- | :------------------------------- |
| `code`    | `string` | **Required= true**. code or name |

#### Get All Customer by JPA

```http
  GET /api/spring-simple-rest/customer/jpa/search?code=
```

| Parameter | Type     | Description                      |
| :-------- | :------- | :------------------------------- |
| `code`    | `string` | **Required= true**. code or name |
  
#### Get Customer 1 data

```http
  GET /api/spring-simple-rest/customer/data?code=abc
```

| Parameter | Type     | Description              |
| :-------- | :------- | :----------------------- |
| `code`    | `string` | **Required= true**. code | 

#### Delete Customer

```http
  DELETE /api/spring-simple-rest/customer/delete/{code}
```

| Parameter | Type     | Description              |
| :-------- | :------- | :----------------------- |
| `code`    | `string` | **Required= true**. code |

#### Save Customer

```http
  POST /api/spring-simple-rest/customer/save
  Body :
        {
            "code":"IMAM",
            "name":"Imam Solikhin",
            "phone":"08180817XXXX",
            "email":"imamsolikhin.tech@gmail.com",
            "address":"Indonesia"
        }
```

#### Update Customer

```http
  POST /api/spring-simple-rest/customer/save
  Body :
        {
            "code":"IMAM",
            "name":"Imam Solikhin",
            "phone":"08180817XXXX",
            "email":"imamsolikhin.tech@gmail.com",
            "address":"Indonesia"
        }
```

## Deployment

Cara menjalankan project `Simple Spring Rest API` dengan docker:

```bash
  docker build -t "spring_simple_rest" .
  docker run -i -d -p 8080:8080 --name="spring_simple_rest" "spring_simple_rest"
```


## Contributing

Kontribusi selalu diterima!

Kirim email `imamsolikhin.tech@gmail.com`, untuk title `KONTRIBUSI https://github.com/sample-project-tech/{nama-project}` dan lampirkan `screenshoot profile` anda.


## Authors

- [@imamsolikhin](https://github.com/imamsolikhin)
## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/sample-project-tech)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/imam-solikhin/)

