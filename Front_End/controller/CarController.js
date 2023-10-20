let carBaseUrl = "http://localhost:8083/Back_End_war/";
loadAllCars();

$("#btnSaveCar").attr('disabled', true);
$("#btnUpdateCar").attr('disabled', true);
$("#btnDeleteCar").attr('disabled', true);

/* ========= Car Save ============== */
$("#btnSaveCar").click(function () {
    let formData = new FormData($("#carForm")[0]);
    console.log(formData);
    $.ajax({
        url: carBaseUrl + "car",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            console.log(res)
            saveUpdateAlert("Car", res.message);
            loadAllCars();
        },
        error: function (error) {
            unSuccessUpdateAlert("Car", JSON.parse(error.responseText).message);
        }
    });
});

/* =========== Car Id Generator ============ */
function generateCarID() {
    $("#car_Id").val("CAR-001");
    $.ajax({
        url: carBaseUrl + "car/carIDGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#car_Id").val("CAR-00" + tempId);
            } else if (tempId <= 99) {
                $("#car_Id").val("CAR-0" + tempId);
            } else {
                $("#car_Id").val("CAR-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}

/* ========== clear input fields Values Method =========== */
function setTextFieldValuesC(name, brand, type, front_View, back_View, side_View, interior, number_Of_Passengers, transmission_Type, fuel_Type, daily_Rate, monthly_Rate, price_Extra_KM, registration_Number, free_Mileage, color, vehicleAvailabilityType) {
    $("#name").val(name);
    $("#brand").val(brand);
    $("#type").val(type);
    $("#front_View").val(front_View);
    $("#back_View").val(back_View);
    $("#side_View").val(side_View);
    $("#interior").val(interior);
    $("#number_Of_Passengers").val(number_Of_Passengers);
    $("#transmission_Type").val(transmission_Type);
    $("#fuel_Type").val(fuel_Type);
    $("#daily_Rate").val(daily_Rate);
    $("#monthly_Rate").val(monthly_Rate);
    $("#price_Extra_KM").val(price_Extra_KM);
    $("#registration_Number").val(registration_Number);
    $("#free_Mileage").val(free_Mileage);
    $("#color").val(color);
    $("#vehicleAvailabilityType").val(vehicleAvailabilityType);

    $("#name").focus();
    checkValidity(carValidations);
    $("#btnSaveCar").attr('disabled', true);
}

/* ============= load all customers Method ============= */
function loadAllCars() {
    $("#carTable").empty();
    $.ajax({
        url: carBaseUrl + "car/loadAllCars", method: "GET", dataType: "json", success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let car_Id = i.car_Id;
                let name = i.name;
                let brand = i.brand;
                let type = i.type;
                let front_View = i.image.front_View;
                let back_View = i.image.back_View;
                let side_View = i.image.side_View;
                let interior = i.image.interior;
                let number_Of_Passengers = i.number_Of_Passengers;
                let transmission_Type = i.transmission_Type;
                let fuel_Type = i.fuel_Type;
                let daily_Rate = i.rent_Duration_Price.daily_Rate;
                let monthly_Rate = i.rent_Duration_Price.monthly_Rate;
                let price_Extra_KM = i.price_Extra_KM;
                let registration_Number = i.registration_Number;
                let free_Mileage = i.free_Mileage;
                let color = i.color;
                let vehicleAvailabilityType = i.vehicleAvailabilityType;


                let row = "<tr><td>" + car_Id + "</td><td>" + name + "</td><td>" + brand + "</td><td>" + type + "</td><td>" + number_Of_Passengers + "</td><td>" + transmission_Type + "</td><td>" + fuel_Type + "</td><td>" + daily_Rate + "</td><td>" + monthly_Rate + "</td><td>" + price_Extra_KM + "</td><td>" + registration_Number + "</td><td>" + free_Mileage + "</td><td>" + color + "</td><td>" + vehicleAvailabilityType + "</td></tr>";
                $("#carTable").append(row);
                console.log(row);
            }
            blindClickEventsC();
            generateCarID();
            setTextFieldValuesC("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
            console.log(res.message);
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    });
}

/* ============ Search id and Load Table ============ */
$("#search_Id").on("keypress", function (event) {
    if (event.which === 13) {
        var search = $("#search_Id").val();
        $("#carTable").empty();
        $.ajax({
            url: carBaseUrl + "car/searchCar/?car_Id=" + search,
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (res) {
                console.log(res);
                $("#car_Id").val(res.car_Id);
                $("#name").val(res.name);
                $("#brand").val(res.brand);
                $("#type").val(res.type);
                $("#front_View").prop(res.image.front_View);
                $("#back_View").prop(res.image.back_View);
                $("#side_View").prop(res.image.side_View);
                $("#interior").prop(res.image.interior);
                $("#number_Of_Passengers").val(res.number_Of_Passengers);
                $("#transmission_Type").val(res.transmission_Type);
                $("#fuel_Type").val(res.fuel_Type);
                $("#daily_Rate").val(res.rent_Duration_Price.daily_Rate);
                $("#monthly_Rate").val(res.rent_Duration_Price.monthly_Rate);
                $("#price_Extra_KM").val(res.price_Extra_KM);
                $("#registration_Number").val(res.registration_Number);
                $("#free_Mileage").val(res.free_Mileage);
                $("#color").val(res.color);
                $("#vehicleAvailabilityType").val(res.vehicleAvailabilityType);

                let row = "<tr><td>" + res.car_Id + "</td><td>" + res.name + "</td><td>" + res.brand + "</td><td>" + res.type + "</td><td>" + res.number_Of_Passengers + "</td><td>" + res.transmission_Type + "</td><td>" + res.fuel_Type + "</td><td>" + res.rent_Duration_Price.daily_Rate + "</td><td>" + res.rent_Duration_Price.monthly_Rate + "</td><td>" + res.price_Extra_KM + "</td><td>" + res.registration_Number + "</td><td>" + res.free_Mileage + "</td><td>" + res.color + "</td><td>" + res.vehicleAvailabilityType + "</td></tr>";
                $("#carTable").append(row);
            },
            error: function (error) {
                loadAllCars();
                let message = JSON.parse(error.responseText).message;
                emptyMassage(message);
            }
        })
    }

});

/* ============ Table Listener Click and Load textFields =============== */
function blindClickEventsC() {
    $("#carTable>tr").on("click", function () {
        let car_Id = $(this).children().eq(0).text();
        let name = $(this).children().eq(1).text();
        let brand = $(this).children().eq(2).text();
        let type = $(this).children().eq(3).text();
        let number_Of_Passengers = $(this).children().eq(4).text();
        let transmission_Type = $(this).children().eq(5).text();
        let fuel_Type = $(this).children().eq(6).text();
        let daily_Rate = $(this).children().eq(7).text();
        let monthly_Rate = $(this).children().eq(8).text();
        let price_Extra_KM = $(this).children().eq(9).text();
        let registration_Number = $(this).children().eq(10).text();
        let free_Mileage = $(this).children().eq(11).text();
        let color = $(this).children().eq(12).text();
        let vehicleAvailabilityType = $(this).children().eq(13).text();


        console.log(car_Id, name, brand, type, number_Of_Passengers, transmission_Type, fuel_Type, daily_Rate, monthly_Rate, price_Extra_KM, registration_Number, free_Mileage, color, vehicleAvailabilityType);

        $("#car_Id").val(car_Id);
        $("#name").val(name);
        $("#brand").val(brand);
        $("#type").val(type);
        $("#number_Of_Passengers").val(number_Of_Passengers);
        $("#transmission_Type").val(transmission_Type);
        $("#fuel_Type").val(fuel_Type);
        $("#daily_Rate").val(daily_Rate);
        $("#monthly_Rate").val(monthly_Rate);
        $("#price_Extra_KM").val(price_Extra_KM);
        $("#registration_Number").val(registration_Number);
        $("#free_Mileage").val(free_Mileage);
        $("#color").val(color);
        $("#vehicleAvailabilityType").val(vehicleAvailabilityType);
    });
    $("#btnSaveCar").attr('disabled', true);
}