let RentAllManageBaseUrl = "http://localhost:8083/Back_End_war/";
loadAllRentDetails();

/* ===== All Rent Details load ========= */
function loadAllRentDetails() {
    $("#rentAllDetails").empty();
    $("#retManage").empty();
    $.ajax({
        url: RentAllManageBaseUrl + "rent/loadAllRents",
        method: "get",
        contentType: "application/json",
        dataType: "json",
        async: true,
        success: function (res) {
            console.log(res.data)
            for (var i of res.data) {
                let row = "<tr><td>" + i.rentID + "</td><td>" + i.rentDetails.at().carID + "</td><td>" + i.regUser.user_Id + "</td><td>" + i.rentDetails.at().driverID + "</td><td>" + i.requestType + "</td><td>" + i.rentType + "</td><td>" + i.pickUpDate + "</td><td>" + i.pickUpTime + "</td><td>" + i.returnTime + "</td><td>" + i.returnDate + "</td><td>" + i.location + "</td></tr>";
                $("#rentAllDetails").append(row);
                $("#retManage").append(row);
                blindClickEventsRent();
            }
        }
    });
}

/* ========== Search Rents ========== */
$("#search_Id").on("keypress", function (event) {
    if (event.which === 13) {
        var search = $("#search_Id").val();
        $("#retManage").empty();
        $.ajax({
            url: RentAllManageBaseUrl + "rent/searchDtails?search_Id=" + search,
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (i) {
                console.log(i);
                console.log(i.rentID)
                let row = "<tr><td>" + i.rentID + "</td><td>" + i.rentDetails.at().carID + "</td><td>" + i.regUser.user_Id + "</td><td>" + i.rentDetails.at().driverID + "</td><td>" + i.requestType + "</td><td>" + i.rentType + "</td><td>" + i.pickUpDate + "</td><td>" + i.pickUpTime + "</td><td>" + i.returnTime + "</td><td>" + i.returnDate + "</td><td>" + i.location + "</td></tr>";
                $("#retManage").append(row);
                blindClickEventsRent();
            },
            error: function (error) {
                loadAllRentDetails();
                let message = JSON.parse(error.responseText).message;
                emptyMassage(message);
            }
        })
    }

});
let carID;

function blindClickEventsRent() {
    $("#retManage>tr").on("click", function () {
        let requestRentId = $(this).children().eq(0).text();
        let driverId = $(this).children().eq(3).text();
        let userID = $(this).children().eq(2).text();
        let requestState = $(this).children().eq(5).text();
        carID = $(this).children().eq(1).text();


        $("#requestRentId").val(requestRentId);
        $("#driverId").val(driverId);
        $("#userID").val(userID);
        $("#requestState").val(requestState);

        $("#rentID").val(requestRentId);
        $("#driverId").append(`<option>${driverId}</option>`);
        loadAllCars();
    });
}

$.ajax({
    url: RentAllManageBaseUrl + "driver/loadAvalabilityDrivers",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (res) {
        console.log(res.data);

        for (let i of res.data) {
            let driverId = i.user_Id;

            $("#driverId").append(`<option>${driverId}</option>`);
        }
    },
    error: function (error) {
        let message = JSON.parse(error.responseText).message;
        emptyMassage(message);
    }
});

$("#btnAccept").on("click", function () {
    let rentID = $("#requestRentId").val();
    let driverID = $("#driverId").val();
    $.ajax({
        url: RentAllManageBaseUrl + "rent/rentConfrom/?rentID=" + rentID + "&driverId=" + driverID,
        method: "post",
        dataType: "json",
        success: function (res) {
            saveUpdateAlert("Booking Conform", res.message);
            $("#retManage").empty();
            loadAllRentDetails();
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            emptyMassage(message);
        }
    });

});