function desactiveAbbonnement() {
    //get the select
    var choice = document.getElementById('typeAbonnementNew');
    // Get the checkbox
    var checkBox = document.getElementById("admin");

    // If the checkbox is checked, disabled true
    if (checkBox.checked == true){
        choice.disabled=true;
    } else {
        choice.disabled=false;
    }
}

function verifiedPassword() {
    const password = document.querySelector('input[name=passWordNew]');
    const confirm = document.querySelector('input[name=confirmPassword]');
    const messageValidation = document.getElementById("messageValidation");
    const btnSignIn = document.getElementById("btnSignIn");

    if (confirm.value === password.value) {
        console.log("valide")
        messageValidation.style.color = "green";
        messageValidation.style.border = "1px solid green"
        messageValidation.innerHTML="Password valide";
        btnSignIn.removeAttribute("disabled")
    } else {
        console.log("Non valide")
        messageValidation.style.color = "red";
        messageValidation.style.border = "1px solid red"
        messageValidation.innerHTML ="Password Invalide"
        btnSignIn.setAttribute("disabled", disabled);
    }
}


