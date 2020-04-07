$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});



function fire_ajax_submit() {

    var search = {}
    search["username"] = $("#username").val();
    search["password"] = $("#password").val();

    $("#login").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/login",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "Accesso effettuato"
                
            $('#feedbackLog').html(json);
            
           
            window.location.replace("/areaUtente.html");
            setTimeout("pageRedirect()", 10000);
            
            
            console.log("SUCCESS : ", data);
            $("#login").prop("disabled", false);

        },
        error: function (e) {

            var json = 
                "Utente non valido"
            $('#feedbackLog').html(json);

            console.log("ERROR : ", e);
            $("#login").prop("disabled", false);

        }
    });

}
