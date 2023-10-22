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

    $.ajax({
        url: baseUrlIncome + "income/dailyIncome", method: "GET", dataType: "json", success: function (res) {
            console.log(res);
            for (let i = 0; i < res.length; i++) {
                let date = res[i][0];
                let now = new Date(date);
                let newDate = now.getDate();
                let newMonth = now.getMonth() + 1;
                let newYear = now.getFullYear();
                var formattedDate = newYear + "-" + newMonth.toString().padStart(2, "0") + "-" + newDate.toString().padStart(2, "0");
                let count = res[i][1];
                let total = res[i][2];
                let row = "<tr><td>" + formattedDate + "</td><td>" + count + "</td><td>" + total + "</td></tr>";
                $("#dailyIncomeTable").append(row);

                dataPoints1.push({
                    x: new Date(res[i][0]), y: total
                });
            }
            $("#dailyIncomeChart").CanvasJSChart(options1);
        }
    });
});