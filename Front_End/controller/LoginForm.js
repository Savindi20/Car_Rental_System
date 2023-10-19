let baseUrlLogin = "http://localhost:8083/Back_End_war/";


/* ============ load all customers Method ========= */

$("#btnLogin").on('click', function () {
    login();
});


function login() {
    let loginRole_Type = $("#role_Type").val();
    let loginUserName = $("#user_Name").val();
    let loginPassword = $("#password").val();
}