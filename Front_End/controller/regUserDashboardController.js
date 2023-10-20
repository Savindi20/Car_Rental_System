let RentbaseUrl = "http://localhost:8083/Back_End_war/";

loadAllRent();
$("#updateCustomer").attr('disabled', true);

/* ========= User Id Generator ============ */
generateRentID();

function generateRentID() {
    $("#rent_Id").val("REN-001");
    $.ajax({
        url: RentbaseUrl + "rent/rentIdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#rent_Id").val("REN-00" + tempId);
            } else if (tempId <= 99) {
                $("#rent_Id").val("REN-0" + tempId);
            } else {
                $("#rent_Id").val("REN-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}

/* ========== Filter a data in Car Details =========== */
$("#fuel_Type").click(function () {
    let category_type = $("#category_type").val();
    let fuel_Type = $("#fuel_Type").val();
    console.log(category_type);
    console.log(fuel_Type);
    $("#car_Id").empty();
    $.ajax({
        url: RentbaseUrl + "car/filterCarDetails/?category_type=" + category_type + "&fuel_Type=" + fuel_Type,
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            console.log(res);

            for (let i of res) {
                let car_Id = i.car_Id;

                $("#car_Id").append(`<option>${car_Id}</option>`);
            }
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            emptyMassage(message);
        }
    })
});

/* ========= Search ============ */
$("#car_Id").click(function () {
    var search = $("#car_Id").val();
    $.ajax({
        url: RentbaseUrl + "car/searchCar/?car_Id=" + search,
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            console.log(res);
            $("#name").val(res.name);
            $("#brand").val(res.brand);
            $("#number_Of_Passengers").val(res.number_Of_Passengers);
            let url1 = res.image.front_View;
            let url2 = res.image.back_View;
            let url3 = res.image.side_View;
            let url4 = res.image.interior;
            $("#imageLoad1").css({
                "background": `url(${RentbaseUrl + url1})`, "background-size": "cover"
            });
            $("#imageLoad2").css({
                "background": `url(${RentbaseUrl + url2})`, "background-size": "cover"
            });
            $("#imageLoad3").css({
                "background": `url(${RentbaseUrl + url3})`, "background-size": "cover"
            });
            $("#imageLoad4").css({
                "background": `url(${RentbaseUrl + url4})`, "background-size": "cover"
            });
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    })
});

/* =========== Car Details ===========*/
let tableRow = [];
let car_Id;
let pickUpDate;
let pickUpTime;
let returnDate;
let returnTime;
let requestType;
let goLocation;

/* ========== Add cart ============ */
$("#btnAddCart").on("click", function () {
    let duplicate = false;
    for (let i = 0; i < $("#cartTable tr").length; i++) {
        if ($("#car_Id option:selected").text() === $("#cartTable tr").children(':nth-child(1)')[i].innerText) {
            duplicate = true;
        }
    }
    if (duplicate !== true) {
        loadCartTableDetail();
        $('#car_Id,#pickUpDate,#name,#brand,#number_Of_Passengers,#pickUpTime,#returnDate,#returnTime,#requestType,#location').val("");
        $("#cartTable").attr('disabled', true);

    } else if (duplicate === true) {
        $(tableRow).children(':nth-child(2)').text($("#pickUpDate").val());
        $(tableRow).children(':nth-child(3)').text($("#pickUpTime").val())
        $(tableRow).children(':nth-child(4)').text($("#returnDate").val());
        $(tableRow).children(':nth-child(5)').text($("#returnTime").val());
        $(tableRow).children(':nth-child(6)').text($("#requestType").val());
        $(tableRow).children(':nth-child(7)').text($("#location").val());

    }
});
