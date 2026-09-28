<!DOCTYPE html>
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
                Welcome ${sessionScope.firstName}
                ${sessionScope.lastName}
            </h2>

            <p>
                <strong>User ID:</strong>
                ${sessionScope.userId}
            </p>

            <p>
                <strong>Email:</strong>
                ${sessionScope.email}
            </p>

            <button class="phone-btn">
                Add Phone
            </button>

            <button class="address-btn">
                Add Address
            </button>

        </div>

    </div>

</body>
</html>