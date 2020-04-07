$(document).ready(function () {

    $("#all").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});




function fire_ajax_submit() {

   
    

    $("#all").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/allProiezione",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (res) {

        

           var json = JSON.stringify(res, null, 4);
           $('#feedback').html(json);


            console.log("SUCCESS : ", res);
            $("#all").prop("disabled", false);

        //////////////////////////////////////////

    

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#all").prop("disabled", false);

        }
    });
    
  
 

      
    }
 


  