<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Create User</title>

                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <h2>Create User</h2>

                    <!-- Sử dụng form:form để kết nối với Spring MVC Model -->
                    <form:form action="/admin/user/create" method="POST" modelAttribute="newUser">
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <!-- Sử dụng form:input cho các trường dữ liệu -->
                            <form:input type="email" class="form-control" id="email" path="email" />
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <form:input type="password" class="form-control" id="password" path="password" />
                        </div>

                        <div class="mb-3">
                            <label for="fullName" class="form-label">Full Name</label>
                            <form:input type="text" class="form-control" id="fullName" path="fullName" />
                        </div>

                        <div class="mb-3">
                            <label for="address" class="form-label">Address</label>
                            <form:input type="text" class="form-control" id="address" path="address" />
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">Phone</label>
                            <form:input type="text" class="form-control" id="phone" path="phone" />
                        </div>

                        <button type="submit" class="btn btn-primary">Create User</button>
                    </form:form>
                </div>
            </body>

            </html>