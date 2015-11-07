<%-- 
    Document   : index
    Created on : Nov 6, 2015, 9:05:21 PM
    Author     : Castelo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div>
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="css/style.css">
        </head>
        <body>
            <c:if test="${dogs == null}">
                <c:redirect url="A4LP3"></c:redirect>
            </c:if>

            <section>
                <c:forEach items="${dogs}" var="dog">
                    <article>
                        <div2>
                            <h2>${dog.getName()}</h2>
                            ${dog.getPhoto()}
                            <p1>${dog.getRace()} - ${dog.getAge()} anos</p1>
                            <p2>${dog.getDescription()}</p2>
                            <p3>${dog.getState()} - ${dog.getState().getInitials()} - ${dog.getCountry()}</p3>
                        </div2>
                    </article>
                </c:forEach>
            </section>
        </body>
    </div>
</html>
