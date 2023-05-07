import fetch from "node-fetch";
const URL_API = "http://localhost:9000/market/api";

// fetch data
async function getData(URL) {
    const response = await fetch(URL);
    const data = response.json();
    return data;
}
// send data
async function sendData(URL, OBJ = undefined, HEADERS, METHOD) {
    const response = await fetch(URL, {
        method: METHOD,
        headers: HEADERS,
        body: JSON.stringify(OBJ)
    });
    return response;
}

// log in
let login = {
    email: "mr.machineman98@gmail.com",
    password: "123"
};
// headers
let headers = {
    'Content-Type': 'application/json'
};

// get token
let res = await sendData(`${URL_API}/login`, login, headers, "POST");
let token = [...res.headers][0][1];
console.log(`Token -> ${token} \n`);

// send token and get all products
headers.Authorization = token;
console.log("Headers to send -> ", headers,"\n");
res = await sendData(`${URL_API}/products/all`, undefined, headers, 'GET');
let allProducts = await res.json();

// produtcs
console.log("All products -> " , allProducts);

 










