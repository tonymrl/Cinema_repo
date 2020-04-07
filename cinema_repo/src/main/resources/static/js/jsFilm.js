$(document).ready(function () {

    $("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        insert();

    });

});

function insert() {

    var search = {}
    search["id"] = $("#id").val();
    search["titolo"] = $("#titolo").val();
    search["genere"] = $("#genere").val();
    search["trama"] = $("#trama").val();
    search["durata"] = $("#durata").val();
    search["regista"] = $("#regista").val();

  
    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/insertFilm",
        data: JSON.stringify(search),
      //  dataType: 'string',
        cache: false,
        timeout: 600000,

        success: function (data) {

           
                
            $('#feedback').text("Film inserito correttamente");

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

           
                
            $('#feedback').text("ERRORE: controlla console log");

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}
