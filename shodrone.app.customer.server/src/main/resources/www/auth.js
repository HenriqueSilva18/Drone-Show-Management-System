async function login() {
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');
    const messageDiv = document.getElementById('message');

    const username = usernameInput.value;
    const password = passwordInput.value;

    if (!username || !password) {
        messageDiv.textContent = 'Please fill in both fields.';
        messageDiv.style.color = 'red';
        return;
    }

    const credentials = `${username}:${password}`;

    try {
        const response = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: credentials
        });

        const responseText = await response.text();

        if (response.ok) { // Status 200 OK
            // SUCESSO! Guarda o username na sessão do navegador
            sessionStorage.setItem('loggedInUser', username);
            // Redireciona para o dashboard
            window.location.href = '/dashboard.html';
        } else { // Status 401 ou outro erro
            messageDiv.textContent = responseText;
            messageDiv.style.color = 'red';
        }
    } catch (error) {
        messageDiv.textContent = 'Network error. Could not connect to the server.';
        messageDiv.style.color = 'red';
        console.error('Fetch error:', error);
    }
}
