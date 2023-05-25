const register = () => {
    let content = null;
    content =`<div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box">
    <div class="featured-image mb-3">
       <img src="assets/img/Eatsmart.png">
        <h3>Willkommen bei</h3>
       <h1 style="color: #D01542">EatSmart</h1>
        <p style="color: #A3C12B;">The Smarter Way to Eat</p>
   </div>
   </div> 
<div class="col-md-6 right-box" >
 <div class="row align-items-center">
       <div class="header-text mb-4">
            <h2>Register</h2>
       </div>
       <div class="input-group mb-3">
           <input type="text" class="form-control form-control-lg bg-light fs-6" placeholder="Enter Username" >
       </div>
       <div class="input-group mb-3">
           <input type="text" class="form-control form-control-lg bg-light fs-6" placeholder="Enter Email">
       </div>
       <div class="input-group mb-1">
           <input type="password" class="form-control form-control-lg bg-light fs-6" placeholder="Enter Password">
       </div>
       <div class="input-group mb-5 d-flex justify-content-between">
       </div>
       <div class="input-group mb-3">
               <a class="btn btn-lg w-100 fs-6"
           style="border: 2px solid;
           border-image: linear-gradient(45deg,#D01542, #A3C12B) 10;" href="register_address.html">
           Continue</a>
       </div>
       <div class="row">
           <small>Haben Sie schon einen Account? <a href="login.html">Log In</a></small>
       </div>
       <div class="row">
           <p style="text-align: center;">Or connect with Social Media</p>
           <div class="column" style="margin: auto;text-align: center;">
               <a href="#" class="bi bi-instagram"></a>
               <a href="#" class="bi bi-facebook"></a>
           </div>
       </div>
 </div>
</div>`;

    document.getElementById("differentregister").innerHTML = content;
}