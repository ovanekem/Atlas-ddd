<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Knoware ATLAS POC</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<c:url var="home" value="/" scope="request"/>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ATLAS</a>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h2>Welcome to the ATLAS POC</h2>
        <h3>Choose one of the actions below...</h3>
        <p>
            <a class="btn btn-default" href="#" role="button" onclick="toggleList();">List Parties</a>
            <a class="btn btn-default" href="#" role="button" onclick="toggleForm();">Add Party</a>

        </p>
    </div>
</div>

<div id="addPartyForm" class="container">
    <h2>Add a new Party to the DB</h2>
    <br>

    <form class="form-horizontal" id="add-form">
        <div class="form-group form-group-lg">
            <label class="col-sm-2 control-label">Party denomination</label>
            <div class="col-sm-10">
                <input type=text class="form-control" id="denomination">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" id="btn-add"
                        class="btn btn-primary btn-lg">Add Party
                </button>
            </div>
        </div>
    </form>

</div>
<div id="feedback"></div>

<div id="listParties" class="container">
    <table id='parties' border="1"></table>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="application/javascript">
    $(document).ready(function () {
        $("#listParties").hide();
        $("#addPartyForm").hide();

        $("#addPartyForm").submit(function (event) {
            enableAddButton(false);


            // Prevent the form from submitting via the browser.
            event.preventDefault();

            addParty();

        });
    });
    function enableAddButton(flag) {
        $("#btn-add").prop("disabled", flag);
    }

    function addParty() {

        var party = {}
        party["denomination"] = $("#denomination").val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "party/add",
            data: JSON.stringify(party),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                display(data);
            },
            error: function (e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done: function (e) {
                console.log("DONE");
                enableAddButton(true);
            }
        });

    }
    function display(data) {
        var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
        $('#feedback').html(json);
    }
    function toggleList() {
        $("#listParties").show();
        $("#addPartyForm").hide();
        $("#parties tbody").remove();

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "party/list",
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                console.log("SUCCESS: ", data);
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id
                    var denomination = data[i].denomination;
                    communicationPoints = data[i].communicationPointList;
                    for (var j = 0; j < communicationPoints.length; j++) {
                        if (communicationPoints[j].domain != null) {
                            denomination = denomination + ' (' + communicationPoints[j].address + '@' + communicationPoints[j].domain + ') ';
                        } else {
                            denomination = denomination + ' (' + communicationPoints[j].street + ',' + communicationPoints[j].houseNumber + '-' + communicationPoints[j].zip + ' ' + communicationPoints[j].city + ') ';
                        }
                    }
                    $('#parties').append('<tr><td> ' + id + ' </td> <td> ' + denomination + '</td></tr>');
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
            },
            done: function (e) {
                console.log("DONE");
            }
        });
    }
    function toggleForm() {
        $("#listParties").hide();
        $("#addPartyForm").show();

    }

</script>

</body>
</html>