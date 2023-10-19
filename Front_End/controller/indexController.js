let carBaseUrl = "http://localhost:8083/Back_End_war/";

loadAllCars();

function loadAllCars() {
    $("#carSection").empty();
    $.ajax({
        url: carBaseUrl + "car/loadAllCars", method: "GET", dataType: "json", success: function (res) {
            console.log(res);
        }
    });
}