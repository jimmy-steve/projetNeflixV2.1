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
