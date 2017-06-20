<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang ="eng">

    <head>
        <!--Css sheets-->
        <link rel="stylesheet" href="resources/overviewCSS.css">
        <link rel="stylesheet" href="resources/bootstrap.css">
        <link rel="stylesheet" href="resources/indexCss.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Overview</title>
    </head>

    <body>

        <!--Start of navbar, rest in overviewCSS.css file-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index">Storage System</a>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active"><a href="index">Home</a></li>
                    <li><a href="overview">Overview</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">

            <div class="well">
                <!--The button for items-->
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#addmodal">Add item</button>
            </div>

            <!--start of the table-->
            <table class="table">
                <thead>
                    <tr>
                        <th>Item Name</th>
                        <th>Date of purchase</th>
                        <th>Price</th>
                        <th>Notes</th>  
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${getAllItems}" var="itemCreation">
                        <tr>
                            <td>${itemCreation.getName()}</td>
                            <td>${itemCreation.getPurchasedate()}</td>
                            <td>${itemCreation.getPrice()}</td>
                            <td>${itemCreation.getNotes()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Modal for adding new item, will be done via modal -->
            <div id="addmodal" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Add new purchase</h4>
                        </div>
                        <div class="modal-body">
                            <div>
                                <!--All of the text fields-->

                                <form method="POST" action="addItem">
                                    <div class="form-group">
                                        <label name="name">Name</label>
                                        <input required="true" class="form-control" name="name"/>
                                    </div>
                                    <div class="form-group">
                                        <label name="dop">Date of Purchase</label>
                                        <input required="true" class="form-control" name="dop"/>
                                    </div>
                                    <div class="form-group">
                                        <label name="price">Price</label>
                                        <input required="true" class="form-control" name="price"/>
                                    </div>
                                    <div class="form-group">
                                        <label name="note">Note</label>
                                        <input required="true" class="form-control" name="note"/>
                                    </div>

                                    <button type="submit" class="btn btn-primary">Add</button>
                                </form>

<!--                                <form action="addItem" method="post">
                                    Name: <input type="text" name="name"><br>
                                    Price: <input type="text" name="price"><br>
                                    Notes: <input type="text" name="notes"><br>
                                    Date: <input type="date" name="date">
                                    Button to add the object
                                    <input value="Add" type="submit" class="btn btn-primary">
                                    Button to cancel and dismiss the modal
                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                                </form>-->

                            </div>
                        </div>
                        <div class="modal-footer">                       
                        </div>    
                    </div>

                </div>
            </div>

        </div>

    </body>
</html>
