<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
    <head>
        <title>Test</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
              integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
              crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
                integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
                integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
                crossorigin="anonymous"></script>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
                integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
                crossorigin="anonymous"></script>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Security Analysis</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home</a>
                    </li>
                </ul>
            </div>
        </nav>
    </head>

    <body style="margin:4;padding:2;">
        <c:if test="${empty reportObj}">
            <div class="container">
                <div class="row justify-content-center">
                    <h1>Project Not Found.</h1>
                </div>
            </div>
        </c:if>
        <c:if test="${!empty reportObj}">
            <h1 class="display-4 text-center">Api Query: ${reportObj.getProjectKey()}</h1>
            <h2 class="display-4 text-center">OWASP Category and Severity</h2>
            <hr>

            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th scope="col">Category</th>
                        <th scope="col" class="text-center">Rating</th>
                        <th scope="col" class="text-center" colspan="5">OWASP Vulnerabilities</th>
                        <th scope="col" class="text-center">HotSpots</th>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td class="text-center">Info</td>
                        <td class="text-center">Blocker</td>
                        <td class="text-center">Minor</td>
                        <td class="text-center">Major</td>
                        <td class="text-center">Critical</td>
                        <td></td>
                    </tr>
                </thead>
                <tbody class="text-center">
                    <tr>
                        <td class="text-left">A1 - Injection</td>
                        <td>${reportObj.getA1().getRating()}</td>
                        <td>${reportObj.getA1().getINFO()}</td>
                        <td>${reportObj.getA1().getBLOCKER()}</td>
                        <td>${reportObj.getA1().getMINOR()}</td>
                        <td>${reportObj.getA1().getMAJOR()}</td>
                        <td>${reportObj.getA1().getCRITICAL()}</td>

                        <td>${reportObj.getA1().getSECURITY_HOTSPOTS()}</td>
                    </tr>
                    <tr>
                        <td class="text-left">A2 - Broken Authentication
                        </td>
                        <td>${reportObj.getA2().getRating()}</td>
                        <td>${reportObj.getA2().getINFO()}</td>
                        <td>${reportObj.getA2().getBLOCKER()}</td>
                        <td>${reportObj.getA2().getMINOR()}</td>
                        <td>${reportObj.getA2().getMAJOR()}</td>
                        <td>${reportObj.getA2().getCRITICAL()}</td>

                        <td>${reportObj.getA2().getSECURITY_HOTSPOTS()}</td>
                    <tr>
                    <tr>
                        <td class="text-left">A3 - Sensitive Data Exposure
                        </td>
                        <td>${reportObj.getA3().getRating()}</td>
                        <td>${reportObj.getA3().getINFO()}</td>
                        <td>${reportObj.getA3().getBLOCKER()}</td>
                        <td>${reportObj.getA3().getMINOR()}</td>
                        <td>${reportObj.getA3().getMAJOR()}</td>
                        <td>${reportObj.getA3().getCRITICAL()}</td>

                        <td>${reportObj.getA2().getSECURITY_HOTSPOTS()}</td>
                    <tr>

                    <tr>
                        <td class="text-left">A4 - XML External Entities (XXE)
                        </td>
                        <td>${reportObj.getA4().getRating()}</td>
                        <td>${reportObj.getA4().getINFO()}</td>
                        <td>${reportObj.getA4().getBLOCKER()}</td>
                        <td>${reportObj.getA4().getMINOR()}</td>
                        <td>${reportObj.getA4().getMAJOR()}</td>
                        <td>${reportObj.getA4().getCRITICAL()}</td>

                        <td>${reportObj.getA4().getSECURITY_HOTSPOTS()}</td>
                    <tr>

                    <tr>
                        <td class="text-left">A5 - Broken Access Control
                        </td>
                        <td>${reportObj.getA5().getRating()}</td>
                        <td>${reportObj.getA5().getINFO()}</td>
                        <td>${reportObj.getA5().getBLOCKER()}</td>
                        <td>${reportObj.getA5().getMINOR()}</td>
                        <td>${reportObj.getA5().getMAJOR()}</td>
                        <td>${reportObj.getA5().getCRITICAL()}</td>

                        <td>${reportObj.getA5().getSECURITY_HOTSPOTS()}</td>
                    <tr>

                    <tr>
                        <td class="text-left">A6 - Security Misconfiguration
                        </td>
                        <td>${reportObj.getA6().getRating()}</td>
                        <td>${reportObj.getA6().getINFO()}</td>
                        <td>${reportObj.getA6().getBLOCKER()}</td>
                        <td>${reportObj.getA6().getMINOR()}</td>
                        <td>${reportObj.getA6().getMAJOR()}</td>
                        <td>${reportObj.getA6().getCRITICAL()}</td>

                        <td>${reportObj.getA6().getSECURITY_HOTSPOTS()}</td>
                    <tr>

                    <tr>
                        <td class="text-left">A7 - Cross-Site Scripting (XSS)
                        </td>
                        <td>${reportObj.getA7().getRating()}</td>
                        <td>${reportObj.getA7().getINFO()}</td>
                        <td>${reportObj.getA7().getBLOCKER()}</td>
                        <td>${reportObj.getA7().getMINOR()}</td>
                        <td>${reportObj.getA7().getMAJOR()}</td>
                        <td>${reportObj.getA7().getCRITICAL()}</td>

                        <td>${reportObj.getA7().getSECURITY_HOTSPOTS()}</td>
                    <tr>

                    <tr>
                        <td class="text-left">A8 - Insecure Deserialization
                        </td>
                        <td>${reportObj.getA8().getRating()}</td>
                        <td>${reportObj.getA8().getINFO()}</td>
                        <td>${reportObj.getA8().getBLOCKER()}</td>
                        <td>${reportObj.getA8().getMINOR()}</td>
                        <td>${reportObj.getA8().getMAJOR()}</td>
                        <td>${reportObj.getA8().getCRITICAL()}</td>

                        <td>${reportObj.getA8().getSECURITY_HOTSPOTS()}</td>
                    <tr>
                    <tr>
                        <td class="text-left">A9 - Using Components with Known Vulnerabilities
                        </td>
                        <td>${reportObj.getA9().getRating()}</td>

                        <td>${reportObj.getA9().getINFO()}</td>
                        <td>${reportObj.getA9().getBLOCKER()}</td>
                        <td>${reportObj.getA9().getMINOR()}</td>
                        <td>${reportObj.getA9().getMAJOR()}</td>
                        <td>${reportObj.getA9().getCRITICAL()}</td>


                        <td>${reportObj.getA9().getSECURITY_HOTSPOTS()}</td>
                    <tr>
                    <tr>
                        <td class="text-left">A10 - Insufficient Logging and Monitoring
                        </td>
                        <td>${reportObj.getA10().getRating()}</td>

                        <td>${reportObj.getA10().getINFO()}</td>
                        <td>${reportObj.getA10().getBLOCKER()}</td>
                        <td>${reportObj.getA10().getMINOR()}</td>
                        <td>${reportObj.getA10().getMAJOR()}</td>
                        <td>${reportObj.getA10().getCRITICAL()}</td>


                        <td>${reportObj.getA10().getSECURITY_HOTSPOTS()}</td>
                    </tr>
                </tbody>
            </table>
            <br>
        </c:if>
        <!-- Bootstrap CSS -->


        <hr>
        <p>Page generated at <%= new java.util.Date() %></p>

    </body>

</html>