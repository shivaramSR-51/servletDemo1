<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page isELIgnored="false" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>

</head>

<body>

    <h1>Welcome to Home Page</h1>

    <h2>Welcome <c:out value="${sessionScope.firstName}"/> <c:out value="${sessionScope.lastName}"/></h2>

    <p><strong>User ID:</strong> <c:out value="${sessionScope.userId}"/></p>

    <p><strong>Email:</strong> <c:out value="${sessionScope.email}"/></p>

    <div class="container">

        <div class="user-card">

           <h3>Phone Numbers</h3>
           <c:choose>
               <c:when test="${empty phones}">
                   <p>No phone numbers added yet.</p>
               </c:when>
               <c:otherwise>
                   <ul>
                       <c:forEach var="p" items="${phones}">
                           <li>+<c:out value="${p.phnoCode}"/> <c:out value="${p.phno}"/></li>
                       </c:forEach>
                   </ul>
               </c:otherwise>
           </c:choose>
           <button onClick=openPhonePopup()>Add Phno</button>

           <h3>Addresses</h3>
           <c:choose>
               <c:when test="${empty addresses}">
                   <p>No addresses added yet.</p>
               </c:when>
               <c:otherwise>
                   <ul>
                       <c:forEach var="a" items="${addresses}">
                           <li>
                               <c:out value="${a.street}"/>,
                               <c:out value="${a.city}"/>,
                               <c:out value="${a.country}"/> -
                               <c:out value="${a.zipcode}"/>
                           </li>
                       </c:forEach>
                   </ul>
               </c:otherwise>
           </c:choose>
           <button onClick=openAddressPopup()>Add Phno</button>
        </div>

    </div>



     <!-- PHONE POPUP -->

        <div id="phonePopup" class="popup" style="display:none;">

            <div class="popup-content">

                <button type="button" onclick="closePhonePopup()">
                    X
                </button>

                <h2>Add Phone</h2>

                <form action="phno" method="post">

                    <label>Country Code</label>
                    <input type="text" name="countryCode">

                    <br><br>

                    <label>Phone Number</label>
                    <input type="text" name="phoneNo">

                    <br><br>

                    <button type="submit">
                        Save Phone
                    </button>

                </form>

            </div>

        </div>
         <!-- ADDRESS POPUP -->

            <div id="addressPopup" class="popup" style="display:none;">

                <div class="popup-content">

                    <button type="button" onclick="closeAddressPopup()">
                        X
                    </button>

                    <h2>Add Address</h2>

                    <form action="address" method="post">

                        <label>Street</label>
                        <input type="text" name="street">

                        <br><br>

                        <label>City</label>
                        <input type="text" name="city">

                        <br><br>

                        <label>Country</label>
                        <input type="text" name="country">

                        <br><br>

                        <label>Zipcode</label>
                        <input type="text" name="zipcode">

                        <br><br>

                        <button type="submit">
                            Save Address
                        </button>

                    </form>

                </div>

            </div>


   <script >
             function openPhonePopup() {
                       document.getElementById("phonePopup").style.display = "block";
                   }
             function closePhonePopup() {
                         document.getElementById("phonePopup").style.display = "none";
                     }

             function openAddressPopup() {
                     document.getElementById("addressPopup").style.display = "block";
                 }

            function closeAddressPopup() {
                     document.getElementById("addressPopup").style.display = "none";
                 }

       </script>

</body>
</html>