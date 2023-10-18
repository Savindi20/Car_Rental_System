let userbasurl = "http://localhost:8083/Back_End_war/";

let user;

$.ajax({
    url: userbasurl + "loginForm/current",
    method: "get",
    success: function (res) {
        user = res.data.user_Id;
        console.log(res.data)
        $("#search_Id").val(res.data.user_Id);
    }
});