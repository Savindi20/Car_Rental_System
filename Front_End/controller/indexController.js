let carBaseUrl = "http://localhost:8083/Back_End_war/";

loadAllCars();

function loadAllCars() {
    $("#carSection").empty();
    $.ajax({
        url: carBaseUrl + "car/loadAllCars", method: "GET", dataType: "json", success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let url1 = i.image.front_View;
                $("#carSection").append(`<div data-aos="fade-up" id="carSection" class="position-relative d-flex justify-content-center mt-5 sectionBorder">
                <div class="d-flex align-items-center col-lg-12 flex-wrap justify-content-center">
                    <img class="position-relative cars-img img-fluid m-3 p-2 col-lg-5" src="${carBaseUrl + url1}"
                         href="">

                    <div class="position-relative col-xl-8 col-md-10 flex-wrap">

                        <h4 class="m-2 p-2 text-center txt-head">${i.name + " " + i.brand} <br>
                            <p><span>${i.type}</span><span>&nbsp;- &nbsp;</span><span>${i.transmission_Type}</span></p>
                        </h4>
                    </div>
                </div>
            </div>
 `);

            }
        }
    });
}