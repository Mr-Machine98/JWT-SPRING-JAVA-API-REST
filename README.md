## Construyendo una API REST con Java Spring Usando Spring Security
<br/><br/>
![JWT](https://www.vaadata.com/blog/wp-content/uploads/2016/12/JWT_tokens_EN.png)
<br/><br/>
### Tecnologías Usadas:

<div style="text-align:center">
    <img src="https://upload.wikimedia.org/wikipedia/commons/4/44/Spring_Framework_Logo_2018.svg" alt="Spring Framework" width="100" height="100" style="margin-right: 30px">
    <img src="https://upload.wikimedia.org/wikipedia/commons/2/29/Postgresql_elephant.svg" alt="PostgreSQL" width="100" height="100" style="margin-right: 30px">
    <img src="https://user-images.githubusercontent.com/74254687/236692714-d73a9823-a6c2-44df-aa4d-8910ea5be2aa.png" alt="JavaScript" width="100" height="100">
 <img src="https://seeklogo.com/images/J/jwt-io-json-web-token-logo-40E02494CD-seeklogo.com.png" alt="JWT" width="100" height="100">
</div>



<br/>


Este proyecto es básicamente una `API REST` con seguridad utilizando `Jason Web Token`, hecho en `Spring Java`. En las carpetas del proyecto se encuentra un archivo [JavaScript](https://github.com/Mr-Machine98/JWT-SPRING-JAVA-API-REST/blob/main/src/main/resources/templates/js/TestJsApiRest.js) que se utiliza para probar la API usando `FETCH`. Para usar `FETCH` y este archivo de JavaScript es necesario que instales [Node.js](https://nodejs.org/es), las tecnologías utilizadas fueron:



- Java con Spring
- Spring Security con JWT
- PostgreSql
- JavaScript




<br/>



> Nota
>
>Puedes instalar **Node.js** para ejecutar el archivo [JavaScript](https://github.com/Mr-Machine98/JWT-SPRING-JAVA-API-REST/blob/main/src/main/resources/templates/js/TestJsApiRest.js) y visualizar la respuesta de la API, o simplemente puedes utilizar `POSTMAN`.
 
 <br/>
 <hr/>
 
 ### Explicación del archivo JS
 
 El primer paso es logearnos, necesitamos mandar un objeto `JSON` para que la `API` nos entregue un `TOKEN`:
 ```javascript
 let login = {
    email: "mr.machineman98@gmail.com",
    password: "123"
};
 ```
 Así mismo, mandamos la información indicando el contenido que vamos a mandar con los `HEADERS` y esperamos la respuesta:

 ```javascript
// headers
let headers = {
    'Content-Type': 'application/json'
};

// get token
let res = await sendData(`${URL_API}/login`, login, headers, "POST");
let token = [...res.headers][0][1];
console.log(`Token -> ${token} \n`);
// Output Example: 
// Token -> Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtci5tYWNoaW5lbWFuOThAZ21haWwuY29tIiwiZXhwIjoxNjgzNDg0NjA2LCJub21icmUiOiJKdWFuIENhbWlsbyBNYW1pYW4gUnVpeiJ9.ZnJzdi5vzucqPs8QOnZrFWAiPCTCoSvJaz9JEQ0OM1-IwWnexsZItjgobG84G6RaZZKKvtVJhYODD3vWLG6cjA 

 ```
 
 
