$(document).ready(function () {

    $("#logout").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function logout() {

    $("#logout").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/logout",
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "Exit..."
         
            $('#feedback').html(json);

            window.location.replace("/index.html");
            console.log("SUCCESS : ", data);
            $("#logout").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#logout").prop("disabled", false);

        }
    });

}
