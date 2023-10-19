let dashboard = "http://localhost:8083/Back_End_war/";

/* ============ Car Count ================*/
$("#carCount").val("00");
$.ajax({
    url: dashboard + "car/carCount",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.count;
        $("#carCount").text(num);

    },
    error: function (ob, statusText, error) {

    }
});