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
        url: "/loginAdmin",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "Accesso effettuato"
                
            $('#feedbackLog').html(json);
            
           
            setTimeout("pageRedirect()", 10000);
            window.location.replace("/insertFilm.html");
            
            
            console.log("SUCCESS : ", data);
            $("#login").prop("disabled", false);

        },
        error: function (e) {

            var json = 
                "Admin non valido, controllare username e password"
            $('#feedbackLog').html(json);

            console.log("ERROR : ", e);
            $("#login").prop("disabled", false);

        }
    });

}
