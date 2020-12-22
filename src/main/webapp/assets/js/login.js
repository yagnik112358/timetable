let login_form = document.getElementById('login-validation')

    login_form.addEventListener('submit', async (e) => {
        e.preventDefault();
        e.stopPropagation();
        if (login_form.checkValidity() === true) {
            let response = await fetch('api/students/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    email: document.getElementById('email').value,
                })
            });

            let response2 = await fetch('api/students/timetable', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({
                    email: document.getElementById('email').value,
                })
            });

            let result = await response;
            let result2 = await response2;
            if (result["status"] === 200) {
                let temp = (await response.text()).valueOf();
                let temp2 = (await response2.text()).valueOf();
                sessionStorage.setItem("jsonstring",temp2);
                location.href = "timetable.html";
            } else {
                document.getElementById("login-alert").style.display = "block";
            }
        }
    });
