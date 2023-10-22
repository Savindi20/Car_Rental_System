let baseUrlIncome = "http://localhost:8083/Back_End_war/";

document.addEventListener("DOMContentLoaded", () => {

    /* ======== Daily Income ========== */
    let dataPoints1 = [];
    let options1 = {
        animationEnabled: true, theme: "light2", title: {
            text: "Daily Sales Income"
        }, axisX: {
            valueFormatString: "YYYY MMM DD",
        }, axisY: {
            title: "LKR", titleFontSize: 20
        }, data: [{
            type: "spline", yValueFormatString: "$#,###.##", dataPoints: dataPoints1
        }]
    };
});