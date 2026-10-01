<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>

</head>

<body>

    <h1>Welcome to Home Page</h1>

    <div class="container">

        <div class="user-card">

            <h2>
                Welcome ${sessionScope.firstName}${sessionScope.lastName}
            </h2>

            <p>
                <strong>User ID:</strong>
                ${sessionScope.userId}
            </p>

            <p>
                <strong>Email:</strong>
                ${sessionScope.email}
            </p>

            <button class="phone-btn" onclick="openPhonePopup()">
                Add Phone
            </button>

            <button class="address-btn" onclick="openAddressPopup()">
                Add Address
            </button>

        </div>

    </div>



     <!-- PHONE POPUP -->

        <div id="phonePopup" class="popup">

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

            <div id="addressPopup" class="popup">

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