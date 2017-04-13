/**
 * Created by Mordr on 13.04.2017.
 */
$(function() {
    $(document).off("click", "th");
    $(document).on("click", "th" , function() {
        var tBody = $("#table1 tbody");
        var column = $(this).index();
        var sortDirection = $(this).is('.sorted-asc') ? -1 : 1;
        var rows = tBody.find("tr");

        $.each(rows, function (index, row) {
            row.sortKey = $(row).children('td').eq(column).text().toUpperCase();
        });

        rows.sort(function(a, b) {
            if (a.sortKey.indexOf('-') == -1 && !isNaN(a.sortKey)) {
                if (parseInt(a.sortKey) < parseInt(b.sortKey)) {
                    return -sortDirection;
                }
                if (parseInt(a.sortKey) > parseInt(b.sortKey)) {
                    return sortDirection;
                }
            } else {
                if (a.sortKey < b.sortKey) {
                    return -sortDirection;
                }
                if (a.sortKey > b.sortKey) {
                    return sortDirection;
                }
            }
            return 0;
        });

        $.each(rows, function (index, row) {
            tBody.append(row);
            row.sortKey = null;
        });

        $('#table1 thead th').removeClass('sorted-asc sorted-desc')
        sortDirection == 1 ? $(this).addClass('sorted-asc') : $(this).addClass('sorted-desc');
    });

    var heightColumn = 5;

    $("#countMediumHeightBtn").click(function() {
        var tBody1 = $("#table1 tbody");
        var rows = tBody1.find("tr")
        var sum = 0, count = 0;
        $.each(rows, function (index, row) {
            var heightValue = $(row).children('td').eq(heightColumn).text();
            if ($.isNumeric(heightValue)) {
                sum = sum + parseFloat(heightValue);
                count ++;
            }
        });
        var mediumHeight = sum / count;
        $("#countMediumHeight").val(mediumHeight);
    });

    var sexColumn = 7;

    $("#showOnlyMalesBtn").click(function() {
        if ($("#humansModal").data().mode != "males") {
            var tBody1 = $("#table1 tbody");
            var tBody2 = $("#table2 tbody");

            tBody2.empty();
            var rows = tBody1.find("tr");
            $.each(rows, function (index, row) {
                var sexValue = $(row).children('td').eq(sexColumn).text();
                if (sexValue == "М") {
                    var maleRowHtml = "<tr>" + $(row).html() + "</tr>";
                    tBody2.append(maleRowHtml);
                }
            });

            $("#humansModal").data().mode = "males";
        }
        $("#humansModal").modal("show");
    });

    $("#showOnlyFemaleBtn").click(function() {
        if ($("#humansModal").data().mode != "females") {
            var tBody1 = $("#table1 tbody");
            var tBody2 = $("#table2 tbody");

            tBody2.empty();
            var rows = tBody1.find("tr");
            $.each(rows, function (index, row) {
                var sexValue = $(row).children('td').eq(sexColumn).text();
                if (sexValue == "Ж") {
                    var femaleRowHtml = "<tr>" + $(row).html() + "</tr>";
                    tBody2.append(femaleRowHtml);
                }
            });

            $("#humansModal").data().mode = "females";
        }
        $("#humansModal").modal("show");
    });

    $("td.birthDayCell").hover(
        function() {
            var birthDayTxt = $(this).text();
            var dateParts = birthDayTxt.split(".");
            var birthDay = new Date(parseInt(dateParts[2], 10), parseInt(dateParts[1], 10) - 1, parseInt(dateParts[0], 10));
            var ageDifMs = Date.now() - birthDay.getTime();
            var ageDate = new Date(ageDifMs);
            var age = Math.abs(ageDate.getUTCFullYear() - 1970);

            $(this).append("<span>(Возраст: " + age + ")</span>");
        },
        function() {
            $(this).find("span:last").remove();
        }
    );
})

