let driverBaseUrl = "http://localhost:8083/Back_End_war/";
loadAllDrivers();

$("#btnSaveDriver").attr('disabled', true);
$("#btnUpdateDriver").attr('disabled', true);
$("#btnDeleteDriver").attr('disabled', true);


/* =========== Customer Save ============= */
$("#btnSaveDriver").click(function () {
    let formData = new FormData($("#driverForm")[0]);
    console.log(formData);
    $.ajax({
        url: driverBaseUrl + "driver",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            console.log(res)
            saveUpdateAlert("Driver", res.message);
            loadAllDrivers();
        },
        error: function (error) {
            unSuccessUpdateAlert("Driver", JSON.parse(error.responseText).message);
        }
    });
});

/* =========== User Driver Generator ============== */
function generateDriverID() {
    $("#user_Id").val("DRI-001");
    $.ajax({
        url: driverBaseUrl + "driver/driverIdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#user_Id").val("DRI-00" + tempId);
            } else if (tempId <= 99) {
                $("#user_Id").val("DRI-0" + tempId);
            } else {
                $("#user_Id").val("DRI-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}

/* ========= clear input fields Values Method =============*/
function setTextFieldValuesD(firstName, lastName, contact_No, address, email, nic_No, license_No, license_Img, driverAvailability, user_Name, password) {
    $("#firstName").val(firstName);
    $("#lastName").val(lastName);
    $("#contact_No").val(contact_No);
    $("#address").val(address);
    $("#email").val(email);
    $("#nic_No").val(nic_No);
    $("#license_No").val(license_No);
    $("#license_Img").val(license_Img);
    $("#driverAvailability").val(driverAvailability);
    $("#user_Name").val(user_Name);
    $("#password").val(password);

    $("#firstName").focus();
    checkValidity(driverValidations);
    $("#btnSaveDriver").attr('disabled', true);
}

/* ====== load all customers Method ========== */
function loadAllDrivers() {
    $("#driverTable").empty();
    $.ajax({
        url: driverBaseUrl + "driver/loadAllDrivers", method: "GET", dataType: "json", success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let user_Id = i.user_Id;
                let firstName = i.name.firstName;
                let lastName = i.name.lastName;
                let contact_No = i.contact_No;
                let address = i.address;
                let email = i.email;
                let nic_No = i.nic_No;
                let license_No = i.license_No;
                let license_Img = i.license_Img;
                let driverAvailability = i.driverAvailability;
                let role_Type = i.user.role_Type;
                let user_Name = i.user.user_Name;
                let password = i.user.password;

                let row = "<tr><td>" + user_Id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>" + contact_No + "</td><td>" + address + "</td><td>" + email + "</td><td>" + nic_No + "</td><td>" + license_No + "</td><td>" + driverAvailability + "</td><td>" + role_Type + "</td><td>" + user_Name + "</td><td>" + password + "</td></tr>";
                $("#driverTable").append(row);
            }
            blindClickEventsD();
            generateDriverID();
            setTextFieldValuesD("", "", "", "", "", "", "", "", "", "", "");
            console.log(res.message);
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }

    });
}

/* ========== Search id and Load Table ============  */
$("#search_Id").on("keypress", function (event) {
    if (event.which === 13) {
        var search = $("#search_Id").val();
        $("#driverTable").empty();
        $.ajax({
            url: driverBaseUrl + "driver/searchDriver/?driver_Id="+ search,
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (res) {
                console.log(res);
                $("#user_Id").val(res.user_Id);
                $("#firstName").val(res.name.firstName);
                $("#lastName").val(res.name.lastName);
                $("#contact_No").val(res.contact_No);
                $("#address").val(res.address);
                $("#email").val(res.email);
                $("#nic_No").val(res.nic_No);
                $("#license_No").val(res.license_No);
                $("#license_Img").prop(res.license_Img);
                $("#driverAvailability").val(res.driverAvailability);
                $("#role_Type").val(res.user.role_Type);
                $("#user_Name").val(res.user.user_Name);
                $("#password").val(res.user.password);
                let row = "<tr><td>" + res.user_Id + "</td><td>" + res.name.firstName + "</td><td>" + res.name.lastName + "</td><td>" + res.contact_No + "</td><td>" + res.address + "</td><td>" + res.email + "</td><td>" + res.nic_No + "</td><td>" + res.license_No + "</td><td>" + res.driverAvailability + "</td><td>" + res.user.role_Type + "</td><td>" + res.user.user_Name + "</td><td>" + res.user.password + "</td></tr>";
                $("#driverTable").append(row);
            },
            error: function (error) {
                loadAllDrivers();
                let message = JSON.parse(error.responseText).message;
                emptyMassage(message);
            }
        })
    }

});

/* ====== Table Listener Click and Load textFields ========= */
function blindClickEventsD() {
    $("#driverTable>tr").on("click", function () {
        let user_Id = $(this).children().eq(0).text();
        let firstName = $(this).children().eq(1).text();
        let lastName = $(this).children().eq(2).text();
        let contact_No = $(this).children().eq(3).text();
        let address = $(this).children().eq(4).text();
        let email = $(this).children().eq(5).text();
        let nic_No = $(this).children().eq(6).text();
        let license_No = $(this).children().eq(7).text();
        let driverAvailability = $(this).children().eq(8).text();
        let role_Type = $(this).children().eq(9).text();
        let user_Name = $(this).children().eq(10).text();
        let password = $(this).children().eq(11).text();

    });
    $("#btnSaveDriver").attr('disabled', true);
}