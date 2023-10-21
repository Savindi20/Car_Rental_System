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
    });
}