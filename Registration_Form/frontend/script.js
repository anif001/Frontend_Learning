
const form = document.getElementById("registrationForm");

form.addEventListener("submit", async function(event) {

    event.preventDefault();

    const email = document.getElementById("email").value;
    const mobile = document.getElementById("mobile").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return;
    }

    // create a js object..
    const student = {
        email: email,
        mobile: mobile,
        password: password
    };

    try {

        const response = await fetch(
            "http://localhost:8080/api/students/register",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(student)
            }
        );

        if (response.ok) {
            alert("Registration successful!");
            form.reset();
        } else {
            const message = await response.text();
            alert("Registration failed: " + message);
        }

    } catch (error) {
        alert("Cannot connect to the backend!");
        console.error(error);
    }

});
