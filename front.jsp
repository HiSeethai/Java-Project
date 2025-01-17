<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Restaurant</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .menu-card {
            cursor: pointer;
            transition: transform 0.3s;
        }

        .menu-card:hover {
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Restaurant Name</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="#menu">Menu</a></li>
                    <li class="nav-item"><a class="nav-link" href="#reservation">Reservation</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="container-fluid bg-light text-center py-5">
        <h1>Welcome to Our Restaurant</h1>
        <p class="lead">Serving delicious food since 1990</p>
    </div>

    <!-- Menu Section -->
    <div class="container py-5" id="menu">
        <h2 class="text-center mb-4">Our Menu</h2>
        <div class="row" id="menu-items">
            <div class="col-md-4 mb-4">
                <div class="card menu-card" data-category="starter">
                    <img src="starter.jpg" class="card-img-top" alt="Starter">
                    <div class="card-body">
                        <h5 class="card-title">Starter Dish</h5>
                        <p class="card-text">Delicious starter to begin your meal.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card menu-card" data-category="main">
                    <img src="main.jpg" class="card-img-top" alt="Main Course">
                    <div class="card-body">
                        <h5 class="card-title">Main Course</h5>
                        <p class="card-text">Hearty and fulfilling main course.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 mb-4">
                <div class="card menu-card" data-category="dessert">
                    <img src="dessert.jpg" class="card-img-top" alt="Dessert">
                    <div class="card-body">
                        <h5 class="card-title">Dessert</h5>
                        <p class="card-text">Sweet treat to end your meal.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Reservation Form -->
    <div class="container py-5" id="reservation">
        <h2 class="text-center mb-4">Make a Reservation</h2>
        <form id="reservation-form">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" required>
            </div>
            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" class="form-control" id="date" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2024 Restaurant Name. All Rights Reserved.</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- JavaScript -->
    <script>
        // Menu filtering
        document.querySelectorAll('.menu-card').forEach(card => {
            card.addEventListener('click', () => {
                alert(`You selected: ${card.querySelector('.card-title').textContent}`);
            });
        });

        // Reservation form validation
        document.getElementById('reservation-form').addEventListener('submit', function (e) {
            e.preventDefault();
            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;
            const date = document.getElementById('date').value;

            if (name && email && date) {
                alert(`Reservation confirmed for ${name} on ${date}. Confirmation sent to ${email}.`);
                this.reset();
            } else {
                alert('Please fill in all fields.');
            }
        });
    </script>
</body>
</html>