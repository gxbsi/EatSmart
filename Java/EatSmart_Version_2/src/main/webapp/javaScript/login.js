let _jwtToken;

const login = () => {
    let email = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    const url = './api/login';
    const initparams = {
        username: email,
        password: password
    };
    const init = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(initparams)
    };
    fetch(url, init)
        .then(res => {
            if (!res.ok) {
                throw new Error("Authentication failed. HTTP-ERROR: " + res.status);
            }
            _jwtToken = res.headers.get("Authorization");
            console.log(_jwtToken);
            return res.json()
        }).then(data => {

    }).catch(err => {
        console.log(err);
        alert(err);
    });
}