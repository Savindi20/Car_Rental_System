let userBaseUrl = "http://localhost:8083/Back_End_war/";
loadAllRegUsers();
$("#btnSaveCustomer").attr('disabled', true);
$("#btnUpdateCustomer").attr('disabled', true);
$("#btnDeleteCustomer").attr('disabled', true);

/* ================ Customer Save ==============*/
$("#btnSaveCustomer").click(function () {
    let formData = new FormData($("#customerForm")[0]);
    console.log(formData);
    $.ajax({
        url: userBaseUrl + "reg_User",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            saveUpdateAlert("User", res.message);
            loadAllRegUsers();
        },
        error: function (error) {
            unSuccessUpdateAlert("User", JSON.parse(error.responseText).message);
        }
    });
});


/* =========== User Id Generator ================*/
function generateCustomerID() {
    $("#user_Id").val("C00-001");
    $.ajax({
        url: userBaseUrl + "reg_User/reg_UserIdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#user_Id").val("C00-00" + tempId);
            } else if (tempId <= 99) {
                $("#user_Id").val("C00-0" + tempId);
            } else {
                $("#user_Id").val("C00-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}

/* ===================== clear input fields Values Method ================*/
function setTextFieldValues(firstName, lastName, contact_No, address, email, nic, license_No, nic_Img, license_Img, user_Name, password) {
    $("#firstName").val(firstName);
    $("#lastName").val(lastName);
    $("#contact_No").val(contact_No);
    $("#address").val(address);
    $("#email").val(email);
    $("#nic").val(nic);
    $("#license_No").val(license_No);
    $("#nic_Img").val(nic_Img);
    $("#license_Img").val(license_Img);
    $("#user_Name").val(user_Name);
    $("#password").val(password);

    $("#firstName").focus();
    checkValidity(customerValidations);
    $("#btnSaveCustomer").attr('disabled', true);
}

/* =================== load all customers Method ===============*/
function loadAllRegUsers() {
    $("#customerTable").empty();
    $.ajax({
        url: userBaseUrl + "reg_User/loadAllUsers", method: "GET", dataType: "json", success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let user_Id = i.user_Id;
                let firstName = i.name.firstName;
                let lastName = i.name.lastName;
                let contact_No = i.contact_No;
                let address = i.address;
                let email = i.email;
                let nic = i.nic;
                let license_No = i.license_No;
                let nic_Img = i.nic_Img;
                let license_Img = i.license_Img;
                let role_Type = i.user.role_Type;
                let user_Name = i.user.user_Name;
                let password = i.user.password;

                let row = "<tr><td>" + user_Id + "</td><td>" + firstName + "</td><td>" + lastName + "</td><td>" + contact_No + "</td><td>" + address + "</td><td>" + email + "</td><td>" + nic + "</td><td>" + license_No + "</td><td>" + role_Type + "</td><td>" + user_Name + "</td><td>" + password + "</td></tr>";
                $("#customerTable").append(row);
            }
            blindClickEvents();
            generateCustomerID();
            setTextFieldValues("", "", "", "", "", "", "", "", "", "", "");
            console.log(res.message);
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    });
}