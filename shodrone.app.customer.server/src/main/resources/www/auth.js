async function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const messageDiv = document.getElementById('message');

    if (!username || !password) {
        messageDiv.textContent = 'Por favor, preencha ambos os campos.';
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
            // SUCESSO! Redireciona o browser para a página do dashboard.
            window.location.href = '/dashboard.html';
        } else { // Status 401 ou outro erro
            messageDiv.textContent = responseText;
            messageDiv.style.color = 'red';
        }
    } catch (error) {
        messageDiv.textContent = 'Erro de rede. Não foi possível ligar ao servidor.';
        messageDiv.style.color = 'red';
        console.error('Fetch error:', error);
    }
}
