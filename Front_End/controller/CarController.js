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
